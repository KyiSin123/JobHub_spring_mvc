package cgmgl.springmvc.app.persistence.dao;

import cgmgl.springmvc.app.persistence.entity.PasswordReset;

/**
 * <h2> PasswordResetDao Class</h2>
 * <p>
 * Process for Displaying PasswordResetDao
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
public interface PasswordResetDao {

    /**
     * <h2> createToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param pswToken
     * @return void
     */
    void createToken(Object pswToken);

    /**
     * <h2> getTokenDataByEmail</h2>
     * <p>
     * 
     * </p>
     *
     * @param user_email
     * @return
     * @return PasswordReset
     */
    PasswordReset getTokenDataByEmail(String user_email);

    /**
     * <h2> deleteTokenByEmail</h2>
     * <p>
     * 
     * </p>
     *
     * @param user_email
     * @return void
     */
    void deleteTokenByEmail(String user_email);

    /**
     * <h2> dbGetDataByToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param token
     * @return
     * @return PasswordReset
     */
    PasswordReset dbGetDataByToken(String token);

    /**
     * <h2> dbDeleteToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param token
     * @return void
     */
    void dbDeleteToken(String token);

}
