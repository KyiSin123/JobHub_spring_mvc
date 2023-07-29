package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.persistence.dao.CompanyDAO;
import cgmgl.springmvc.app.persistence.entity.Company;

/**
 * <h2> CompanyDAOimpl Class</h2>
 * <p>
 * Process for Displaying CompanyDAOimpl
 * </p>
 * 
 * @author yair naing
 *
 */
@Repository
@Transactional

public class CompanyDAOimpl implements CompanyDAO {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * <h2> dbsaveCompany </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param company
	 */
	@Override
	public void dbsaveCompany(Company company) {
		this.sessionFactory.getCurrentSession().save(company);

	}

	/**
	 * <h2> dbCompanyList </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> dbCompanyList() {
		return sessionFactory.getCurrentSession().createQuery("SELECT c FROM Company c where c. deleted_at = null")
		        .list();

	}

	/**
	 * <h2> dbaddCompany </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param company
	 * @param currentDate
	 */
	@Override
	public void dbaddCompany(Company company, Date currentDate) {
		company.setCreated_at(currentDate);
		sessionFactory.getCurrentSession().save(company);
	}

	/**
	 * <h2> dbupdateCompany </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param company
	 */
	@Override
	public void dbupdateCompany(Company company) {
		this.sessionFactory.getCurrentSession().update(company);

	}

	/**
	 * <h2> dbfindByEmail </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public Company dbfindByEmail(String email) {
		String companyquery = "select c from Company  c where c.email=:email";
		@SuppressWarnings("unchecked")
		Query<Company> queryCompanyByEmail = this.sessionFactory.getCurrentSession().createQuery(companyquery);
		queryCompanyByEmail.setParameter("email", email);
		return (Company) queryCompanyByEmail.uniqueResult();
	}

	/**
	 * <h2> dbcreateCompany </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param company
	 */
	@Override
	public void dbcreateCompany(Company company) {
		this.sessionFactory.getCurrentSession().save(company);

	}

	/**
	 * <h2> dbgetCompany </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param company_id
	 * @return
	 */
	@Override
	public Company dbgetCompany(int company_id) {
		String companyquery = "select c from Company c where c.company_id=:company_id";
		@SuppressWarnings("unchecked")
		Query<Company> queryCompanyByID = this.sessionFactory.getCurrentSession().createQuery(companyquery);
		queryCompanyByID.setParameter("company_id", company_id);
		Company result = (Company) queryCompanyByID.uniqueResult();
		return result;
	}
	/**
	 * <h2> dbdeleteCompanyID </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param company_id
	 * @param currentDate
	 */
	@Override
	public void dbdeleteCompanyID(int company_id, Date currentDate) {
		Company company = this.sessionFactory.getCurrentSession().load(Company.class, company_id);
		if (null != company) {
			company.setDeleted_at(new Date());
			this.sessionFactory.getCurrentSession().update(company);
		}

	}

}
