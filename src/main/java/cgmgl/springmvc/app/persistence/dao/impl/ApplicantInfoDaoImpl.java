package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.ApplicantInfoDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.User;


@Transactional
@Repository
public class ApplicantInfoDaoImpl implements ApplicantInfoDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void dbSaveApplicantInfo(ApplicantInfo appInfo) {
		// TODO Auto-generated method stub
		System.out.println(appInfo.getId());
		System.out.println(appInfo.getAddress());
		this.sessionFactory.getCurrentSession().save(appInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicantInfo> dbGetApplicantList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from ApplicantInfo").list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ApplicantInfo dbGetApplicantById(long applicantId) {
		// TODO Auto-generated method stub
		Query applicantById = this.sessionFactory.getCurrentSession().createQuery("SELECT a FROM ApplicantInfo a where a.id = :id");
		applicantById.setParameter("id", applicantId);
		ApplicantInfo oneApplicantByid = (ApplicantInfo) applicantById.uniqueResult();
		return oneApplicantByid;
	}

	@Override
	public void dbDeleteUser(ApplicantInfo applicantInfo, Date deletedAt) {
		// TODO Auto-generated method stub
		applicantInfo.setDeleted_at(deletedAt);
		this.sessionFactory.getCurrentSession().update(applicantInfo);
	}

}