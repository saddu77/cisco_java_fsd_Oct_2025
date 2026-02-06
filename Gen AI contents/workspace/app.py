#  create flask complete app with home route and main method

from flask import Flask

# Create Flask app
app = Flask(__name__)

# Home Route
@app.route("/")
def home():
    return "Welcome to My Flask App!"

# Main Method
if __name__ == "__main__":
    app.run(debug=True)

