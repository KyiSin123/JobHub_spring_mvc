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
<div class="confirm-form">
  <div class="card">
    <h1 class="profile-header">Job Post Details</h1>
    <c:url var="postDetails" value="/post/apply"></c:url>
    <form:form action="${postDetails}" method="GET" id="form" modelAttribute="jobPostDetails">
    <input type="hidden" name="id" value="${jobPostDetails.id }" />
    <ul>
    <li><b>Position:</b> 
        <a class="float-right">${jobPostDetails.position } 
          <form:input path="position" type="hidden" name="position"
          value="${jobPostDetails.position }" />
        </a></li> 
    <li><b>Offered Salary:</b> 
        <a class="float-right">${jobPostDetails.offered_salary } 
          <form:input path="offered_salary" type="hidden" name="offered_salary"
          value="${jobPostDetails.offered_salary }"/>
        </a></li>
    <li><b>Offered Work Experience:</b> 
        <a class="float-right">${jobPostDetails.experience_year } 
          <form:input path="experience_year" type="hidden" name="experience_year"
          value="${jobPostDetails.experience_year }"/>
        </a></li>
    <li><b>Num Of Position:</b>
        <a class="float-right">${jobPostDetails.num_of_position } 
          <form:input path="num_of_position" type="hidden" name="num_of_position"
          value="${jobPostDetails.num_of_position }"/>
        </a></li>
    <li><b>Phone Number:</b> 
    <a class="float-right">${jobPostDetails.company.phone }
      <form:input path="company" type="hidden" name="company"
          value="${jobPostDetails.company}"
          class="form-control" />
    </a></li>
    <li><b>Email:</b> 
    <a class="float-right">${jobPostDetails.company.email } 
      <form:input path="company" type="hidden" name="company" 
      value="${jobPostDetails.company}"
          class="form-control" />
    </a></li>
  </ul>
  <div class="create">
    <button type="submit" class="apply-btn" name="applyJob">Apply</button> &nbsp; &nbsp;
    <a class="detail-back-btn" href="${pageContext.request.contextPath}/post/applicant/list">Back</a>
  </div>
  </form:form>
</div>
</div>
</body>
</html>