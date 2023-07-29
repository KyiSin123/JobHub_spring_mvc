<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
.fix-image {
  width: 200px;
  height: 200px;
}
</style>
<div class="form-card">
  <h1 class="form-header applicant-header">Applicant's Registration
  </h1>
  <c:url var="applicantInfo" value="/applicantInfoSave"></c:url>
  <form:form class="form-container" action="${applicantInfo }"
    method="POST" id="form" modelAttribute="applicantInfoForm">
    <c:if test="${errorMsg != null }">
      <div class="alert custom-alert">
        <strong>${errorMsg }</strong>
      </div>
    </c:if>
    <form:input type="hidden" path="user.name" value="${user.username}" />
    <form:input type="hidden" path="user.email" value="${user.email}" />
    <form:input type="hidden" path="user.password"
      value="${user.password}" />
    <form:input type="hidden" path="authority.id"
      value="${user.authority.id }" />
    <div class="group">
      <div>
        <input type="file" name="fileUpload" id="fileUpload"
          accept="image/*" value="${imageData }"
          class="input image-input" onchange="showImage.call(this)" />
        <input name="imageData" type="hidden" id="imageData" value="" />
      </div>
      <div>
        <img src="${applicantInfoForm.profile}" id="post_img" />
      </div>
      <form:input id="post-image" path="profile" type="hidden"
        value="${imageData}" />
    </div>
    <form:errors path="phone" class="text-danger" />
    <div class="group clearfix">
      <label for="Phone No">Phone No:</label> <br>
      <form:input path="phone" value="${applicantInfoForm.phone }"
        class="form-input" placeholder="Enter Your Ph Number" />      
    </div>
    <form:errors path="address" class="text-danger" />
    <div class="group clearfix">
      <label for="company name">Address:</label> <br>
      <form:input path="address" value="${applicantInfoForm.address }"
        class="form-input" placeholder="Enter Your Address" />    
    </div>
    <div class="group clearfix">
      <label for="email">Gender:</label> <br>
      <form:select name="gender" path="gender"
        value="${applicantInfoForm.gender }" class="form-select">
        <option>MALE</option>
        <option>FEMALE</option>
      </form:select>
    </div>
    <form:errors path="job_exp_year" class="text-danger" />
    <div class="group clearfix">
      <label for="experience_year">Job Experience(Year):</label> <br>
      <form:input path="job_exp_year"
        value="${applicantInfoForm.job_exp_year }" class="form-input"
        placeholder="Enter Your Experience(Year)" />     
    </div>
    <form:errors path="job_history" class="text-danger" />
    <div class="group clearfix">
      <label for="job_history">Job History:</label> <br>
      <form:textarea path="job_history"
        value="${applicantInfoForm.job_history }" class="form-textarea"
        placeholder="Mention your previous jobs" rows="3" />      
    </div>
    <form:errors path="edu_bg" class="text-danger" />
    <div class="group clearfix">
      <label for="edu_bg">Education Background:</label> <br>
      <form:textarea path="edu_bg" value="${applicantInfoForm.edu_bg }"
        class="form-textarea" placeholder="Enter Your Edu Background."
        rows="3" />      
    </div>
    <form:errors path="certificates" class="text-danger" />
    <div class="group clearfix">
      <label for="certificates">Certificates:</label> <br>
      <form:textarea path="certificates"
        value="${applicantInfoForm.certificates }" class="form-textarea"
        placeholder="Mention the Certificates you got." rows="3" />      
    </div>
    <div class="create">
      <button type="submit" class="form-btn" name="addApplicant">Create</button>
      <button type="reset" class="reset-btn" name="clear">Reset</button>
    </div>
  </form:form>
</div>
<script type="text/javascript">
	$(document).ready(function() {

		$('#fileUpload').change(function() {
			showImgThumbnail(this);
		});

		var valImg = $('#post-image').val();
		if (valImg != '') {
			$('#post_img').attr('class', 'fix-image');
		}
	});

	function showImgThumbnail(fileInput) {
		file = fileInput.files[0];
		reader = new FileReader();
		reader.onload = function(e) {
			$('#post_img').attr('src', e.target.result);
			$('#post_img').attr('class', 'fix-image');
		};
		reader.readAsDataURL(file);
	}
	function showImage() {
		if (this.files && this.files[0]) {
			var obj = new FileReader();
			obj.onload = function(data) {
				document.getElementById("imageData").value = data.target.result;
			}
			obj.readAsDataURL(this.files[0]);
		}
	}
</script>