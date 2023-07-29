package cgmgl.springmvc.app.bl.service;

import java.util.List;

import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;

public interface ApplicantInfoService {

	public void doSaveApplicant(ApplicantInfo applicantInfo);

	public List<ApplicantInfo> doGetApplicantList();

	public void doDeleteUser(long applicantId);

}