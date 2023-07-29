package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cgmgl.springmvc.app.persistence.dao.ApplicantJobPostDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;
import cgmgl.springmvc.app.persistence.entity.JobPost;

@Repository
@Transactional
public class ApplicantJobPostDaoImpl implements ApplicantJobPostDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void dbAddApplicantJobPost(ApplicantJobPost applicantJobPost, Date currentDate) {
        System.out.println("dbAddApplicantJobPost...." + applicantJobPost);
        applicantJobPost.setApply_date(currentDate);
        sessionFactory.getCurrentSession().saveOrUpdate(applicantJobPost);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ApplicantJobPost> dbGetApplicantJobPostList() {
        return sessionFactory.getCurrentSession().createQuery("from ApplicantJobPost").list();
    }

    @SuppressWarnings({ "deprecation", "rawtypes" })
    @Override
    public ApplicantJobPost dbGetApplicantJobStatusById(Integer applicantJobPostId) {
        String jobHqlQuery = "SELECT a FROM ApplicantJobPost a where a.id = :id";
        Query queryJobById = this.sessionFactory.getCurrentSession().createQuery(jobHqlQuery);
        queryJobById.setParameter("id", applicantJobPostId);
        ApplicantJobPost resultJob = (ApplicantJobPost) queryJobById.uniqueResult();
        return resultJob;
    }

    @SuppressWarnings({ "deprecation", "rawtypes" })
    @Override
    public ApplicantJobPost dbGetApplicantJobPostById(Integer applicantJobPostId) {
        String HqlQuery = "SELECT a FROM ApplicantJobPost a where a.id = :id";
        Query queryApplicantJobPostById = this.sessionFactory.getCurrentSession().createQuery(HqlQuery);
        queryApplicantJobPostById.setParameter("id", applicantJobPostId);
        ApplicantJobPost result = (ApplicantJobPost) queryApplicantJobPostById.uniqueResult();
        return result;
    }
}