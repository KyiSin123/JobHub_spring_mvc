<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="list-data">
    <div class="com-inner">
      <div class="table-responsive">
      
        <table id="data-table" class="table table-striped" style="width:100%">
          <thead class="table-header">
            <tr>
              <th>company_id</th>
                      <th>company_name</th>
                      <th>email</th>
                      <th>address</th>
                      <th>phone</th>
                      <th>web_link</th>                   
                     <th>Action</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${companyList}" var="company"
                      varStatus="loop">
            <tr>
              <td>${company.company_id }</td>
                        <td>${company.company_name}</td>
                        <td>${company.email}</td>
                        <td>${company.address}</td>
                        <td>${company.phone}</td>
                        <td>${company.web_link}</td>
              <td>
                <a href="${pageContext.request.contextPath}/company/Edit-Update?company_id=${company.company_id}" class="btn btn-info"><i
                    class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                <a
                              href="${pageContext.request.contextPath}/company/Delete?company_id=${company.company_id}"
                              onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false"><i
                    class="fa fa-trash" aria-hidden="true"></i></a>
              </td>
            </tr>
            </c:forEach>
            
            
          </tbody>
        </table>
      </div>
    </div>
  </div>
