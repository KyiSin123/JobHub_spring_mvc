<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring Security Example</title>
</head>
<body>
  <h3>You are not authorized to access this page.</h3>
  <a href="<%=request.getContextPath()%>/home">Go to Home Page</a>
</body>
</html>
