package cgmgl.springmvc.app.persistence.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.persistence.dao.PasswordResetDao;
import cgmgl.springmvc.app.persistence.entity.PasswordReset;


/**
 * <h2> PasswordResetDaoImpl Class</h2>
 * <p>
 * Process for Displaying PasswordResetDaoImpl
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Repository
@Transactional
public class PasswordResetDaoImpl implements PasswordResetDao{
    /**
     * <h2> sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    SessionFactory sessionFactory;
    /**
     * <h2> createToken </h2>
     * <p>
     * 
     * </p>
     * 
     * @param pswToken
     */
    @Override
    public void createToken(Object pswToken) {
        this.sessionFactory.getCurrentSession().save(pswToken);
        
    }
    /**
     * <h2> getTokenDataByEmail </h2>
     * <p>
     * 
     * </p>
     * 
     * @param user_email
     * @return
     */
    @Override
    @SuppressWarnings("rawtypes")
    public PasswordReset getTokenDataByEmail(String user_email) {
        String userHqlQuery = "SELECT pw FROM PasswordReset pw WHERE pw.user_email = :email";
        Query queryUserByEmail = this.sessionFactory.getCurrentSession().createQuery(userHqlQuery);
        queryUserByEmail.setParameter("email", user_email);
        PasswordReset passwordReset = (PasswordReset) queryUserByEmail.uniqueResult();
        return passwordReset;
    }
    /**
     * <h2> deleteTokenByEmail </h2>
     * <p>
     * 
     * </p>
     * 
     * @param user_email
     */
    @Override
    @SuppressWarnings("rawtypes")
    public void deleteTokenByEmail(String user_email) {
        String userHqlQuery = "DELETE FROM PasswordReset pw WHERE pw.user_email = :email";
        Query queryUserByEmail = this.sessionFactory.getCurrentSession().createQuery(userHqlQuery);
        queryUserByEmail.setParameter("email", user_email);
        queryUserByEmail.executeUpdate();
        
    }
    /**
     * <h2> dbGetDataByToken </h2>
     * <p>
     * 
     * </p>
     * 
     * @param token
     * @return
     */
    @Override
    @SuppressWarnings("rawtypes")
    public PasswordReset dbGetDataByToken(String token) {
        String userHqlQuery = "SELECT pw FROM PasswordReset pw WHERE pw.token = :token";
        Query queryUserByToken = this.sessionFactory.getCurrentSession().createQuery(userHqlQuery);
        queryUserByToken.setParameter("token", token);
        PasswordReset passwordReset = (PasswordReset) queryUserByToken.uniqueResult();
        return passwordReset;
    }
    /**
     * <h2> dbDeleteToken </h2>
     * <p>
     * 
     * </p>
     * 
     * @param token
     */
    @Override
    public void dbDeleteToken(String token) {
        PasswordReset passwordReset = this.sessionFactory.getCurrentSession().load(PasswordReset.class, token);
        this.sessionFactory.getCurrentSession().delete(passwordReset);
        
    }

}