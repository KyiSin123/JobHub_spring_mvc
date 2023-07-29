<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Job</title>
</head>
<body>
  <section class="find-first-sec">
    <div class="com-inner clearfix">
      <div class="job-ttl">
        <h2>You can search many jobs online to find the next step
          in your career.</h2>
      </div>
      <div class="type">
        <ul class="nav-tabs clearfix">
          <c:forEach items="${JobTypeList}" var="jobType"
            varStatus="loop">
            <li><a
              href="${pageContext.request.contextPath}/post/list/byJobType?id=${jobType.id}"
              class="btn btn-info">${jobType.type_name}</a></li>
          </c:forEach>
        </ul>
        <ul class="post-list clearfix">
          <c:forEach items="${ApplicantJobPost}" var="jobPost"
            varStatus="loop">
            <li class="post tab1 heightline-post">
              <div class="clearfix">
                <table>
                  <tr>
                    <td>Position:</td>
                    <td>${jobPost.position }</td>
                  </tr>
                  <tr>
                    <td>Salary:</td>
                    <td>${jobPost.offered_salary }</td>
                  </tr>
                  <tr>
                    <td>Experience Year:</td>
                    <td>${jobPost.experience_year }</td>
                  </tr>
                </table>

                <div class="detail">
                  <i class="fa-solid fa-circle-right"></i> <a href="${pageContext.request.contextPath}/post/details?id=${jobPost.id}">More
                    details...</a>
                </div>
              </div>
            </li>
          </c:forEach>
        </ul>
        <div class="pagination">
          <ul class="pagination justify-content-center">
            <li class="list-group list-group-horizontal active"><c:forEach
                begin="${startpage}" end="${endpage}" var="p">
                <c:choose>
                  <c:when test="${JobType != null}">
                    <a class="page-link"
                      href="<c:url value="/post/list/byJobType?id=${JobType}" ><c:param name="page" value="${p -1}"/>${p}</c:url>">${p}</a>
                  </c:when>
                  <c:otherwise>
                    <a class="page-link"
                      href="<c:url value="/post/applicant/list" ><c:param name="page" value="${p - 1}"/>${p}</c:url>">${p}</a>
                  </c:otherwise>
                </c:choose>
                <%-- <a class="page-link"
                  href="<c:url value="/post/applicant/list" ><c:param name="page" value="${p}"/>${p}</c:url>">${p}</a> --%>
              </c:forEach></li>
          </ul>
        </div>
      </div>
    </div>
  </section>
</body>
</html>