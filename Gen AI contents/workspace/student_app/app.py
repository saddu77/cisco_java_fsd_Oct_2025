from flask import Flask, request, jsonify, render_template, redirect, url_for
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

# SQLite Configuration
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///students.db"
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

db = SQLAlchemy(app)

# --------------------
# Database Model
# --------------------
class Student(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(100), nullable=False)
    age = db.Column(db.Integer)
    course = db.Column(db.String(100))

# Create DB
with app.app_context():
    db.create_all()

# --------------------
# REST API
# --------------------

# Create Student (POST)
@app.route("/api/students", methods=["POST"])
def create_student():
    data = request.json
    student = Student(
        name=data["name"],
        age=data["age"],
        course=data["course"]
    )
    db.session.add(student)
    db.session.commit()
    return jsonify({"message": "Student created"}), 201

# List Students (GET)
@app.route("/api/students", methods=["GET"])
def list_students():
    students = Student.query.all()
    result = []
    for s in students:
        result.append({
            "id": s.id,
            "name": s.name,
            "age": s.age,
            "course": s.course
        })
    return jsonify(result)

# --------------------
# UI ROUTE
# --------------------
@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        name = request.form["name"]
        age = request.form["age"]
        course = request.form["course"]

        student = Student(name=name, age=age, course=course)
        db.session.add(student)
        db.session.commit()
        return redirect(url_for("index"))

    students = Student.query.all()
    return render_template("index.html", students=students)

if __name__ == "__main__":
    app.run(debug=True)
