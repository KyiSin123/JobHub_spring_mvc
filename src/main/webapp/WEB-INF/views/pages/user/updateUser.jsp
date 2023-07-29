<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="com-inner">
  <div class="signup-container">
    <c:url var="editUser" value="/updateUser"></c:url>
    <form:form class="form-container" action="${editUser }"
      method="POST" id="form" modelAttribute="user">
      <h1>Update Users</h1>
      <input type="hidden" name="id" value="${user.id }" />
      <div class="form-group">
        <label for="name">Name</label><br>
        <form:input path="username" value="${user.username }" type="text"
          placeholder="Please Enter Your Name" name="name"
          class="sign-input" />
      </div>
      <div class="form-group">
        <label for="email">Email</label><br>
        <form:input path="email" value="${user.email }" type="email"
          placeholder="Please Enter Email" name="email"
          class="sign-input" />
      </div>
      <div class="form-group">
        <label for="password">Password</label><br>
        <form:input path="password" value="${user.password }" type="password"
          placeholder="Pleease Enter Password" name="password"
          class="sign-input" />
      </div>
      <div class="form-group">
        <label for="confirm-password">Confirm Password</label><br>
        <form:input path="confirmPwd" value="${user.confirmPwd }" type="password"
          placeholder="Pleease Enter Password" name="password"
          class="sign-input" />
      </div>
      
      <button type="submit" name="updateUser" class="registerbtn"></button>
      <a class="btn btn-secondary" href="${pageContext.request.contextPath}/userList">Cancel</a>
    </form:form>
  </div>
</div>