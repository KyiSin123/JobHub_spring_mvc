package cgmgl.springmvc.app.bl.service;

import java.util.List;

import cgmgl.springmvc.app.bl.dto.JobPostDto;
import cgmgl.springmvc.app.persistence.entity.JobPost;
import cgmgl.springmvc.app.persistence.entity.JobType;

/**
 * <h2>JobPostService Class</h2>
 * <p>
 * Process for Displaying JobPostService
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
public interface JobPostService {
    /**
     * <h2>doGetJobPostList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<JobPost>
     */
    public List<JobPost> doGetJobPostList();

    /**
     * <h2>doGetJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostId
     * @return
     * @return JobPostDto
     */
    public JobPostDto doGetJobPostById(int jobPostId);
    /**
     * <h2> doGetJobPostByJobTypeId</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeId
     * @return
     * @return JobPostDto
     */
    public List<JobPost> doGetJobPostByJobTypeId(Integer jobTypeId);

    /**
     * <h2>doAddJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostDto
     * @return void
     */
    public void doAddJobPost(JobPostDto jobPostDto);

    /**
     * <h2>doDeleteJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostId
     * @return void
     */
    public void doDeleteJobPost(Integer jobPostId);

    /**
     * <h2>doUpdateJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobPostDto
     * @return void
     */
    public void doUpdateJobPost(JobPostDto jobPostDto);

    /**
     * <h2>doGetJobTypeList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<JobType>
     */
    public List<JobType> doGetJobTypeList();

    /**
     * <h2>doGetJobTypeById</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeId
     * @return
     * @return JobType
     */
    public JobType doGetJobTypeById(int jobTypeId);

    public List<JobPost> getJobPostByPage(Long page);

    public List<JobPost> doGetJobPostByJobTypeId(Integer jobTypeId, Long page);

    public int doGetJobPostListCount();

    public int doGetJobPostListCount1(Integer jobTypeId);
}