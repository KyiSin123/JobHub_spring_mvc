package cgmgl.springmvc.app.bl.dto;

import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantProfileDto {
	private long applicantId;
	
	private User user; 
	
	private String profile;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String phone;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String job_exp_year;
	
	@NotEmpty
	private String job_history;
	
	@NotEmpty
	private String edu_bg;
	
	private String gender;
	
	private String certificates;
	
	public ApplicantProfileDto(User user) {
		this.applicantId = user.getApplicantInfo().getId();
		this.profile = user.getApplicantInfo().getProfile();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getApplicantInfo().getPhone();
		this.address = user.getApplicantInfo().getAddress();
		this.job_exp_year = user.getApplicantInfo().getJob_exp_year();
		this.job_history = user.getApplicantInfo().getJob_history();
		this.edu_bg = user.getApplicantInfo().getEdu_bg();
		this.gender = user.getApplicantInfo().getGender();
		this.certificates = user.getApplicantInfo().getCertificates();
	}
	
}