<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Post Creation</title>
</head>
<body>
  <div class="form-card">
    <h1 class="form-header">Create Job Post</h1>
    <c:url var="createJobPost" value="/post/create/confirm"></c:url>
    <form:form class="form-container" action="${createJobPost }"
      method="POST" id="form" modelAttribute="rollBackJobPostDto">
      <c:if test="${errorMsg != null }">
        <div class="alert custom-alert">
          <strong>${errorMsg }</strong>
        </div>
      </c:if>
      <div class="group clearfix">
        <label for="jobType">Job Type</label>
        <form:select path="jobType.id"
          value="${rollBackJobPostDto.jobType}" class="form-select">
          <c:forEach items="${JobTypeList}" var="jobType"
            varStatus="loop">
            <option value="${jobType.id }">
              ${jobType.type_name}</option>
          </c:forEach>
        </form:select>
      </div>
      <form:errors path="position" class="text-danger" />
      <div class="group clearfix">
        <label for="position">Position:</label> <br>
        <form:input path="position"
          value="${rollBackJobPostDto.position }" class="form-input"
          placeholder="Enter Job Position" />
      </div>

      <form:errors path="offered_salary" class="text-danger" />
      <div class="group clearfix">
        <label for="Offered Salary">Offered Salary:</label> <br>
        <form:input path="offered_salary"
          value="${rollBackJobPostDto.offered_salary }"
          class="form-input" placeholder="Enter your offered salary." />

      </div>

      <form:errors path="experience_year" class="text-danger" />
      <div class="group clearfix">
        <label for="experience_year">Work Experience:</label> <br>
        <form:input path="experience_year"
          value="${rollBackJobPostDto.experience_year}"
          class="form-input"
          placeholder="Enter your offered work experience." />

      </div>

      <form:errors path="num_of_position" class="text-danger" />
      <div class="group clearfix">
        <label for="num_of_position">Num Of Position:</label> <br>
        <form:input path="num_of_position"
          value="${rollBackJobPostDto.num_of_position}"
          class="form-input" placeholder="Enter your no. of vacancy." />

      </div>


      <%-- <div class="group">
        <label for="phone">Contact Phone:</label> <br>
        <input path="email" value="" class="form-input" placeholder="Enter ph number to be contacted." />
        <form:errors path="autho.id" class="text-danger" />
      </div>
      <div class="group">
        <label for="Contact Email">Contact Email:</label> <br>
        <input path="email" value="" class="form-input" placeholder="Enter eail to be contacted" />
        <form:errors path="autho.id" class="text-danger" />
      </div> --%>
      <div class="create">
        <button type="submit" class="form-btn" name="confirmJobPost">Confirm</button>
        <button type="reset" class="reset-btn" name="clear">Reset</button>
        <a class="back-btn"
          href="${pageContext.request.contextPath}/post/list">Back</a>
      </div>
    </form:form>
  </div>
</body>
</html>