package cgmgl.springmvc.app.bl.service;

import java.util.List;

import cgmgl.springmvc.app.persistence.entity.Authority;


/**
 * <h2>AuthorityService Class</h2>
 * <p>
 * Process for Displaying AuthorityService
 * </p>
 * 
 * @author KyiSin
 *
 */
public interface AuthorityService {
	/**
	 * <h2>doGetAuthList</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return List<Authority>
	 */
	public List<Authority> doGetAuthList();

	/**
	 * <h2>doGetAuthById</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param authoId
	 * @return
	 * @return Authority
	 */
	public Authority doGetAuthById(int authoId);

}