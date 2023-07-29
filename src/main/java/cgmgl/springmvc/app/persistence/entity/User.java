package cgmgl.springmvc.app.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.ApplicantProfileDto;
import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.bl.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * <h2> User Class</h2>
 * <p>
 * Process for Displaying User
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@DynamicUpdate
public class User implements Serializable {

	/** Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String email;

	private String password;

	private Date created_at;

	private Date updated_at;

	private Date deleted_at;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "info_id")
	private ApplicantInfo applicantInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private List<Authority> authorities = new ArrayList<Authority>();
	
	public User(UserDto userform) {
		this.id = userform.getId();
		this.name = userform.getUsername();
		this.email = userform.getEmail();
		this.password = userform.getPassword();
		this.created_at = userform.getCreated_at();
		this.updated_at = userform.getUpdated_at();
		this.deleted_at = userform.getDeleted_at();
		this.applicantInfo = userform.getApplicantInfo();
		this.company = userform.getCompany();
		this.authorities = userform.getAuthorityList();
		
	}
	
	public User(ApplicantDto applicantForm) {
		this.id = applicantForm.getUser().getId();
		this.name = applicantForm.getUser().getName();
		this.email = applicantForm.getUser().getEmail();
		this.password = applicantForm.getUser().getPassword();
		this.created_at = applicantForm.getUser().getCreated_at();
		this.updated_at = applicantForm.getUser().getUpdated_at();
		this.deleted_at = applicantForm.getUser().getDeleted_at();
		this.applicantInfo = applicantForm.getUser().getApplicantInfo();
		this.authorities = applicantForm.getAuthorityList();
	}
	
	public User(CompanyDto companyDto) {
		this.id = companyDto.getUser().getId();
		this.name = companyDto.getUser().getName();
		this.email = companyDto.getUser().getEmail();
		this.password = companyDto.getUser().getPassword();
		this.created_at = companyDto.getUser().getCreated_at();
		this.updated_at = companyDto.getUser().getUpdated_at();
		this.deleted_at = companyDto.getUser().getDeleted_at();
		this.company = companyDto.getUser().getCompany();
		this.authorities = companyDto.getAuthorityList();
	}
	
	public User(ApplicantProfileDto applicantProfileDto) {
		this.id = applicantProfileDto.getUser().getId();
		this.name = applicantProfileDto.getName();
		this.email = applicantProfileDto.getEmail();
		this.password = applicantProfileDto.getUser().getPassword();
		this.created_at = applicantProfileDto.getUser().getCreated_at();
		this.updated_at = applicantProfileDto.getUser().getUpdated_at();
		this.deleted_at = applicantProfileDto.getUser().getDeleted_at();
		this.applicantInfo = applicantProfileDto.getUser().getApplicantInfo();
	}
}