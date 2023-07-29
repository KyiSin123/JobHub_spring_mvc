<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Job Type</title>
</head>
<body>
<div class="confirm-form">
  <div class="form-card">
    <h1 class="form-header">Confirm Update Job Type</h1>
    <c:url var="updateJobType" value="/jobType/update"></c:url>
    <form:form class="form-container" action="${updateJobType}" method="POST" id="form" modelAttribute="confirmEditedJobTypeDto">
    <input type="hidden" name="id"
                value="${confirmEditedJobTypeDto.id }" />
      <div class="form-group">
        <label for="type_name">Job Type:</label> <br>
        <form:input path="type_name" value="${confirmEditedJobTypeDto.type_name }" class="form-input" placeholder="Enter Job Type" />
        <form:errors path="type_name" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="description">Description:</label> <br>
        <form:input path="description" value="${confirmEditedJobTypeDto.description}" class="form-input" placeholder="Enter the description for your job." rows="6" />
        </div>
        <div class="type-confirm-btn">
          <button type="submit" class="create-btn" name="saveUpdateJobType">Update</button>
          <button type="submit" class="cancel-btn" name="cancelUpdate">Cancel</button>
        </div>
  </form:form>
  </div>
  </div>
</body>
</html>