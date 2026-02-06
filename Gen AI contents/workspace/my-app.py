from flask import Flask, request, jsonify

app = Flask(__name__)

students = []

# Endpoint to add a student
@app.route('/students', methods=['POST'])
def add_student():
    student = request.get_json()
    students.append(student)
    return jsonify({
        "message": "Student added successfully",
        "student": student
    }), 201

# Endpoint to list all students
@app.route('/students', methods=['GET'])
def get_students():
    return jsonify(students), 200

if __name__ == "__main__":
    app.run(debug=True, port=3000)
