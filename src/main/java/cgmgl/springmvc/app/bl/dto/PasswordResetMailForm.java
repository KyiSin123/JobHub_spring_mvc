package cgmgl.springmvc.app.bl.dto;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.PasswordReset;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>PasswordResetMailForm Class</h2>
 * <p>
 * Process for Displaying PasswordResetMailForm
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Getter
@Setter
public class PasswordResetMailForm {
    /**
     * <h2>user_email</h2>
     * <p>
     * user_email
     * </p>
     */
    @Email
    @NotEmpty
    private String user_email;

    /**
     * <h2>password</h2>
     * <p>
     * password@
     * </p>
     */
    private String password;

    /**
     * <h2>token</h2>
     * <p>
     * token
     * </p>
     */
    private String token;

    /**
     * <h2>created_at</h2>
     * <p>
     * created_at
     * </p>
     */
    private Timestamp created_at;

    /**
     * <h2>expired_at</h2>
     * <p>
     * expired_at
     * </p>
     */
    private Timestamp expired_at;

    /**
     * <h2>Constructor for PasswordResetMailForm</h2>
     * <p>
     * Constructor for PasswordResetMailForm
     * </p>
     */
    public PasswordResetMailForm() {
        super();
    }

    /**
     * <h2>Constructor for PasswordResetMailForm</h2>
     * <p>
     * Constructor for PasswordResetMailForm
     * </p>
     * 
     * @param passwordReset
     */
    public PasswordResetMailForm(PasswordReset passwordReset) {
        this.user_email = passwordReset.getUser_email();
        this.token = passwordReset.getToken();
        this.created_at = passwordReset.getCreated_at();
        this.expired_at = passwordReset.getExpired_at();
    }
}
