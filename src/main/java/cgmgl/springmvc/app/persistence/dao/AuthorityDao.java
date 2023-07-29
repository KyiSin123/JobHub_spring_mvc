package cgmgl.springmvc.app.persistence.dao;

import java.util.List;

import cgmgl.springmvc.app.persistence.entity.Authority;

/**
 * <h2>AuthorityDao Class</h2>
 * <p>
 * Process for Displaying AuthorityDao
 * </p>
 * 
 * @author KyiSin
 *
 */
public interface AuthorityDao {
	/**
	 * <h2>dbGetAuthorityCount</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return long
	 */
	public long dbGetAuthorityCount();

	/**
	 * <h2>dbSaveAuthority</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param authority
	 * @return void
	 */
	public void dbSaveAuthority(Authority authority);

	/**
	 * <h2>dbGetAuthorityList</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return List<Authority>
	 */
	public List<Authority> dbGetAuthorityList();

	/**
	 * <h2>dbGetAuthById</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param authoId
	 * @return
	 * @return Authority
	 */
	public Authority dbGetAuthById(int authoId);
}