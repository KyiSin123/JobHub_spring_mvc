package cgmgl.springmvc.app.bl.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;
import cgmgl.springmvc.app.persistence.entity.JobPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantJobPostDto {
    private int id;

    private ApplicantInfo applicantInfo;

    private JobPost jobPost;

    @NotNull
    private long expected_salary;

    private Date apply_date;

    @NotEmpty
    private String apply_reason;

    private String cv_file_name;

    private byte[] file_data;

    private String status;

    public ApplicantJobPostDto(ApplicantJobPost applicantJobPost) {
        this.id = applicantJobPost.getId();
        this.applicantInfo = applicantJobPost.getApplicantInfo();
        this.jobPost = applicantJobPost.getJobPost();
        this.expected_salary = applicantJobPost.getExpected_salary();
        this.apply_date = applicantJobPost.getApply_date();
        this.apply_reason = applicantJobPost.getApply_reason();
        this.cv_file_name = applicantJobPost.getCv_file_name();
        this.status = applicantJobPost.getStatus();
    }
}