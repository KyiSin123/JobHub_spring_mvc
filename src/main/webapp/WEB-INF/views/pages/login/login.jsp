<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="login-page">
  <div class="com-inner">
    <div class="login-container">
      <form action="<c:url value='/loginPage' />" method="POST">
        <font color="red">
          ${SPRING_SECURITY_LAST_EXCEPTION.message} </font>
        <h2 class="login-header1">login to jobhub</h2>
        <input type="text" name="useremail" placeholder="Enter email"
          class="login-input" /><br />
           <input type="password"
          name="password" placeholder="Enter password"
          class="login-input" /> <br />
           <input type="submit"
          class="login-registerbtn" value="Login" /> <input
          type="hidden" name="${_csrf.parameterName}"
          value="${_csrf.token}" />
        <div class="forgot-pass">
          <a href="<c:url value ="/loginForm/forgot_password"/>"> Forgot
            Password</a>
        </div>
        <div class="forgot-pass">
          <p>Do you have job hub account?</p>
        </div>
      </form>
      <a href="<c:url value ="/register"/>"><input type="submit"
        class="login-registerbtn" value="Sign Up" /></a>
    </div>
  </div>
  </div>
</body>
</html>
