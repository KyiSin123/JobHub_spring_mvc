package cgmgl.springmvc.app.persistence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cgmgl.springmvc.app.bl.dto.JobPostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>JobPost Class</h2>
 * <p>
 * Process for Displaying JobPost
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_post")
public class JobPost {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * <h2>position</h2>
     * <p>
     * position
     * </p>
     */
    @Column(name = "position")
    private String position;

    /**
     * <h2>offered_salary</h2>
     * <p>
     * offered_salary
     * </p>
     */
    @Column(name = "offered_salary")
    private long offered_salary;

    /**
     * <h2>experience_year</h2>
     * <p>
     * experience_year
     * </p>
     */
    @Column(name = "experience_year")
    private String experience_year;

    /**
     * <h2>num_of_position</h2>
     * <p>
     * num_of_position
     * </p>
     */
    @Column(name = "num_of_position")
    private int num_of_position;
    /**
     * <h2>jobType</h2>
     * <p>
     * jobType
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "jobType_id", nullable = false)
    private JobType jobType;

    /**
     * <h2>company</h2>
     * <p>
     * company
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    /**
     * <h2>created_at</h2>
     * <p>
     * created_at
     * </p>
     */
    @Column(name = "created_at")
    private Date created_at;

    /**
     * <h2>updated_at</h2>
     * <p>
     * updated_at
     * </p>
     */
    @Column(name = "updated_at")
    private Date updated_at;

    /**
     * <h2>deleted_at</h2>
     * <p>
     * deleted_at
     * </p>
     */
    @Column(name = "deleted_at")
    private Date deleted_at;

    /**
     * <h2>applicantsJobPosts</h2>
     * <p>
     * applicantsJobPosts
     * </p>
     */
    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL)
    List<ApplicantJobPost> applicantsJobPosts = new ArrayList<ApplicantJobPost>();

    /**
     * <h2>Constructor for JobPost</h2>
     * <p>
     * Constructor for JobPost
     * </p>
     * 
     * @param jobPostForm
     */
    public JobPost(JobPostDto jobPostDto) {
        this.id = jobPostDto.getId();
        this.position = jobPostDto.getPosition();
        this.offered_salary = Integer.parseInt(jobPostDto.getOffered_salary());
        this.experience_year = jobPostDto.getExperience_year();
        this.num_of_position = jobPostDto.getNum_of_position();
        this.created_at = jobPostDto.getCreated_at();
        this.updated_at = jobPostDto.getUpdated_at();
        this.deleted_at = jobPostDto.getDeleted_at();
        this.jobType = jobPostDto.getJobType();
        this.company = jobPostDto.getCompany();
        this.applicantsJobPosts = jobPostDto.getApplicantsJobPosts();
    }
}