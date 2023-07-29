package cgmgl.springmvc.app.bl.service;

import cgmgl.springmvc.app.bl.dto.PasswordResetMailForm;

/**
 * <h2> PasswordResetService Class</h2>
 * <p>
 * Process for Displaying PasswordResetService
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
public interface PasswordResetService {

    /**
     * <h2> createResetToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param user_email
     * @return
     * @return PasswordResetMailForm
     */
    PasswordResetMailForm createResetToken(String user_email);

    /**
     * <h2> getDataByToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param token
     * @return
     * @return PasswordResetMailForm
     */
    PasswordResetMailForm getDataByToken(String token);

    /**
     * <h2> doUpdatePassword</h2>
     * <p>
     * 
     * </p>
     *
     * @param newPasswordResetForm
     * @return void
     */
    void doUpdatePassword(PasswordResetMailForm newPasswordResetForm);

    /**
     * <h2> doDeleteToken</h2>
     * <p>
     * 
     * </p>
     *
     * @param token
     * @return void
     */
    void doDeleteToken(String token);

}
