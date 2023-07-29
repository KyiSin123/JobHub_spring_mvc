package cgmgl.springmvc.app.bl.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;
import cgmgl.springmvc.app.persistence.entity.Company;
import cgmgl.springmvc.app.persistence.entity.JobPost;
import cgmgl.springmvc.app.persistence.entity.JobType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>JobPostDto Class</h2>
 * <p>
 * Process for Displaying JobPostDto
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPostDto {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    private int id;
    /**
     * <h2>position</h2>
     * <p>
     * position
     * </p>
     */
    @NotEmpty
    private String position;
    /**
     * <h2>offered_salary</h2>
     * <p>
     * offered_salary
     * </p>
     */
    @NotEmpty
    private String offered_salary;
    /**
     * <h2>experience_year</h2>
     * <p>
     * experience_year
     * </p>
     */
    @NotEmpty
    private String experience_year;

    /**
     * <h2>num_of_position</h2>
     * <p>
     * num_of_position
     * </p>
     */
    private int num_of_position;

    /**
     * <h2>jobType</h2>
     * <p>
     * jobType
     * </p>
     */
    private JobType jobType;
    /**
     * <h2> company</h2>
     * <p>
     * company
     * </p>
     */
    private Company company;
    /**
     * <h2>created_at</h2>
     * <p>
     * created_at
     * </p>
     */
    private Date created_at;
    
    /**
     * <h2>updated_at</h2>
     * <p>
     * updated_at
     * </p>
     */
    private Date updated_at;
    /**
     * <h2> deleted_at</h2>
     * <p>
     * deleted_at
     * </p>
     */
    private Date deleted_at;
    
    List<ApplicantJobPost> applicantsJobPosts = new ArrayList<ApplicantJobPost>();

    /**
     * <h2>Constructor for JobPostDto</h2>
     * <p>
     * Constructor for JobPostDto
     * </p>
     * 
     * @param jobPost
     */
    public JobPostDto(JobPost jobPost) {
        this.id = jobPost.getId();
        this.position = jobPost.getPosition();
        this.offered_salary = String.valueOf(jobPost.getOffered_salary());
        this.experience_year = jobPost.getExperience_year();
        this.num_of_position = jobPost.getNum_of_position();
        this.created_at = jobPost.getCreated_at();
        this.updated_at = jobPost.getUpdated_at();
        this.deleted_at = jobPost.getDeleted_at();
        this.jobType = jobPost.getJobType();
        this.company = jobPost.getCompany();
        this.applicantsJobPosts = jobPost.getApplicantsJobPosts();
    }
}