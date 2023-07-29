package cgmgl.springmvc.app.bl.service.Impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.PasswordResetMailForm;
import cgmgl.springmvc.app.bl.service.PasswordResetService;
import cgmgl.springmvc.app.persistence.dao.PasswordResetDao;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.PasswordReset;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * <h2>PasswordResetServiceImpl Class</h2>
 * <p>
 * Process for Displaying PasswordResetServiceImpl
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Transactional
@Service
public class PasswordResetServiceImpl implements PasswordResetService {
    /**
     * <h2>psw_token_length</h2>
     * <p>
     * psw_token_length
     * </p>
     */
    public static final int psw_token_length = 20;

    /**
     * <h2>psw_token_expired_minute</h2>
     * <p>
     * psw_token_expired_minute
     * </p>
     */
    public static final int psw_token_expired_minute = 3;

    /**
     * <h2>now</h2>
     * <p>
     * now
     * </p>
     */
    private Timestamp now = new Timestamp(new Date(System.currentTimeMillis()).getTime());

    /**
     * <h2>passwordResetDAO</h2>
     * <p>
     * passwordResetDAO
     * </p>
     */
    @Autowired
    PasswordResetDao passwordResetDAO;

    /**
     * <h2>userDAO</h2>
     * <p>
     * userDAO
     * </p>
     */
    @Autowired
    UserDao userDAO;

    /**
     * <h2>passwordEncoder</h2>
     * <p>
     * passwordEncoder
     * </p>
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * <h2>createResetToken</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user_email
     * @return
     */
    @Override
    public PasswordResetMailForm createResetToken(String user_email) {
        if (isEmailExit(user_email)) {
            passwordResetDAO.deleteTokenByEmail(user_email);
        }
        String token = UUID.randomUUID().toString();
        Timestamp expired = new Timestamp(
                new Date(System.currentTimeMillis() + psw_token_expired_minute * 60 * 1000).getTime());
        System.out.println(expired);
        PasswordResetMailForm passwordResetForm = new PasswordResetMailForm();
        passwordResetForm.setUser_email(user_email);
        passwordResetForm.setToken(token);
        passwordResetForm.setCreated_at(now);
        passwordResetForm.setExpired_at(expired);
        this.passwordResetDAO.createToken(this.getPswToken(passwordResetForm));
        return passwordResetForm;

    }

    /**
     * <h2>isEmailExit</h2>
     * <p>
     * 
     * </p>
     *
     * @param user_email
     * @return
     * @return boolean
     */
    private boolean isEmailExit(String user_email) {
        PasswordReset pwToken = this.passwordResetDAO.getTokenDataByEmail(user_email);
        return pwToken != null;
    }

    /**
     * <h2>getPswToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param passwordResetForm
     * @return
     * @return Object
     */
    private Object getPswToken(PasswordResetMailForm passwordResetForm) {
        PasswordReset pwToken = new PasswordReset();
        pwToken.setUser_email(passwordResetForm.getUser_email());
        pwToken.setToken(passwordResetForm.getToken());
        pwToken.setCreated_at(passwordResetForm.getCreated_at());
        pwToken.setExpired_at(passwordResetForm.getExpired_at());
        return pwToken;
    }

    /**
     * <h2>getDataByToken</h2>
     * <p>
     * 
     * </p>
     * 
     * @param token
     * @return
     */
    @Override
    public PasswordResetMailForm getDataByToken(String token) {
        try {
            PasswordResetMailForm passwordResetMailForm = new PasswordResetMailForm(
                    passwordResetDAO.dbGetDataByToken(token));
            return passwordResetMailForm;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * <h2>doUpdatePassword</h2>
     * <p>
     * 
     * </p>
     * 
     * @param newPasswordResetForm
     */
    @Override
    public void doUpdatePassword(PasswordResetMailForm newPasswordResetForm) {
        newPasswordResetForm.setPassword(passwordEncoder.encode(newPasswordResetForm.getPassword()));
        User user = this.userDAO.dbFindUserByAllEmail(newPasswordResetForm.getUser_email());
        user.setPassword(newPasswordResetForm.getPassword());
        this.userDAO.dbUpdateUserPassword(user);

    }

    /**
     * <h2>doDeleteToken</h2>
     * <p>
     * 
     * </p>
     * 
     * @param token
     */
    @Override
    public void doDeleteToken(String token) {
        this.passwordResetDAO.dbDeleteToken(token);

    }

}
