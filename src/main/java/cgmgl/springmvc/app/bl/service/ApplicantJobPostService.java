package cgmgl.springmvc.app.bl.service;

import java.util.List;

import cgmgl.springmvc.app.bl.dto.ApplicantJobPostDto;
import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;

public interface ApplicantJobPostService {
    public void doAddApplicantJobPost(ApplicantJobPostDto applicantJobPostDto);

    public List<ApplicantJobPost> doGetApplicantJobPostList();

    public ApplicantJobPostDto doGetApplicantJobAcceptById(Integer applicantJobPostId);

    public ApplicantJobPostDto doGetApplicantJobRejectById(Integer applicantJobPostId);

    public ApplicantJobPost doGetApplicantJobPostById(Integer applicantJobPostId);
}
