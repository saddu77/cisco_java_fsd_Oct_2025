<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>User List</title></head>
<body>
<h2>User List</h2>
<a href="add">Add New User</a>
<table border="1" cellpadding="5">
<tr><th>ID</th><th>Username</th><th>Password</th><th>Actions</th></tr>
<c:forEach var="u" items="${listUsers}">
<tr>
  <td>${u.id}</td>
  <td>${u.username}</td>
  <td>${u.password}</td>
  <td>
    <a href="edit/${u.id}">Edit</a> |
    <a href="delete/${u.id}" onclick="return confirm('Delete this user?')">Delete</a>
  </td>
</tr>
</c:forEach>
</table>
</body>
</html>
