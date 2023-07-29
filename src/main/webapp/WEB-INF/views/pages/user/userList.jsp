<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style type="text/css">
.tab-userList {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
  margin-top: 20px;
}

.tab-userList button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

.tab-userList button:hover {
  background-color: #ddd;
}

.tab-userList button.active {
  background-color: #ccc;
}

.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
</style>
<%-- <div class="list-data">
  <div class="com-inner">
    <div class="table-responsive">
      <a href="${pageContext.request.contextPath}/createUser"
        class="btn btn-info">Add User</a>
      <table id="data-table" class="table table-striped"
        style="width: 100%">
        <thead class="table-header">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Created At</th>
            <th>Updated At</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${UserList}" var="user" varStatus="loop">
            <c:if test="${user.deleted_at == null }">
              <tr>
                <td>${user.id }</td>
                <td>${user.name }</td>
                <td>${user.email}</td>
                <c:forEach items="${user.authorities }" var="auo"
                  varStatus="loop">
                  <td>${auo.name }</td>
                </c:forEach>
                <td>${user.created_at}</td>
                <td>${user.updated_at}</td>
                <td><a
                  href="${pageContext.request.contextPath}/editUser?id=${user.id}"
                  class="btn btn-info"><i
                    class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                  <a
                  href="${pageContext.request.contextPath}/deleteUser?id=${user.id }"
                  onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false"><i
                    class="fa fa-trash" aria-hidden="true"></i></a></td>
              </tr>
            </c:if>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
 --%>
<div class="com-inner">
  <div class="tab-userList">
    <button class="tablinks" onclick="openCity(event, 'Applicant')">Applicant
      List</button>
    <button class="tablinks" onclick="openCity(event, 'Company')">Company
      List</button>
    <button class="tablinks" onclick="openCity(event, 'Admin')">Admin
      List</button>
  </div>
</div>
<!-- Tab content -->
<div id="London" class="tabcontent">
  <h3>London</h3>
  <p>London is the capital city of England.</p>
</div>

<div id="Paris" class="tabcontent">
  <h3>Paris</h3>
  <p>Paris is the capital of France.</p>
</div>

<div id="Applicant" class="tabcontent">
  <div class="list-data">
    <div class="com-inner">
      <div class="table-responsive">
        <table id="data-table" class="table table-striped"
          style="width: 100%">
          <thead class="table-header">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <!-- <th>Role</th> -->
              <th>Created At</th>
              <th>Updated At</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${UserList}" var="user" varStatus="loop">
              <c:if test="${user.deleted_at == null }">

                <c:forEach items="${user.authorities }" var="auo"
                  varStatus="loop">
                  <c:if test="${auo.id == 3 }">
                    <tr>
                      <td>${user.id }</td>
                      <td>${user.name }</td>
                      <td>${user.email}</td>

                      <td>${user.created_at}</td>
                      <td>${user.updated_at}</td>
                      <td><a
                        href="${pageContext.request.contextPath}/editUser?id=${user.id}"
                        class="btn btn-info"><i
                          class="fa fa-pencil-square-o"
                          aria-hidden="true"></i></a> <a
                        href="${pageContext.request.contextPath}/deleteUser?id=${user.id }"
                        onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false"><i
                          class="fa fa-trash" aria-hidden="true"></i></a></td>
                    </tr>
                  </c:if>
                </c:forEach>
              </c:if>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<div id="Company" class="tabcontent">
  <div class="list-data">
    <div class="com-inner">
      <div class="table-responsive">
        <table id="data-table" class="table table-striped"
          style="width: 100%">
          <thead class="table-header">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <!-- <th>Role</th> -->
              <th>Created At</th>
              <th>Updated At</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${UserList}" var="user" varStatus="loop">
              <c:if test="${user.deleted_at == null }">

                <c:forEach items="${user.authorities }" var="auo"
                  varStatus="loop">
                  <c:if test="${auo.id == 2 }">
                    <tr>
                      <td>${user.id }</td>
                      <td>${user.name }</td>
                      <td>${user.email}</td>

                      <td>${user.created_at}</td>
                      <td>${user.updated_at}</td>
                      <td><a
                        href="${pageContext.request.contextPath}/editUser?id=${user.id}"
                        class="btn btn-info"><i
                          class="fa fa-pencil-square-o"
                          aria-hidden="true"></i></a> <a
                        href="${pageContext.request.contextPath}/deleteUser?id=${user.id }"
                        onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false"><i
                          class="fa fa-trash" aria-hidden="true"></i></a></td>
                    </tr>
                  </c:if>
                </c:forEach>
              </c:if>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<div id="Admin" class="tabcontent">
  <div class="list-data">
    <div class="com-inner">
      <div class="table-responsive">
        <a href="${pageContext.request.contextPath}/createUser"
          class="btn btn-info">Add Admin</a>
        <table id="data-table" class="table table-striped"
          style="width: 100%">
          <thead class="table-header">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <!-- <th>Role</th> -->
              <th>Created At</th>
              <th>Updated At</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${UserList}" var="user" varStatus="loop">
              <c:if test="${user.deleted_at == null }">

                <c:forEach items="${user.authorities }" var="auo"
                  varStatus="loop">
                  <c:if test="${auo.id == 1 }">
                    <tr>
                      <td>${user.id }</td>
                      <td>${user.name }</td>
                      <td>${user.email}</td>

                      <td>${user.created_at}</td>
                      <td>${user.updated_at}</td>
                      <td><a
                        href="${pageContext.request.contextPath}/editUser?id=${user.id}"
                        class="btn btn-info"><i
                          class="fa fa-pencil-square-o"
                          aria-hidden="true"></i></a> <a
                        href="${pageContext.request.contextPath}/deleteUser?id=${user.id }"
                        onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false"><i
                          class="fa fa-trash" aria-hidden="true"></i></a></td>
                    </tr>
                  </c:if>
                </c:forEach>
              </c:if>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<script>
	function openCity(evt, cityName) {
		// Declare all variables
		var i, tabcontent, tablinks;

		// Get all elements with class="tabcontent" and hide them
		tabcontent = document.getElementsByClassName("tabcontent");
		for (i = 0; i < tabcontent.length; i++) {
			tabcontent[i].style.display = "none";
		}

		// Get all elements with class="tablinks" and remove the class "active"
		tablinks = document.getElementsByClassName("tablinks");
		for (i = 0; i < tablinks.length; i++) {
			tablinks[i].className = tablinks[i].className
					.replace(" active", "");
		}

		// Show the current tab, and add an "active" class to the button that opened the tab
		document.getElementById(cityName).style.display = "block";
		evt.currentTarget.className += " active";
	}
</script>