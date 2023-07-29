<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="com-inner">
  <div class="signup-container">
    <c:url var="register" value="/userInfo"></c:url>
    <form:form action="${register }"
      method="POST" id="form" modelAttribute="userForm">
      <h1>Sign Up with Your Role</h1>
      <c:if test="${errorMsg != null }">
        <div class="alert custom-alert">
          <strong>${errorMsg }</strong>
        </div>
      </c:if>
      <div class="form-group">
        <label for="name">Name</label><br>
        <form:input path="username" value="${userForm.username }"
          type="text" placeholder="Please Enter Your Name" name="name"
          class="sign-input" />
        <form:errors path="username" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="email">Email</label><br>
        <form:input path="email" value="${userForm.email }" type="email"
          placeholder="Please Enter Email" name="email"
          class="sign-input" />
        <form:errors path="email" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="password">Password</label><br>
        <form:input path="password" value="${userForm.password }"
          type="password" placeholder="Pleease Enter Password"
          name="password" class="sign-input" />
        <form:errors path="password" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="confirm-password">Confirm Password</label><br>
        <form:input path="confirmPwd" value="${userForm.confirmPwd }"
          type="password" placeholder="Pleease Enter Password"
          name="password" class="sign-input" />
        <form:errors path="confirmPwd" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="role">Select Role:</label><br>
        <form:select path="authority.id" value="${userForm.authority }"
          class="sign-select">
          <c:forEach var="role" items="${authorityRoles}"
            varStatus="loop">
            <form:option value="${role.id}" label="${role.name}" />
          </c:forEach>
        </form:select>
      </div>
      <button type="submit" name="signup" class="registerbtn">Sign
        Up</button>
      <div class="forgot-pass">
        <a href="<%=request.getContextPath()%>/login" class="forgot-pass">Already have
          an account?log In</a>
      </div>
    </form:form>
  </div>
</div>