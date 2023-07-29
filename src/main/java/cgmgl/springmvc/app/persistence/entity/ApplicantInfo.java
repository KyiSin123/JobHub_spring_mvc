package cgmgl.springmvc.app.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.ApplicantProfileDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applicant_info")
public class ApplicantInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id")
	private long id;
	
	@Column(length = 9999)
	private String profile;

	private String phone;

	private String job_exp_year;

	private String job_history;

	private String edu_bg;

	private String gender;

	private String address;

	private String certificates;
	
	private Date deleted_at;
  
  @OneToMany(mappedBy = "applicantInfo")
  List<ApplicantJobPost> applicantsJobPosts = new ArrayList<ApplicantJobPost>();
	
	public ApplicantInfo(ApplicantDto applicantDto)
	{
		this.id = applicantDto.getApplicantId();
		this.profile = applicantDto.getProfile();
		this.phone = applicantDto.getPhone();
		this.job_exp_year = applicantDto.getJob_exp_year();
		this.job_history = applicantDto.getJob_history();
		this.edu_bg = applicantDto.getEdu_bg();
		this.gender = applicantDto.getGender();
		this.address = applicantDto.getAddress();
		this.certificates = applicantDto.getCertificates();
		this.deleted_at = applicantDto.getDeleted_at();
		this.applicantsJobPosts = applicantDto.getApplicantsJobPosts();
	}
	public ApplicantInfo(ApplicantInfo applicantInfo) {
		this.id = applicantInfo.getId();
		this.profile = applicantInfo.getProfile();
		this.phone = applicantInfo.getPhone();
		this.job_exp_year = applicantInfo.getJob_exp_year();
		this.job_history = applicantInfo.getJob_history();
		this.edu_bg = applicantInfo.getEdu_bg();
		this.gender = applicantInfo.getGender();
		this.address = applicantInfo.getAddress();
		this.certificates = applicantInfo.getCertificates();
		this.deleted_at = applicantInfo.getDeleted_at();
		this.applicantsJobPosts = applicantInfo.getApplicantsJobPosts();
	}
	public ApplicantInfo(ApplicantProfileDto applicantProfile) {
		this.id = applicantProfile.getApplicantId();
		this.profile = applicantProfile.getProfile();
		this.phone = applicantProfile.getPhone();
		this.address = applicantProfile.getAddress();
		this.job_exp_year = applicantProfile.getJob_exp_year();
		this.job_history = applicantProfile.getJob_history();
		this.edu_bg = applicantProfile.getEdu_bg();
		this.gender = applicantProfile.getGender();
		this.certificates = applicantProfile.getCertificates();
	}
}