<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Post Update</title>
</head>
<body>
  <div class="form-card">
    <h1 class="form-header">Update Job Post</h1>
    <c:url var="updateJobPost" value="/post/edit/confirm"></c:url>
    <form:form class="form-container" action="${updateJobPost }" method="POST" id="form" modelAttribute="editJobPostDto">
    <input type="hidden" name="id" value="${editJobPostDto.id }" />
      <div class="group">
        <label for="jobType">Job Type</label>
        <form:select path="jobType.id" value="${editJobPostDto.jobType.id}"
         class="form-select">
            <c:forEach items="${JobTypeList}" var="jobType" varStatus="loop">
              <option value="${jobType.id }"
                <c:if test="${editJobPostDto.jobType.id == jobType.id }"> selected</c:if>>
                ${jobType.type_name}
              </option>
            </c:forEach>
          </form:select>
      </div>
      <div class="group">
        <label for="position">Position:</label> <br>
        <form:input path="position" value="${editJobPostDto.position }" class="form-input" placeholder="Enter Job Position" />
        <form:errors path="position" class="text-danger" />
      </div>
      <div class="group">
        <label for="Offered Salary">Offered Salary:</label> <br>
        <form:input path="offered_salary" value="${editJobPostDto.offered_salary }" class="form-input" placeholder="Enter your offered salary." />
        <form:errors path="offered_salary" class="text-danger" />
      </div>
      <div class="group">
        <label for="experience_year">Work Experience:</label> <br>
        <form:input path="experience_year" value="${editJobPostDto.experience_year}" class="form-input" placeholder="Enter your offered work experience." />
        <form:errors path="experience_year" class="text-danger" />
      </div>
      <div class="group">
        <label for="num_of_position">Num Of Position:</label> <br>
        <form:input path="num_of_position" value="${editJobPostDto.num_of_position}" class="form-input" placeholder="Enter your no. of vacancy." />
        <form:errors path="num_of_position" class="text-danger" />
      </div>
      <%-- <div class="form-group">
        <label for="phone">Contact Phone:</label> <br>
        <input path="email" value="" class="form-input" placeholder="Enter ph number to be contacted." />
        <form:errors path="autho.id" class="text-danger" />
      </div>
      <div class="form-group">
        <label for="Contact Email">Contact Email:</label> <br>
        <input path="email" value="" class="form-input" placeholder="Enter eail to be contacted" />
        <form:errors path="autho.id" class="text-danger" />
      </div> --%>
      <div class="create">
      <button type="submit" class="form-btn" name="editedJobPostConfirm">Confirm</button>
      <button type="reset" class="reset-btn" name="clear">Reset</button>
      <a class="back-btn" href="${pageContext.request.contextPath}/post/list">Back</a>
    </div>
  </form:form>
  </div>
</body>
</html>