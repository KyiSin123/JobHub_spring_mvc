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
<title>Confirm Company Registration</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/confirm_form.css" />
</head>

<body>
<div class="confirm-form">
  <div class="card">
    <c:url var="createcompanyConfirm" value="/company/Insert"></c:url>
    <form:form class="form-detail" action="${createcompanyConfirm}" method="POST"
      id="form" modelAttribute="CompanyForm">
       <c:if test="${errorMsg != null }">
          <div class="alert alert-danger">
            <strong>${errorMsg }</strong>
          </div>
        </c:if>
      <h1 class="profile-header">Confirm Company's Registration</h1>
      <ul>
        <li><b>Company Name:</b> <a
          class="float-right">${CompanyForm.company_name } <form:input
              type="hidden" path="company_name" name="company_name"
              value="${CompanyForm.company_name }" class="form-control" />
        </a></li>
        <li><b>Company Email:</b> <a
          class="float-right">${CompanyForm.email } <form:input
              type="hidden" path="email" name="emial"
              value="${CompanyForm.email }" class="form-control" />
        </a></li>
        <li><b>Phone Number:</b> <a
          class="float-right">${CompanyForm.phone } <form:input
              type="hidden" path="phone" name="phone"
              value="${CompanyForm.phone }" class="form-control" />
        </a></li>
        <li><b>Company Address:</b> <a
          class="float-right">${CompanyForm.address } <form:input
              type="hidden" path="address" name="address"
              value="${CompanyForm.address }" class="form-control" />
        </a></li>
        <li><b>Website Link:</b> <a
          class="float-right">${CompanyForm.web_link } <form:input
              type="hidden" path="web_link" name="web_link"
              value="${CompanyForm.web_link }" class="form-control" />
        </a></li>
      </ul>
      <div class="confirm-btn">
      <button type="submit" class="create-btn" name="addCompany">Create</button>
    &nbsp;
    <button type="submit" class="cancel-btn" name="cancel">Cancel</button>
    </div>
    </form:form>
  </div>
  </div>
</body>
</html>