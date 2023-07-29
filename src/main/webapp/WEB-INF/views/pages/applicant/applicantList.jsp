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
            <h3 class="card-title">Applicant List</h3>
          </div>
          <div class="card-body">
            <div class="row">
              <div class="col-sm-12 col-md-12">
                <div class="search-sec">
                  <a
                    href="${pageContext.request.contextPath}/createUser"
                    class="btn btn-info">Add</a>
                </div>
              </div>
            </div>
            <br>
            <div class="row">
              <div class="col-sm-12">
                <table id="example1"
                  class="table table-bordered table-striped">
                  <thead>
                    <tr>
                      <th>ID</th>                    
                      <th>Profile</th>
                      <th>Phone</th>
                      <th>Job Experienced Year</th>
                      <th>Job History</th>
                      <th>Edu Background</th>
                      <th>Gender</th>
                      <th>Certificates</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${ApplicantList}" var="applicant"
                      varStatus="loop">
                      <c:if test="${applicant.deleted_at == null }">
                        <tr>
                          <td>${applicant.id }</td>
                          <td>${applicant.profile }</td>
                          <td>${applicant.phone}</td>
                          <td>${applicant.job_exp_year }
                          <td>${applicant.job_history}</td>
                          <td>${applicant.edu_bg}</td>
                          <td>${applicant.gender}</td>
                          <td>${applicant.certificates}</td>
                          <td class="text-right py-0 align-middle">
                            <div class="btn-group btn-group-sm">
                              <a
                                href="${pageContext.request.contextPath}/applicant/delete?id=${applicant.id }"
                                data-target="#myModal"
                                class="btn btn-danger">Delete</a>
                            </div>
                          </td>
                        </tr>
                      </c:if>
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
      <a href="${pageContext.request.contextPath}/createUser"
        class="btn btn-info">Create Applicant</a>
      <table id="data-table" class="table table-striped"
        style="width: 100%">
        <thead class="table-header">
          <tr>
            <th>ID</th>
            <th>Phone</th>
            <th>Job Experienced Year</th>
            <th>Job History</th>
            <th>Edu Background</th>
            <th>Gender</th>
            <th>Certificates</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${ApplicantList}" var="applicant"
            varStatus="loop">
            <c:if test="${applicant.deleted_at == null }">
              <tr>
                <td>${applicant.id }</td>
                <td>${applicant.phone}</td>
                <td>${applicant.job_exp_year }
                <td>${applicant.job_history}</td>
                <td>${applicant.edu_bg}</td>
                <td>${applicant.gender}</td>
                <td>${applicant.certificates}</td>
                <td class="text-right py-0 align-middle">
                  <div class="btn-group btn-group-sm">
                    <a
                      href="${pageContext.request.contextPath}/applicant/delete?id=${applicant.id }"
                      data-target="#myModal" class="btn btn-danger"><i
                      class="fa fa-trash" aria-hidden="true"></i></a>
                  </div>
                </td>
              </tr>
            </c:if>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>