/*
 * package cgmgl.springmvc.app.common;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import javax.annotation.PostConstruct;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.stereotype.Component;
 * 
 * import cgmgl.springmvc.app.persistence.dao.AuthorityDao; import
 * cgmgl.springmvc.app.persistence.dao.UserDao; import
 * cgmgl.springmvc.app.persistence.entity.ApplicantInfo; import
 * cgmgl.springmvc.app.persistence.entity.Authority; import
 * cgmgl.springmvc.app.persistence.entity.User;
 * 
 *//**
    * <h2>DeploymentListencer Class</h2>
    * <p>
    * Process for Displaying DeploymentListencer
    * </p>
    * 
    * @author Yin Yin Swe
    *
    */
/*
 * @Component public class DeploymentListencer {
 *//**
    * <h2>passwordEncoder</h2>
    * <p>
    * passwordEncoder
    * </p>
    */
/*
 * @Autowired private BCryptPasswordEncoder passwordEncoder;
 * 
 *//**
    * <h2>authorityDAO</h2>
    * <p>
    * authorityDAO
    * </p>
    */
/*
 * @Autowired private AuthorityDao authorityDAO;
 * 
 *//**
    * <h2>userDAO</h2>
    * <p>
    * userDAO
    * </p>
    */
/*
 * @Autowired private UserDao userDAO;
 *//**
    * <h2>addInitialData</h2>
    * <p>
    * 
    * </p>
    *
    * @return void
    *//*
       * @PostConstruct public void addInitialData() {
       * 
       * // adding default data if (this.authorityDAO.dbGetAuthorityCount() <= 0 &&
       * this.userDAO.dbGetUserCount() <= 0) { List<Authority> adminAuthorities = new
       * ArrayList<Authority>(); Authority adminAuthority = new Authority(null,
       * "ROLE_ADMIN"); this.authorityDAO.dbSaveAuthority(adminAuthority);
       * adminAuthorities.add(adminAuthority); User admin = new User(1,
       * "admin","htetn4494@gmail.com" , passwordEncoder.encode("123"), null, null,
       * null, null, adminAuthorities); this.userDAO.dbSaveUser(admin);
       * 
       * List<Authority> userAuthorities = new ArrayList<Authority>(); Authority
       * userAuthority = new Authority(null, "ROLE_USER");
       * this.authorityDAO.dbSaveAuthority(userAuthority);
       * userAuthorities.add(userAuthority); User user = new User(2, "user",
       * passwordEncoder.encode("123"), "yinyinswe1999@gmail.com", null, null, null,
       * null, userAuthorities); this.userDAO.dbSaveUser(user);
       * 
       * List<Authority> fullAdminAuthorities = new ArrayList<Authority>(); Authority
       * admin1Authority = new Authority(null, "ROLE_FULL_ADMIN");
       * this.authorityDAO.dbSaveAuthority(admin1Authority);
       * fullAdminAuthorities.add(admin1Authority); User user1 = new User(3,
       * "full-admin", passwordEncoder.encode("123"), null, null, null, null, null,
       * fullAdminAuthorities); this.userDAO.dbSaveUser(user1); } }
       * 
       * }
       */