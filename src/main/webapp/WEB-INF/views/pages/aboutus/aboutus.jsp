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
  <section class="about-first-sec">
    <div class="com-inner">
      <h2 class="about-header">About Us</h2>
      <div class="clearfix">
        <div class="left-img">
          <img class="pc" src="<c:url value="/assets/img/aboutus/img_aboutus1.png" />" alt="img_aboutus1">
          <img class="sp" src="<c:url value="/assets/img/aboutus/img_sp_aboutus1.png" />" alt="img_sp_aboutus1">
        </div>
        <div class="right-txt">
          <p>Job hub is online job site and digital recruitment platform which effectively matches employers with the most suitable candidates to fill their job.
            To find the best fit for your business you need a trusted partner who understand your requirements and can translate these into an effective recuritment strategy.
            To place the right candidates at the right companies.
            Hundreds of companies and NGOs have found some of their finest employees through the JobHub.Since our clients are seeking a reliable long term partner, we have adopted a collaborative and consultative approach, and pride ourselves on outstanding customer service
          </p>
        </div>
      </div>
    </div>
  </section>
  <!--/.about-first-sec-->
  <section class="about-second-sec">
    <div class="com-inner service">
      <ul>
        <li>-To Company:Deliver the best service</li>
        <li>-To applicant:Introduce the best opportunities.</li>
        <li>-Company can post your job requirements everyday</li>
        <li>-Search the job suitable with applicant</li>
      </ul>
    </div>
  </section><!--/.about-second-sec-->
  <section class="about-third-sec">
    <div class="com-inner contact">
      <h2 class="about-header">Contact Us</h2>
      <div class="clearfix">
        <div class="contact-img">
          <img class="pc" src="<c:url value="/assets/img/aboutus/img_contactus.jpg" />" alt="img_contactus">
          <img class="sp" src="<c:url value="/assets/img/aboutus/img_sp_contactus.jpg" />" alt="img_sp_contactus.jpg">
        </div>
        <div class="contact-us">
          <ul>
            <li>
              <i class="fa-solid fa-house"></i>
              No.122, Botahtaung Pagoda Rd, Yangon
            </li>
            <li>
              <i class="fa-solid fa-phone"></i>
              +959902789012
            </li>
            <li>
              <i class="fa-solid fa-envelope"></i>
              jobhub@gmail.com
            </li>
          </ul>
        </div>
      </div>
    </div>
  </section>
</body>
</html>