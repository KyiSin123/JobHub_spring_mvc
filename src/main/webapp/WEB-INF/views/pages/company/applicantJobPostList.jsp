<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="list-data">
  <div class="com-inner">
    <div class="table-responsive">
      <table id="data-table" class="table table-striped"
        style="width: 100%">
        <thead class="table-header">
          <tr>
            <th>ID</th>
            <th>Applicant Name</th>
            <th>Applicant Profile</th>
            <th>Position</th>
            <th>Work Experience(year)</th>
            <th>Job History</th>
            <th>Status</th>
            <th>CV File</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${ApplicantJobPostList}"
            var="applicantJobPost" varStatus="loop">
            <tr>
              <td>${applicantJobPost.id }</td>
              <c:forEach items="${UserList}" var="userList"
                varStatus="loop">
                <c:if
                  test="${applicantJobPost.applicantInfo.id == userList.applicantInfo.id}">
                  <td>${userList.name}</td>
                </c:if>
              </c:forEach>
              <td><c:if
                  test="${empty applicantJobPost.applicantInfo.profile}">
                    <img
                    src="<c:url value="/assets/img/header/profile.png" />"
                    style="width: 100px; height: 100px;" alt="profile">
                </c:if> <%-- <c:if test="${Login.applicantInfo.profile != null}"> --%>
                <c:if
                  test="${not empty applicantJobPost.applicantInfo.profile}">
                  <img
                    src="${applicantJobPost.applicantInfo.profile }"
                    style="width: 100px; height: 100px;" alt="post_img">
                </c:if></td>
              <td>${applicantJobPost.jobPost.position }</td>
              <td>${applicantJobPost.applicantInfo.job_exp_year }</td>
              <td>${applicantJobPost.applicantInfo.job_history }</td>
              <td>${applicantJobPost.status }</td>
              <td><a
                href="${pageContext.request.contextPath}/download?id=${applicantJobPost.id}"
                class="btn btn-info">Download</a></td>
              <td>
                <%-- <a href="${pageContext.request.contextPath}/post/apply/status?id=${applicantJobPost.id}" class="btn btn-info">Details</a> --%>
                <a
                href="${pageContext.request.contextPath}/post/apply/accept?id=${applicantJobPost.id}"
                class="btn btn-success">Accept</a> <a
                href="${pageContext.request.contextPath}/post/apply/reject?id=${applicantJobPost.id }"
                class="btn btn-danger btn-ok">Reject </a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>