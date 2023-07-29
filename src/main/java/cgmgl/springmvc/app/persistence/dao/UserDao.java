package cgmgl.springmvc.app.persistence.dao;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.Company;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * <h2> UserDao Class</h2>
 * <p>
 * Process for Displaying UserDao
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
public interface UserDao {
    User dbGetUserById(long userId);

    void dbUpdateUser(@Valid User user);

	User dbGetUserByEmail(String userEmail);

    void dbAddUser(User user, ApplicantInfo applicantInfo, Date created_date);

	List<User> dbGetUserList();

    /**
     * <h2> dbGetUserByName</h2>
     * <p>
     * 
     * </p>
     *
     * @param username
     * @return
     * @return User
     */
    public User dbGetUserByName(String username);

    /**
     * <h2> dbGetUserCount</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return long
     */
    public long dbGetUserCount();

    /**
     * <h2> dbSaveUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void dbSaveUser(User user);

    /**
     * <h2> dbFindUserByAllEmail</h2>
     * <p>
     * 
     * </p>
     *
     * @param user_email
     * @return
     * @return User
     */
    public User dbFindUserByAllEmail(String user_email);

    /**
     * <h2> dbUpdateUserPassword</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void dbUpdateUserPassword(User user);

	void dbDeleteUser(User user, Date deletedAt);

	List<String> dbGetUserEmailList();

	void dbAddCompany(User user, Company companyInfo, Date created_date);

    public List<User> dbGetUserNameList();
}