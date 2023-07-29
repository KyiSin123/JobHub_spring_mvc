<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Job Post</title>
</head>
<body>
<div class="confirm-form">
  <div class="card">
    <h1 class="profile-header">Confirm Job Post</h1>
    <c:url var="insert" value="/post/insert"></c:url>
    <form:form class="form-create" action="${insert }" method="POST" id="form" modelAttribute="jobPostDto">
      <input type="hidden" name="id" value="${jobPostDto.id }">
      <c:if test="${errorMsg != null }">
        <div class="alert alert-danger">
          <strong>${errorMsg }</strong>
        </div>
      </c:if>
      
        <ul>
        <li><b>Job Type:</b>
          <form:select path="jobType.id" value="${jobPostDto.jobType}"
         class="form-select">
            <c:forEach items="${JobTypeList}" var="jobType" varStatus="loop">
              <option value="${jobType.id }"
              <c:if test="${jobPostDto.jobType.id == jobType.id }"> selected</c:if>>
              ${jobType.type_name}</option>
            </c:forEach>
          </form:select>
        </li>
        <li><b>Position:</b> 
        <a class="float-right">${jobPostDto.position } 
        <form:input path="position" type="hidden" name="position"
              value="${jobPostDto.position }" class="form-control" />
        </a></li>
        <li><b>Offered Salary:</b> 
        <a class="float-right">${jobPostDto.offered_salary } 
        <form:input path="offered_salary" type="hidden" name="offered_salary"
              value="${jobPostDto.offered_salary }" class="form-control" />
        </a></li>
        <li><b>Offered Work Experience(Year):</b> 
        <a class="float-right">${jobPostDto.experience_year }
        <form:input path="experience_year" type="hidden" name="experience_year"
              value="${jobPostDto.experience_year }" class="form-control" />
        </a></li>
        <li><b>Number of Position:</b> 
        <a class="float-right">${jobPostDto.num_of_position } 
        <form:input path="num_of_position" type="hidden" name="num_of_position"
        value="${jobPostDto.num_of_position }"
class="form-control" />
        </a></li>
        <%-- <li class="list-group-item"><b>Contact Phone:</b> <a
      class="float-right">${jobPostForm.username } 
      <form:input
          path="username" type="hidden" name="username"
          value="${jobPostForm.username }"
          class="form-control" />
    </a></li>
    <li class="list-group-item"><b>Contact Email:</b> 
    <a class="float-right">${jobPostForm.username } 
    <form:input
          path="username" type="hidden" name="username"
          value="${jobPostForm.username }"
          class="form-control" />
    </a></li> --%>
      </ul>
      <div class="confirm-btn">
        <button type="submit" class="create-btn" name="addJobPost">Create JobPost</button> &nbsp;
        <button type="submit" class="cancel-btn" name="cancel">Cancel</button>
      </div>
    </form:form>
    </div>
  </div>
</body>
</html>