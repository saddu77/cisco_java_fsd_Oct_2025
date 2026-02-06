def login(username, password): 
    if username == "admin" and password == "1234": 
        return "Success" 
    return "Fail" 

# Write pytest unit tests for login function