<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
	<%
		out.println("IP Address is: " + request.getRemoteAddr());		
	%>
	<h2>Current Date: <%= (new java.util.Date()).toLocaleString() %></h2>
</body>
</html>