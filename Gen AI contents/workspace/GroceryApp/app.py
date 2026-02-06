# Building a Grocery App with Python Flask with  Features Add grocery item and View items 
from flask import Flask, render_template, request, redirect, url_for
import sqlite3

app = Flask(__name__)

# ---------- DATABASE SETUP ----------
def get_db_connection():
    conn = sqlite3.connect("grocery.db")
    conn.row_factory = sqlite3.Row
    return conn

def create_table():
    conn = get_db_connection()
    conn.execute("""
        CREATE TABLE IF NOT EXISTS groceries (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            quantity TEXT NOT NULL
        )
    """)
    conn.commit()
    conn.close()

create_table()

# ---------- ROUTES ----------

@app.route("/")
def index():
    conn = get_db_connection()
    items = conn.execute("SELECT * FROM groceries").fetchall()
    conn.close()
    return render_template("index.html", items=items)

@app.route("/add", methods=["GET", "POST"])
def add_item():
    if request.method == "POST":
        name = request.form["name"]
        quantity = request.form["quantity"]

        conn = get_db_connection()
        conn.execute(
            "INSERT INTO groceries (name, quantity) VALUES (?, ?)",
            (name, quantity)
        )
        conn.commit()
        conn.close()

        return redirect(url_for("index"))

    return render_template("add.html")

# ---------- MAIN ----------
if __name__ == "__main__":
    app.run(debug=True)

#  Analyze requirements for online grocery app

# 1. User Registration and Authentication: Allow users to create accounts and log in securely.
# 2. Product Catalog: Display a wide range of grocery items with images, descriptions, and prices.
# 3. Search and Filter: Enable users to search for specific items and filter results by categories, brands, or price range.
# 4. Shopping Cart: Allow users to add items to a virtual shopping cart, view cart contents, and proceed to checkout.
# 5. Payment Integration: Integrate secure payment gateways for processing transactions.
# 6. Order Tracking: Provide users with the ability to track their orders in real-time.
# 7. Customer Reviews and Ratings: Allow customers to leave reviews and ratings for products.
# 8. Inventory Management: Implement a system for managing stock levels and updating product availability.
# 9. Mobile Responsiveness: Ensure the app is responsive and works well on various devices, including smartphones and tablets.

# Create test plan for online banking app.

# Generate test cases for password reset feature. 

# Create environment setup for Python automation testing with pytest.