package cgmgl.springmvc.app.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.Company;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * <h2>UserDaoImpl Class</h2>
 * <p>
 * Process for Displaying UserDaoImpl
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings("rawtypes")
    @Override
    public User dbGetUserById(long userId) {
        // TODO Auto-generated method stub
        Query userById = this.sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u where u.id = :id");
        userById.setParameter("id", userId);
        User userOneByid = (User) userById.uniqueResult();
        return userOneByid;
    }

    @Override
    public void dbSaveUser(User user) {
        // TODO Auto-generated method stub
        this.sessionFactory.getCurrentSession().save(user);
    }

    /**
     * <h2>dbGetUserByName</h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public User dbGetUserByName(String username) {
        Query query = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE u.name = :username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

    /**
     * <h2>dbGetUserCount</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("rawtypes")
	@Override
    public long dbGetUserCount() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT COUNT(u) FROM User u");
        return (long) query.getSingleResult();
    }

    @Override
    public void dbUpdateUser(@Valid User user) {
        // TODO Auto-generated method stub
        this.sessionFactory.getCurrentSession().update(user);
    }

    /**
     * <h2>dbFindUserByAllEmail</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user_email
     * @return
     */
    @SuppressWarnings("rawtypes")
	@Override
    public User dbFindUserByAllEmail(String user_email) {
        String userQuery = "SELECT u FROM User u WHERE u.email = :email";
        Query query = this.sessionFactory.getCurrentSession().createQuery(userQuery);
        query.setParameter("email", user_email);
        User user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public void dbAddUser(User user, ApplicantInfo applicantInfo, Date created_date) {
        // TODO Auto-generated method stub
        user.setApplicantInfo(applicantInfo);
        user.setCreated_at(created_date);
        this.sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> dbGetUserList() {
        // TODO Auto-generated method stub
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    /**
     * <h2>dbUpdateUserPassword</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbUpdateUserPassword(User user) {

        User user1 = this.sessionFactory.getCurrentSession().load(User.class, user.getId());
        if (user1 != null) {
            user1.setPassword(user.getPassword());
            this.sessionFactory.getCurrentSession().update(user);
        }
    }
    
    @SuppressWarnings("rawtypes")
	  @Override
    public User dbGetUserByEmail(String userEmail) {
        // TODO Auto-generated method stub
        Query userById = this.sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u where u.email = :email");
        userById.setParameter("email", userEmail);
        User userOneByid = (User) userById.uniqueResult();
        return userOneByid;
    }

    @Override
    public void dbDeleteUser(User user, Date deletedAt) {
        // TODO Auto-generated method stub
        user.setDeleted_at(deletedAt);
        this.sessionFactory.getCurrentSession().update(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> dbGetUserEmailList() {
        // TODO Auto-generated method stub
        return sessionFactory.getCurrentSession().createQuery("select email from User").list();
    }

    @Override
    public void dbAddCompany(User user, Company companyInfo, Date created_date) {
        // TODO Auto-generated method stub
        user.setCompany(companyInfo);
        user.setCreated_at(created_date);
        this.sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> dbGetUserNameList() {
        return sessionFactory.getCurrentSession().createQuery("select name from User").list();
    }
}