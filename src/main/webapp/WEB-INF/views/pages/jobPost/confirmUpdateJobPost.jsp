<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Job Post Update</title>
</head>
<body>
<div class="confirm-form">
  <div class="form-card">
    <h1 class="job-confirm">Confirm Update Job Post</h1>
    <c:url var="confirmUpdateJobPost" value="/post/update"></c:url>
    <form:form class="form-container" action="${confirmUpdateJobPost }" method="POST" id="form" modelAttribute="confirmEditedJobPostDto">
      <input type="hidden" name="id"
                value="${confirmEditedJobPostDto.id }" />
      <div class="form-group">
        <label for="jobType">Job Type</label>
        <form:select path="jobType.id" value="${confirmEditedJobPostDto.jobType}"
         class="form-select">
            <c:forEach items="${JobTypeList}" var="jobType" varStatus="loop">
              <option value="${jobType.id }"
              <c:if test="${confirmEditedJobPostDto.jobType.id == jobType.id }"> selected</c:if>>
              ${jobType.type_name}</option>
            </c:forEach>
          </form:select>
      </div>
      <div class="form-group">
        <label for="position">Position:</label> <br>
        <form:input path="position" value="${confirmEditedJobPostDto.position }" class="form-input" placeholder="Enter Job Position" />
        <form:errors path="position" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="Offered Salary">Offered Salary:</label> <br>
        <form:input path="offered_salary" value="${confirmEditedJobPostDto.offered_salary }" class="form-input" placeholder="Enter your offered salary." />
        <form:errors path="offered_salary" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="experience_year">Work Experience:</label> <br>
        <form:input path="experience_year" value="${editJobPostDto.experience_year}" class="form-input" placeholder="Enter your offered work experience." />
        <form:errors path="experience_year" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="num_of_position">Num Of Position:</label> <br>
        <form:input path="num_of_position" value="${confirmEditedJobPostDto.num_of_position}" class="form-input" placeholder="Enter your no. of vacancy." />
        <form:errors path="num_of_position" class="text-danger" />
      </div>
      <div class="confirm-btn">
      <button type="submit" class="form-btn" name="saveUpdateJobPost">Update</button>
      <button type="submit" class="" name="cancelUpdate">Cancel</button>
      </div>
  </form:form>
  </div>
  </div>
</body>
</html>