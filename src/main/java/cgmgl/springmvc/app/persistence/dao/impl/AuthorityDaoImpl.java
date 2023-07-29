package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.AuthorityDao;
import cgmgl.springmvc.app.persistence.entity.Authority;


/**
 * <h2>AuthorityDaoImpl Class</h2>
 * <p>
 * Process for Displaying AuthorityDaoImpl
 * </p>
 * 
 * @author KyiSin
 *
 */
@Transactional
@Repository
public class AuthorityDaoImpl implements AuthorityDao {
	/**
	 * <h2>sessionFactory</h2>
	 * <p>
	 * sessionFactory
	 * </p>
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * <h2>dbGetAuthorityCount</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public long dbGetAuthorityCount() {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(a) FROM Authority a");
		return (long) query.getSingleResult();
	}

	/**
	 * <h2>dbSaveAuthority</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param authority
	 */
	@Override
	public void dbSaveAuthority(Authority authority) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(authority);
	}

	/**
	 * <h2>dbGetAuthorityList</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> dbGetAuthorityList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Authority").list();
	}

	/**
	 * <h2>dbGetAuthById</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param authoId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Authority dbGetAuthById(int authoId) {
		// TODO Auto-generated method stub
		Query authById = this.sessionFactory.getCurrentSession()
		        .createQuery("SELECT a FROM Authority a where a.id = :id");
		authById.setParameter("id", authoId);
		Authority authorityByid = (Authority) authById.uniqueResult();
		return authorityByid;
	}

}