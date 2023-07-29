<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <div class="list-data">
    <div class="com-inner">
      <div class="table-responsive">
      <a href="${pageContext.request.contextPath}/post/create"
        class="btn btn-info">Create Job Post</a>
        <table id="data-table" class="table table-striped" style="width:100%">
          <thead class="table-header">
           <tr>
              <th>ID</th>
              <th>Position</th>
              <th>Offered Salary</th>
              <th>Work Experience(year)</th>
              <th>No.of Position</th>
              <th>Created At</th>
              <th>Updated At</th>
              <th>Details</th>
              <th>Actions</th>
              </tr>
          </thead>
          <tbody>
          <c:forEach items="${JobPostList}" var="jobPost" varStatus="loop">
            <tr>
                <td>${jobPost.id }</td>
                <td>${jobPost.position}</td>
                <td>${jobPost.offered_salary }</td>
                <td>${jobPost.experience_year}</td>
                <td>${jobPost.num_of_position}</td>
                <td>${jobPost.created_at}</td>
                <td>${jobPost.updated_at}</td>
                <td>
                   <a href="${pageContext.request.contextPath}/post/details?id=${jobPost.id}"><i class="fa fa-eye" aria-hidden="true"></i></a> 
                </td>
              <td>
                <a href="${pageContext.request.contextPath}/post/edit?id=${jobPost.id}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                <a href="${pageContext.request.contextPath}/post/delete?id=${jobPost.id}"
                onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false"><i class="fa fa-trash" aria-hidden="true"></i></a>
              </td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>