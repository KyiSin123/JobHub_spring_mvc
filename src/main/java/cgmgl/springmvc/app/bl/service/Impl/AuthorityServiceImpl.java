package cgmgl.springmvc.app.bl.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgmgl.springmvc.app.bl.service.AuthorityService;
import cgmgl.springmvc.app.persistence.dao.AuthorityDao;
import cgmgl.springmvc.app.persistence.entity.Authority;


/**
 * <h2>AuthorityServiceImpl Class</h2>
 * <p>
 * Process for Displaying AuthorityServiceImpl
 * </p>
 * 
 * @author KyiSin
 *
 */
@Transactional
@Service
public class AuthorityServiceImpl implements AuthorityService {
	/**
	 * <h2>authoDao</h2>
	 * <p>
	 * authoDao
	 * </p>
	 */
	@Autowired
	private AuthorityDao authoDao;

	/**
	 * <h2>doGetAuthList</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<Authority> doGetAuthList() {
		// TODO Auto-generated method stub
		return authoDao.dbGetAuthorityList();
	}

	/**
	 * <h2>doGetAuthById</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param authoId
	 * @return
	 */
	@Override
	public Authority doGetAuthById(int authoId) {
		// TODO Auto-generated method stub
		Authority authoResult = this.authoDao.dbGetAuthById(authoId);
		return authoResult;
	}

}