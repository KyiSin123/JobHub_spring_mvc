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
  <div class="form-card">
    <h1 class="form-header">Applied Job Post</h1>
    <c:url var="appliedJobPost" value="/post/apply/insert?${_csrf.parameterName}=${_csrf.token}"></c:url>
    <form:form class="form-container" action="${appliedJobPost}" method="POST" id="form" modelAttribute="ApplicantJobPostDto" enctype="multipart/form-data">
    <form:input type="hidden" path="jobPost.id" name="id" value="${ApplicantJobPostDto.jobPost.id }" />
    <%-- <form method="POST" enctype="multipart/form-data" 
      action="doUpload?${_csrf.parameterName}=${_csrf.token}"> --%>
      <c:if test="${errorMsg != null }">
        <div class="alert alert-danger">
          <strong>${errorMsg }</strong>
        </div>
      </c:if>
      <form:errors path="expected_salary" class="text-danger" />
      <div class="group clearfix">
        <label for="expected_salary">Expected Salary:</label> <br>
        <form:input type="number" path="expected_salary" value="${ApplicantJobPostDto.expected_salary }" class="form-input" placeholder="Enter Expected Salary" /> 
      </div>
      <form:errors path="apply_reason" class="text-danger" />
      <div class="group clearfix">
        <label for="Offered Salary">Apply Reason:</label> <br>
        <form:input path="apply_reason" value="${ApplicantJobPostDto.apply_reason }" class="form-input" placeholder="Enter Apply Reason." /> 
      </div>
      <div class="form-group">
         <label for="cvUpload">CV File Upload</label>
         <input type="file" name="cvUpload" size="40" />
      </div>
      <div class="create">
        <button type="submit" class="form-btn" name="applyJobPost">Confirm</button>
        <button type="reset" class="reset-btn" name="clear">Reset</button>
      </div>
  </form:form>
  </div>
</body>
</html>