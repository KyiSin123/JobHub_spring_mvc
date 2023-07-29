package cgmgl.springmvc.app.bl.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cgmgl.springmvc.app.persistence.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <h2>CustomUserDetail Class</h2>
 * <p>
 * Process for Displaying CustomUserDetail
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetail implements UserDetails {
    /**
     * <h2>serialVersionUID</h2>
     * <p>
     * serialVersionUID
     * </p>
     */
    private static final long serialVersionUID = 7376528184215268346L;
    
    private String username;
    
    /**
     * <h2>password</h2>
     * <p>
     * password
     * </p>
     */
    private String password;
    /**
     * <h2>authorities</h2>
     * <p>
     * authorities
     * </p>
     */
    private List<Authority> authorities;

    /**
     * <h2>getAuthorities</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
   
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        for (Authority authority : this.authorities) {
            list.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return list;
    }

    /**
     * <h2>getPassword</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * <h2>getUsername</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * <h2>isAccountNonExpired</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * <h2>isAccountNonLocked</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * <h2>isCredentialsNonExpired</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * <h2>isEnabled</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}