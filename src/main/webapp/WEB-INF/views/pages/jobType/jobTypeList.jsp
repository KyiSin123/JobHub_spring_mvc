<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <div class="content-wrapper">
  <section class="content">
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header">
            <h3 class="card-title">Job Type List</h3>
          </div>
          <div class="card-body">
            <div class="row">
              <div class="col-sm-12 col-md-12">
                <div class="search-sec">
                  <c:url var="addAction" value="/searchUser"></c:url>
                  <a href="${pageContext.request.contextPath}/jobType/create"
                    class="btn btn-info">Add</a>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-12">
                <table id="example1"
                  class="table table-bordered table-striped">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Job Type Name</th>
                      <th>Descriptions</th>
                      <th>CreatedAt</th>
                      <th>UpdatedAt</th>
                      <th>DeletedAt</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${JobTypeList}" var="jobType"
                      varStatus="loop">
                      <tr>
                        <td>${jobType.id }</td>
                        <td>${jobType.type_name}</td>
                        <td>${jobType.description }</td>
                        <td>${jobType.createAt}</td>
                        <td>${jobType.updateAt}</td>
                        <td>${jobType.deleteAt}</td>
                        <td class="text-right py-0 align-middle">
                          <div class="btn-group btn-group-sm">
                            <a href="${pageContext.request.contextPath}/jobType/edit?id=${jobType.id}"
                              class="btn btn-secondary">edit</a> 
                            <a href="${pageContext.request.contextPath}/jobType/delete?id=${jobType.id}"
                              onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false">delete</a>
                          </div>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</div> --%>
<div class="list-data">
    <div class="com-inner">
      <div class="table-responsive">
      <a href="${pageContext.request.contextPath}/jobType/create"
       class="btn btn-info">Create Job Type</a>
        <table id="data-table" class="table table-striped" style="width:100%">
          <thead class="table-header">
           <tr>
             <th>ID</th>
              <th>Job Type Name</th>
              <th>Descriptions</th>
              <th>CreatedAt</th>
              <th>UpdatedAt</th>
              <th>Actions</th>
             </tr>
          </thead>
          <tbody>
           <c:forEach items="${JobTypeList}" var="jobType" varStatus="loop">
              <tr>
               <td>${jobType.id }</td>
                <td>${jobType.type_name}</td>
                <td>${jobType.description }</td>
                 <td>${jobType.createAt}</td>
                 <td>${jobType.updateAt}</td>
                 <td class="text-right py-0 align-middle">
                 <div class="btn-group btn-group-sm">
                  <a href="${pageContext.request.contextPath}/jobType/edit?id=${jobType.id}"
                              class="btn btn-secondary"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a> 
                  <a href="${pageContext.request.contextPath}/jobType/delete?id=${jobType.id}"
                              onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false"><i class="fa fa-trash" aria-hidden="true"></i></a>
                  </div>
                  </td>
              </tr>
           </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>