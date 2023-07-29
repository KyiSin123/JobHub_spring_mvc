<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>
  <h3>Home Page</h3>
  <a href="<%=request.getContextPath()%>/post/create">Create JobPost</a><br><br>
  <a href="<%=request.getContextPath()%>/admin">Admin</a><br><br>
  <form action="<%=request.getContextPath()%>/logout" method="POST">
    <input type="submit" value="Logout" /> 
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
</body>
</html>
