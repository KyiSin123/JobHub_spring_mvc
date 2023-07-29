package cgmgl.springmvc.app.bl.service.Impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgmgl.springmvc.app.bl.service.ApplicantInfoService;
import cgmgl.springmvc.app.persistence.dao.ApplicantInfoDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.User;

@Transactional
@Service("applicantService")
public class ApplicantInfoServiceImpl implements ApplicantInfoService{
	@Autowired
	private ApplicantInfoDao applicantDao;

	@Override
	public void doSaveApplicant(ApplicantInfo applicantInfo) {
		// TODO Auto-generated method stub
		this.applicantDao.dbSaveApplicantInfo(applicantInfo);
	}

	@Override
	public List<ApplicantInfo> doGetApplicantList() {
		// TODO Auto-generated method stub
		return applicantDao.dbGetApplicantList();
	}

	@Override
	public void doDeleteUser(long applicantId) {
		// TODO Auto-generated method stub
		Date deletedAt = new Date();
		ApplicantInfo applicantInfo = this.applicantDao.dbGetApplicantById(applicantId);
		this.applicantDao.dbDeleteUser(applicantInfo, deletedAt);
	}

}