<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="confirm-form">
<div class="card">
  <c:url var="createUserConfirm" value="/saveAdmin"></c:url>
  <form:form class="form-create" action="${createUserConfirm }"
    method="POST" id="form" modelAttribute="userConfirmForm">
    <input type="hidden" name="id" value="${userConfirmForm.id }">
    <h1 class="profile-header">Confirm User's Registration</h1>
    <h4 class="text-center forms-header">
      <b>Confirm User Form</b>
    </h4>
    <c:if test="${errorMsg != null }">
      <div class="alert alert-danger">
        <strong>${errorMsg }</strong>
      </div>
    </c:if>
    <ul>
      <li><b>Name:</b> <a class="float-right">${userConfirmForm.username }
          <form:input path="username" type="hidden" name="username"
            value="${userConfirmForm.username }" class="form-control" />
      </a></li>
      <li><b>Email:</b> <a class="float-right">${userConfirmForm.email }
          <form:input path="email" type="hidden" name="email"
            value="${userConfirmForm.email }" class="form-control" />
      </a></li>
      <li><b>Role:</b> <c:forEach var="role"
          items="${authorityRoles}" varStatus="loop">
          <a class="float-right"> <c:if
              test="${userConfirmForm.authority.id == role.id }"> ${role.name }</c:if>
            <form:input path="authority.id" type="hidden" name="role"
              value="${userConfirmForm.authority.id }" class="form-control" />
          </a>
        </c:forEach></li>
    </ul>
    <div class="confirm-btn">
    <button type="submit" class="create-btn" name="confirmAdmin">Create</button> &nbsp;
    <button type="submit" class="cancel-btn" name="cancel">Cancel</button>
    </div>
  </form:form>
</div>
</div>