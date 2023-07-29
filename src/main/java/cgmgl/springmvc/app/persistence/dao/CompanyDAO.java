package cgmgl.springmvc.app.persistence.dao;

import java.util.Date;
import java.util.List;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.persistence.entity.Company;

public interface CompanyDAO {
	public void dbsaveCompany(Company company);

	public List<Company> dbCompanyList();

	public void dbaddCompany(Company company, Date currentDate);

	public void dbupdateCompany(Company company);

	public Company dbfindByEmail(String email);
	
	void dbcreateCompany(Company company);

	public Company dbgetCompany(int company_id);
	

	public void dbdeleteCompanyID(int company_id, Date CurrentDate);

}
