package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.persistence.dao.JobPostDao;
import cgmgl.springmvc.app.persistence.entity.JobPost;

/**
 * <h2>JobPostDaoImpl Class</h2>
 * <p>
 * Process for Displaying JobPostDaoImpl
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Repository
@Transactional
public class JobPostDaoImpl implements JobPostDao {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>dbGetJobPostList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JobPost> dbGetJobPostList() {
        return sessionFactory.getCurrentSession().createQuery("select jp from JobPost jp where jp.deleted_at is null").list();
    }

    /**
     * <h2> dbGetJobPostByJobTypeId </h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeId
     * @return
     */
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
    @Override
    public List<JobPost> dbGetJobPostByJobTypeId(Integer jobTypeId) {
        String jobPostQuery = "SELECT p FROM JobPost p where p.jobType.id = :id";
        Query jobPostByJobType = this.sessionFactory.getCurrentSession().createQuery(jobPostQuery);
        jobPostByJobType.setParameter("id", jobTypeId);
        List<JobPost> resultJobPost = (List<JobPost>) jobPostByJobType.list();
        return resultJobPost;
    }
    
    private static final int limitResultsPerPage =4 ;
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
    @Override
    public List<JobPost> dbgetJobPostList(Long page) {
        Query q = sessionFactory.getCurrentSession().createQuery(
                "select jp from JobPost jp where jp.deleted_at is null");
        q.setFirstResult((int) (page * limitResultsPerPage)); 
        q.setMaxResults(limitResultsPerPage);
        return (List<JobPost>) q.list();
    }
    
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
    @Override
    public List<JobPost> dbGetJobPostByJobTypeId(Integer jobTypeId, Long page) {
        Query q = sessionFactory.getCurrentSession().createQuery("SELECT p FROM JobPost p where p.jobType.id = :id and p.deleted_at is null");
        q.setParameter("id", jobTypeId);
        q.setFirstResult((int) (page * limitResultsPerPage));
        q.setMaxResults(limitResultsPerPage);
        List<JobPost> resultJobPost = (List<JobPost>) q.list();
        return resultJobPost;
    }

    /**
     * <h2>dbGetJobPostById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPostId
     * @return
     */

    @SuppressWarnings({ "deprecation", "rawtypes" })
    @Override
    public JobPost dbGetJobPostById(Integer jobPostId) {
        String jobPostHqlQuery = "SELECT jp FROM JobPost jp where jp.id = :id";
        Query queryJobPostById = this.sessionFactory.getCurrentSession().createQuery(jobPostHqlQuery);
        queryJobPostById.setParameter("id", jobPostId);
        JobPost resultJobPost = (JobPost) queryJobPostById.uniqueResult();
        return resultJobPost;
    }

    /**
     * <h2>dbAddJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPost
     * @param currentDate
     */
    @Override
    public void dbAddJobPost(JobPost jobPost, Date currentDate) {
        jobPost.setCreated_at(currentDate);
        sessionFactory.getCurrentSession().saveOrUpdate(jobPost);
    }

    /**
     * <h2>dbDeleteJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPostId
     */
    @Override
    public void dbDeleteJobPost(Integer jobPostId,Date currentDate) {
        JobPost jobPost = (JobPost)sessionFactory.getCurrentSession().load(JobPost.class, jobPostId);
        if (null != jobPost) {
            jobPost.setDeleted_at(new Date());
            this.sessionFactory.getCurrentSession().update(jobPost);
        }
    }

    /**
     * <h2>dbUpdateJobPost</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobPost
     * @param updateAt
     */
    @Override
    public void dbUpdateJobPost(JobPost jobPost, Date currentDate) {
        jobPost.setUpdated_at(currentDate);
        this.sessionFactory.getCurrentSession().update(jobPost);
    }
    /**
     * <h2> dbGetJobPostByJobTypeIdList </h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeId
     * @return
     */
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
    @Override
    public List<JobPost> dbGetJobPostByJobTypeIdList(Integer jobTypeId) {
            String jobPostQuery = "SELECT p FROM JobPost p where p.jobType.id = :id and p.deleted_at is null";
            Query jobPostByJobType = this.sessionFactory.getCurrentSession().createQuery(jobPostQuery);
            jobPostByJobType.setParameter("id", jobTypeId);
            List<JobPost> resultJobPost = (List<JobPost>) jobPostByJobType.list();
            return resultJobPost;
        }
   
}