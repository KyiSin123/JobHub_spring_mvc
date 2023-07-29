package cgmgl.springmvc.app.bl.service.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.ApplicantJobPostDto;
import cgmgl.springmvc.app.bl.service.ApplicantJobPostService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.dao.ApplicantJobPostDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * <h2>ApplicantJobPostServiceImpl Class</h2>
 * <p>
 * Process for Displaying ApplicantJobPostServiceImpl
 * </p>
 * 
 * @author HtetSuMoe
 *
 */
@Transactional
@Service
public class ApplicantJobPostServiceImpl implements ApplicantJobPostService {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * <h2>applicantJobPostDao</h2>
     * <p>
     * applicantJobPostDao
     * </p>
     */
    @Autowired
    private ApplicantJobPostDao applicantJobPostDao;

    /**
     * <h2>userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2>doAddApplicantJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param applicantJobPostDto
     */
    @Override
    public void doAddApplicantJobPost(ApplicantJobPostDto applicantJobPostDto) {
        ApplicantInfo applicantInfo = new ApplicantInfo();
        applicantInfo.setId(userService.doGetLoginInfo().getApplicantInfo().getId());
        System.out.println("Applicant Id ...."+applicantInfo);
        Date currentDate = new Date();
        ApplicantJobPost applicantJobPost = new ApplicantJobPost(applicantJobPostDto);
        applicantJobPost.setStatus("Pending");
        applicantJobPost.setApplicantInfo(applicantInfo);
        applicantJobPost.setJobPost(applicantJobPostDto.getJobPost());
        this.applicantJobPostDao.dbAddApplicantJobPost(applicantJobPost, currentDate);
    }

    @Override
    public List<ApplicantJobPost> doGetApplicantJobPostList() {
        //userService.doGetUserById(0);
        return applicantJobPostDao.dbGetApplicantJobPostList();
    }

    @Override
    public ApplicantJobPostDto doGetApplicantJobAcceptById(Integer applicantJobPostId) {
        ApplicantJobPost applicantJobPost = applicantJobPostDao.dbGetApplicantJobStatusById(applicantJobPostId);
        applicantJobPost.setStatus("Accept");
        ApplicantJobPostDto applicantJobPostDto = applicantJobPost != null ? new ApplicantJobPostDto(applicantJobPost) : null;
        return applicantJobPostDto;
    }

    @Override
    public ApplicantJobPostDto doGetApplicantJobRejectById(Integer applicantJobPostId) {
        ApplicantJobPost applicantJobPost = applicantJobPostDao.dbGetApplicantJobStatusById(applicantJobPostId);
        applicantJobPost.setStatus("Reject");
        ApplicantJobPostDto applicantJobPostDto = applicantJobPost != null ? new ApplicantJobPostDto(applicantJobPost) : null;
        return applicantJobPostDto;
    }

    @Override
    public ApplicantJobPost doGetApplicantJobPostById(Integer applicantJobPostId) {
        ApplicantJobPost applicantJobPost = applicantJobPostDao.dbGetApplicantJobPostById(applicantJobPostId);
        //ApplicantJobPostDto applicantJobPostDto = applicantJobPost != null ? new ApplicantJobPostDto(applicantJobPost) : null;
        return applicantJobPost;
    }
}