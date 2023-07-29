package cgmgl.springmvc.app.bl.service;

import java.util.List;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.persistence.entity.Company;

public interface CompanyService {
	public List<Company> dogetCompanyList();

	public void doaddCompay(CompanyDto companyform);

	public void dodeleteCompanyID(int company_id);

	public Company dogetCompany(int company_id);

	public void doupdateCompany(CompanyDto companyform);
	
	public boolean dofindByEmail(String email);

}
