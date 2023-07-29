package cgmgl.springmvc.app.persistence.dao;

import java.util.Date;
import java.util.List;

import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;

public interface ApplicantJobPostDao {
    public void dbAddApplicantJobPost(ApplicantJobPost applicantJobPost, Date currentDate);

    public List<ApplicantJobPost> dbGetApplicantJobPostList();

    public ApplicantJobPost dbGetApplicantJobStatusById(Integer applicantJobPostId);

    public ApplicantJobPost dbGetApplicantJobPostById(Integer applicantJobPostId);
}
