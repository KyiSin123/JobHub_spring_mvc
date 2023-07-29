package cgmgl.springmvc.app.bl.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.bl.service.CompanyService;
import cgmgl.springmvc.app.persistence.dao.CompanyDAO;
import cgmgl.springmvc.app.persistence.entity.Company;

/**
 * <h2> CompanyServiceimpl Class</h2>
 * <p>
 * Process for Displaying CompanyServiceimpl
 * </p>
 * 
 * @author yair naing
 *
 */
@Transactional
@Service
public class CompanyServiceimpl implements CompanyService {
	@Autowired
	CompanyDAO companydao;

	/**
	 * <h2> dogetCompanyList </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<Company> dogetCompanyList() {
	
		return this.companydao.dbCompanyList();
	}

	/**
	 * <h2> doaddCompay </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param companyDto
	 */
	@Override
	public void doaddCompay(CompanyDto companyDto) {
		Company company = new Company(companyDto);
		Date currentDate = new Date();
		this.companydao.dbaddCompany(company, currentDate);

	}

	/**
	 * <h2> doupdateCompany </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param companyDto
	 */
	@Override
	public void doupdateCompany(CompanyDto companyDto) {
		Company company = this.companydao.dbgetCompany(companyDto.getCompany_id());
		company.setCompany_name(companyDto.getCompany_name());
		company.setEmail(companyDto.getEmail());
		company.setPhone(companyDto.getPhone());
		company.setAddress(companyDto.getAddress());
		company.setWeb_link(companyDto.getWeb_link());
		company.setUpdated_at(new Date());
		company.setCreated_at(companyDto.getCreated_at());
		this.companydao.dbupdateCompany(company);		

	}

	/**
	 * <h2> dogetCompany </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param company_id
	 * @return
	 */
	@Override
	public Company dogetCompany(int company_id) {
		return companydao.dbgetCompany(company_id);

	}

	/**
	 * <h2> dofindByEmail </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public boolean dofindByEmail(String email) {
		Company result = this.companydao.dbfindByEmail(email);
		boolean rollNoExist = false;
		if (result != null) {
			rollNoExist = true;
		}
		return rollNoExist;
	}

	/**
	 * <h2> dodeleteCompanyID </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param company_id
	 */
	@Override
	public void dodeleteCompanyID(int company_id) {
		companydao.dbdeleteCompanyID(company_id, new Date());;
		
	}
	
}
