<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <c:url value="/loginForm/password/sendEmail" var="send">
  </c:url>
  <div class="com-inner">
    <div class="email-container">
    <c:if test="${errorMsg != null}">
          <div class = "alert custom-alert">
            <span>${errorMsg }</span>
          </div>
        </c:if>
      <form:form action="${send }" modelAttribute="emailForm" id="form"
        method="post">
        <h2 class="email-header">Please Enter Email</h2>
        
        <p>
          <form:input path="user_email" type="user_email"
            name="user_email" class="email-input"
            placeholder="Enter your e-mail" />
        <div>
          <form:errors class="email-error" path="user_email" />
        </div>
        <div>
          <button type="submit" class="email-registerbtn">Send</button>
        </div>
      </form:form>
    </div>
  </div>
</body>
</html>