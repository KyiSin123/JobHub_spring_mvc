package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.persistence.dao.JobTypeDao;
import cgmgl.springmvc.app.persistence.entity.JobType;

/**
 * <h2>JobTypeDaoImpl Class</h2>
 * <p>
 * Process for Displaying JobTypeDaoImpl
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Repository
@Transactional
public class JobTypeDaoImpl implements JobTypeDao {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>dbGetJobTypeList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<JobType> dbGetJobTypeList() {
        return sessionFactory.getCurrentSession().createQuery("select jt from JobType jt where deleteAt is null").list();
    }

    /**
     * <h2>dbAddJobType</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobType
     * @param currentDate
     */
    @Override
    public void dbAddJobType(JobType jobType, Date currentDate) {
        jobType.setCreateAt(currentDate);
        sessionFactory.getCurrentSession().saveOrUpdate(jobType);
    }

    /**
     * <h2>dbGetJobTypeById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeId
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public JobType dbGetJobTypeById(int jobTypeId) {
        String jobTypeHqlQuery = "SELECT jt FROM JobType jt where jt.id = :id";
        Query queryJobTypeById = this.sessionFactory.getCurrentSession().createQuery(jobTypeHqlQuery);
        queryJobTypeById.setParameter("id", jobTypeId);
        JobType resultJobType = (JobType) queryJobTypeById.uniqueResult();
        return resultJobType;
    }

    /**
     * <h2>dbUpdateJobType</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobType
     * @param updateAt
     */
    @Override
    public void dbUpdateJobType(JobType jobType, Date updateAt) {
        jobType.setUpdateAt(updateAt);
        this.sessionFactory.getCurrentSession().update(jobType);
    }

    /**
     * <h2>dbDeleteJobType</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeId
     * @param deletedAt
     */
    @Override
    public void dbDeleteJobType(Integer jobTypeId, Date currentDate) {
        JobType jobType = (JobType) sessionFactory.getCurrentSession().load(JobType.class, jobTypeId);
        if (null != jobType) {
            jobType.setDeleteAt(new Date());
            this.sessionFactory.getCurrentSession().update(jobType);
        }
    }
}