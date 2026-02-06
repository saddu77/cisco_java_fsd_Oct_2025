from pages.login_page import LoginPage
from pages.dashboard_page import DashboardPage

def test_valid_login(setup):
    setup.get("https://demo.testfire.net/login.jsp")

    login = LoginPage(setup)
    dashboard = DashboardPage(setup)

    login.login("admin", "admin")

    assert "Hello Admin User" in dashboard.get_welcome_message()
