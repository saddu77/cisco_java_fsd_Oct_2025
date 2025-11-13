<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Edit User</title></head>
<body>
<h2>Edit User</h2>
<form action="../update" method="post">
  <input type="hidden" name="id" value="${user.id}"/>
  Username: <input type="text" name="username" value="${user.username}"/><br><br>
  Password: <input type="text" name="password" value="${user.password}"/><br><br>
  <input type="submit" value="Update"/>
</form>
</body>
</html>
