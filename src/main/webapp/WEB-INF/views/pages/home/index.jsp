<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <section class="home-first-sec">
    <div class="com-inner clearfix">
      <div class="left-content">
        <h1 class="com-ttl">Job Hub</h1>
        <h2>Explore and discover the right job for you!</h2>
        <p>The job marketplace and community that connects and matches companies with remote professionals</p>
        <p class="main-content">Forget the old rules. You can have the best people.Right now. Right here.</p>
        <a class="com-btn" href ="<%=request.getContextPath()%>/post/applicant/list">Find Job</a>
      </div>
      <div class="right-img">
        <img src="<c:url value="/assets/img/home/img_right_main.png" />" alt="img_right_main"/>
      </div>
    </div>
  </section>
  <!--/.main-visual-->
  <section class="home-second-sec">
    <div class="com-inner">
      <h2 class="com-ttl">Job Category</h2>
      <h3>Looking for work?</h3>
      <p>Find your career</p>
      <%-- <ul class="cate-list clearfix">
        <li class="left-cate category">
          <img src="<c:url value="/assets/img/home/img_it_development.jpg"/>" alt="img_it_development"/>
          <h4>IT and Development</h4>
        </li>
        <li class="mid-cate category">
          <img src=" <c:url value="/assets/img/home/img_sales_marketing.jpg"/>" alt="img_sales_marketing">
          <h4>Sales and Marketing</h4>
        </li>
        <li class="right-cate category">
          <img src="<c:url value="/assets/img/home/img_translator.jpg"/>" alt="img_translator">
          <h4>Translator</h4>
        </li>
      </ul> --%>
      <ul class="cate-list clearfix">      
          <c:forEach items="${JobTypeList}" var="jobType" varStatus="loop">
            <li class="left-cate category heightline-post">
            <a class="jobType" href="${pageContext.request.contextPath}/post/list/byJobType?id=${jobType.id}">${jobType.type_name}</a></li>
          </c:forEach>
        </ul>
    </div>
  </section>
  <!--/.home-second-sec-->
  <div class="slider-img">
    <div class="com-inner">
      <div class="autoplay slider-list">
        <div class="item"><img src="<c:url value="/assets/img/slide/img_slide1.jpg"/>" alt="img_slide1"/></div>
        <div class="item"><img src="<c:url value="/assets/img/slide/img_slide2.jpg"/>" alt="img_slide1"/></div>
        <div class="item"><img src="<c:url value="/assets/img/slide/img_slide3.jpg"/>" alt="img_slide3"></div>
        <div class="item"><img src="<c:url value="/assets/img/slide/img_slide4.jpg"/>" alt="img_slide4"></div>
        <div class="item"><img src="<c:url value="/assets/img/slide/img_slide5.jpg"/>" alt="img_slide5"></div>
        <div class="item"><img src="<c:url value="/assets/img/slide/img_slide6.jpg"/>" alt="img_slide6"></div>
      </div>
    </div>
  </div>
  <section class="home-third-sec">
    <div class="com-inner">
      <h3 class="com-ttl">About Us</h3>
      <div class="clearfix about">
        <div class="about-content">
          <p>Our mission to create economic opportunities so people have better lives has taken us so much further. We foster a collaborative workplace that strives to create the best experience for job seekers.</p>
          <a href="${pageContext.request.contextPath}/aboutus"><i class="fa-solid fa-circle-right"></i> &nbsp; &nbsp;More...</a>
        </div>
        <div class="about-img">
          <img src="<c:url value="/assets/img/home/img_about.jpg"/>" alt="img_about">
        </div>
      </div>
    </div>
  </section>
</body>
</html>