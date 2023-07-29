<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Company Profile</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/profile.css" />
</head>
<body>
<div class="confirm-form">
  <div class="card">
    <c:url var="companyProfile" value="/company/Profile/Update"></c:url>
    <form:form class="form-detail" action="${companyProfile}" method="POST"
      id="form" modelAttribute="CompanyProfile">
       <c:if test="${errorMsg != null }">
          <div class="alert alert-danger">
            <strong>${errorMsg }</strong>
          </div>
        </c:if>
    <h1 class="profile-header">Company Profile</h1>
    <ul class="list-group list-group-unbordered mb-3">
     <li> <a
        class="float-right"> <form:input
            path="company_id" type="hidden" name="company_id"
            value="${CompanyProfile.company_id}" class="form-control" />
      </a></li>
      <li><b>Name:</b> <a
        class="float-right">${CompanyProfile.company_name } <form:input
            path="company_name" type="hidden" name="company_name"
            value="${CompanyProfile.company_name }" class="form-control" />
      </a></li>
     <li><b>Email:</b> <a
        class="float-right">${CompanyProfile.email } <form:input
            path="email" type="hidden" name="email"
            value="${CompanyProfile.email }" class="form-control" />
      </a></li>
      <li><b>Phone Number:</b> <a
        class="float-right">${CompanyProfile.phone } <form:input
            path="phone" type="hidden" name="phone"
            value="${CompanyProfile.phone }" class="form-control" />
      </a></li>
      <li><b>Address:</b> <a
        class="float-right">${CompanyProfile.address} <form:input
            path="address" type="hidden" name="address"
            value="${CompanyProfile.address}" class="form-control" />
      </a></li>
      <li><b>Website:</b> <a
        class="float-right">${CompanyProfile.web_link} <form:input
            path="web_link" type="hidden" name="web_link"
            value="${CompanyProfile.web_link}" class="form-control" />
      </a></li>
    </ul>
    <div>
      <button type="submit" class="btn btn-info button2 button1" name="editCompany">Edit</button>
      &nbsp;
      <button type="submit" class="btn btn-secondary button2"
        name="cancel">Close</button>
    </div>
    </form:form>
  </div>
</div>
</body>
</html>