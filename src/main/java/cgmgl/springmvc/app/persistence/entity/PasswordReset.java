package cgmgl.springmvc.app.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cgmgl.springmvc.app.bl.dto.PasswordResetMailForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>PasswordReset Class</h2>
 * <p>
 * Process for Displaying PasswordReset
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "password_reset")
public class PasswordReset {
    /**
     * <h2>token</h2>
     * <p>
     * token
     * </p>
     */
    @Id
    @Column(name = "token", length = 64)
    private String token;

    /**
     * <h2>user_email</h2>
     * <p>
     * user_email
     * </p>
     */
    @Column(name = "user_email")
    private String user_email;

    /**
     * <h2>created_at</h2>
     * <p>
     * created_at
     * </p>
     */
    @Column(name = "created_at")
    private Timestamp created_at;

    /**
     * <h2>expired_at</h2>
     * <p>
     * expired_at
     * </p>
     */
    @Column(name = "expired_at")
    private Timestamp expired_at;

    /**
     * <h2>Constructor for PasswordReset</h2>
     * <p>
     * Constructor for PasswordReset
     * </p>
     * 
     * @param passwordResetMailForm
     */
    public PasswordReset(PasswordResetMailForm passwordResetMailForm) {
        super();
        this.user_email = passwordResetMailForm.getUser_email();
        this.token = passwordResetMailForm.getToken();
        this.created_at = passwordResetMailForm.getCreated_at();
        this.expired_at = passwordResetMailForm.getExpired_at();
    }
}