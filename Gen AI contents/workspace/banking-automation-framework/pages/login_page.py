from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class LoginPage(BasePage):

    USERNAME = (By.ID, "uid")
    PASSWORD = (By.ID, "passw")
    LOGIN_BTN = (By.NAME, "btnSubmit")

    def login(self, user, pwd):
        self.type(self.USERNAME, user)
        self.type(self.PASSWORD, pwd)
        self.click(self.LOGIN_BTN)
