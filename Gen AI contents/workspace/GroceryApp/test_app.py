import unittest
from app import app

class GroceryAppTestCase(unittest.TestCase):

    def setUp(self):
        app.testing = True
        self.client = app.test_client()

    # TC-01 Home Page
    def test_home_page(self):
        response = self.client.get("/")
        self.assertEqual(response.status_code, 200)

    # TC-02 Add Page
    def test_add_page_loads(self):
        response = self.client.get("/add")
        self.assertEqual(response.status_code, 200)

    # TC-03 Add Grocery Item
    def test_add_item(self):
        response = self.client.post("/add", data={
            "name": "Sugar",
            "quantity": "1 Kg"
        }, follow_redirects=True)

        self.assertEqual(response.status_code, 200)
        self.assertIn(b"Sugar", response.data)

if __name__ == "__main__":
    unittest.main()
