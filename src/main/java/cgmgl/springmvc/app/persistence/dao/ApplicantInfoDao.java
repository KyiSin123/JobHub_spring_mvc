package cgmgl.springmvc.app.persistence.dao;

import java.util.Date;
import java.util.List;

import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;

public interface ApplicantInfoDao {

	public void dbSaveApplicantInfo(ApplicantInfo appInfo);

	public List<ApplicantInfo> dbGetApplicantList();

	public ApplicantInfo dbGetApplicantById(long applicantId);

	public void dbDeleteUser(ApplicantInfo applicantInfo, Date deletedAt);	
	
}