<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content">
	<div>
		<a class="btn" href="<%=request.getContextPath()%>/">Back</a>
	</div>
	<section>
		<div>
			<h1>PROFILE VIEW</h1>
			<p>Hello, ${name}</p>
		</div>
	</section>
</div>