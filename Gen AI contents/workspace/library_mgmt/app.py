from flask import Flask, render_template, request, redirect, url_for
import sqlite3

app = Flask(__name__)
DB_NAME = "library.db"


# ---------------- DB CONNECTION ----------------
def get_db():
    conn = sqlite3.connect(DB_NAME)
    conn.row_factory = sqlite3.Row
    return conn


# ---------------- CREATE TABLES ----------------
def create_tables():
    conn = get_db()
    cur = conn.cursor()

    cur.execute("""
    CREATE TABLE IF NOT EXISTS books(
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        title TEXT,
        author TEXT,
        quantity INTEGER
    )
    """)

    cur.execute("""
    CREATE TABLE IF NOT EXISTS members(
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT,
        email TEXT
    )
    """)

    cur.execute("""
    CREATE TABLE IF NOT EXISTS transactions(
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        book_id INTEGER,
        member_id INTEGER,
        issue_date TEXT,
        return_date TEXT
    )
    """)

    conn.commit()
    conn.close()


# ---------------- HOME ----------------
@app.route("/")
def index():
    return render_template("index.html")


# ---------------- BOOKS ----------------
@app.route("/books")
def books():
    conn = get_db()
    books = conn.execute("SELECT * FROM books").fetchall()
    conn.close()
    return render_template("books.html", books=books)


@app.route("/add_book", methods=["GET", "POST"])
def add_book():
    if request.method == "POST":
        title = request.form["title"]
        author = request.form["author"]
        qty = request.form["quantity"]

        conn = get_db()
        conn.execute("INSERT INTO books(title,author,quantity) VALUES(?,?,?)",
                     (title, author, qty))
        conn.commit()
        conn.close()
        return redirect("/books")

    return render_template("add_book.html")


# ---------------- MEMBERS ----------------
@app.route("/members")
def members():
    conn = get_db()
    members = conn.execute("SELECT * FROM members").fetchall()
    conn.close()
    return render_template("members.html", members=members)


@app.route("/add_member", methods=["GET", "POST"])
def add_member():
    if request.method == "POST":
        name = request.form["name"]
        email = request.form["email"]

        conn = get_db()
        conn.execute("INSERT INTO members(name,email) VALUES(?,?)",
                     (name, email))
        conn.commit()
        conn.close()
        return redirect("/members")

    return render_template("add_member.html")


# ---------------- ISSUE BOOK ----------------
@app.route("/issue", methods=["GET", "POST"])
def issue():
    conn = get_db()
    books = conn.execute("SELECT * FROM books").fetchall()
    members = conn.execute("SELECT * FROM members").fetchall()

    if request.method == "POST":
        book_id = request.form["book_id"]
        member_id = request.form["member_id"]
        date = request.form["issue_date"]

        conn.execute("INSERT INTO transactions(book_id,member_id,issue_date) VALUES(?,?,?)",
                     (book_id, member_id, date))

        conn.execute("UPDATE books SET quantity = quantity - 1 WHERE id=?",
                     (book_id,))
        conn.commit()
        conn.close()
        return redirect("/")

    return render_template("issue_book.html", books=books, members=members)


# ---------------- RUN ----------------
if __name__ == "__main__":
    create_tables()
    app.run(debug=True)
