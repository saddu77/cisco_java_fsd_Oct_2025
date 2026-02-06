from selenium.webdriver.common.by import By
from pages.base_page import BasePage

class DashboardPage(BasePage):
    
    WELCOME_TEXT = (By.XPATH, "/html/body/table[2]/tbody/tr/td[2]/div/h1")

    def get_welcome_message(self):
        return self.get_text(self.WELCOME_TEXT)
