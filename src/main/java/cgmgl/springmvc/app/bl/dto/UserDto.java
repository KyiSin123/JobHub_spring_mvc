package cgmgl.springmvc.app.bl.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.Authority;
import cgmgl.springmvc.app.persistence.entity.Company;
import cgmgl.springmvc.app.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>UserDto Class</h2>
 * <p>
 * Process for Displaying UserDto
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private long id;

	@NotEmpty
	private String username;

	@NotEmpty
	private String email;

	@NotEmpty
	private String password;

	@NotEmpty
	private String confirmPwd;

	private List<Authority> authorityList;

	private Authority authority;

	private Date created_at;

	private Date updated_at;

	private Date deleted_at;
	
	private ApplicantInfo applicantInfo;
	
	private Company company;

	public UserDto(User user) {
		if (user == null) {
			user = new User();
		}
		this.id = user.getId();
		this.username = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.authorityList = user.getAuthorities();
		this.applicantInfo = user.getApplicantInfo();
		this.company = user.getCompany();
		this.created_at = user.getCreated_at();
		this.updated_at = user.getUpdated_at();
		this.deleted_at = user.getDeleted_at();
	}

	/** id. */
	/*
	 * private int id;
	 * 
	 *//** username. */
	/*
	 * @NotEmpty private String username;
	 * 
	 *//** email. */
	/*
	 * @Email
	 * 
	 * @NotEmpty private String email;
	 * 
	 *//** password. */
	/*
	 * @NotEmpty
	 * 
	 * @Size(max = 20) private String password;
	 * 
	 *//** gender. */
	/*
	 * @NotNull private char gender;
	 * 
	 *//** address. */
	/*
	 * @NotEmpty private String address;
	 * 
	 *//** created at. */
	/*
	 * private Timestamp createdAt;
	 * 
	 *//** updated at. */
	/*
	 * private Timestamp updatedAt;
	 * 
	 *//**
	    * Instantiates a new user detail dto.
	    *
	    * @param user the user
	    */
	/**
	 * Getters and Setters
	 *//*
	    * 
	    * public int getId() { return id; }
	    * 
	    * public void setId(int id) { this.id = id; }
	    * 
	    * public String getUsername() { return username; }
	    * 
	    * public void setUsername(String username) { this.username = username; }
	    * 
	    * public String getEmail() { return email; }
	    * 
	    * public void setEmail(String email) { this.email = email; }
	    * 
	    * public String getPassword() { return password; }
	    * 
	    * public void setPassword(String password) { this.password = password; }
	    * 
	    * public char getGender() { return gender; }
	    * 
	    * public void setGender(char gender) { this.gender = gender; }
	    * 
	    * public String getAddress() { return address; }
	    * 
	    * public void setAddress(String address) { this.address = address; }
	    * 
	    * public Timestamp getCreatedAt() { return createdAt; }
	    * 
	    * public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
	    * 
	    * public Timestamp getUpdatedAt() { return updatedAt; }
	    * 
	    * public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }
	    */
}
