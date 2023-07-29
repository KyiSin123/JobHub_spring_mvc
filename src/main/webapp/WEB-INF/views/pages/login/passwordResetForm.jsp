<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="com-inner">
  <div class="reset-container">
    <c:url value="/loginForm/password/reset" var="changeUrl" />
    <form:form action="${changeUrl}" method="POST"
      modelAttribute="passwordResetForm">
      <div class="pass-group">
        <h2 class="reset-header">Reset Your Password</h2>
        <c:if test="${errorMsg != null}">
          <div class = "alert custom-alert">
            <span>${errorMsg }</span>
          </div>
        </c:if>
        <form:password path="password" placeholder="Enter Password"
          class="reset-input" />
        <div>
          <form:errors class="text-pass" path="password" />
        </div>
        <form:hidden path="token" value="${passwordResetForm.token }" />
      </div>
      <div>
        <button type="submit" class="reset-registerbtn">Submit</button>
      </div>
    </form:form>
  </div>
</div>