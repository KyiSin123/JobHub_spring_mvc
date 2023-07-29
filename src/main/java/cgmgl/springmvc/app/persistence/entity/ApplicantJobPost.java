package cgmgl.springmvc.app.persistence.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cgmgl.springmvc.app.bl.dto.ApplicantJobPostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>ApplicantJobPost Class</h2>
 * <p>
 * Process for Displaying ApplicantJobPost
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
@Table(name = "applicant_jobpost")
public class ApplicantJobPost {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @Column(name = "applicantJob_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * <h2>applicantInfo</h2>
     * <p>
     * applicantInfo
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private ApplicantInfo applicantInfo;

    /**
     * <h2>jobPost</h2>
     * <p>
     * jobPost
     * </p>
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "jobPost_id")
    private JobPost jobPost;

    /**
     * <h2>expected_salary</h2>
     * <p>
     * expected_salary
     * </p>
     */
    @Column(name = "expected_salary")
    private long expected_salary;

    /**
     * <h2>apply_date</h2>
     * <p>
     * apply_date
     * </p>
     */
    @Column(name = "apply_date")
    private Date apply_date;

    /**
     * <h2>apply_reason</h2>
     * <p>
     * apply_reason
     * </p>
     */
    @Column(name = "apply_reason")
    private String apply_reason;

    /**
     * <h2>cv_file_name</h2>
     * <p>
     * cv_file_name
     * </p>
     */
    @Column(name = "cv_file_name")
    private String cv_file_name;

    /**
     * <h2>file_data</h2>
     * <p>
     * file_data
     * </p>
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "file_data", nullable = false)
    private byte[] file_data;

    /**
     * <h2>status</h2>
     * <p>
     * status
     * </p>
     */
    @Column(name = "status")
    private String status;

    /**
     * <h2>Constructor for ApplicantJobPost</h2>
     * <p>
     * Constructor for ApplicantJobPost
     * </p>
     * 
     * @param applicantJobPostDto
     */
    public ApplicantJobPost(ApplicantJobPostDto applicantJobPostDto) {
        this.id = applicantJobPostDto.getId();
        this.applicantInfo = applicantJobPostDto.getApplicantInfo();
        this.jobPost = applicantJobPostDto.getJobPost();
        this.expected_salary = applicantJobPostDto.getExpected_salary();
        this.apply_date = applicantJobPostDto.getApply_date();
        this.apply_reason = applicantJobPostDto.getApply_reason();
        this.cv_file_name = applicantJobPostDto.getCv_file_name();
        this.status = applicantJobPostDto.getStatus();
        this.file_data = applicantJobPostDto.getFile_data();
    }
}