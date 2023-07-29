package cgmgl.springmvc.app.bl.service.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.ApplicantProfileDto;
import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.bl.dto.CustomUserDetail;
import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.dao.ApplicantInfoDao;
import cgmgl.springmvc.app.persistence.dao.CompanyDAO;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.Company;
import cgmgl.springmvc.app.persistence.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDAO;

    @Autowired
    private ApplicantInfoDao applicantInfoDao;

    @Autowired
    private CompanyDAO companyDao;

    @Autowired
    HttpServletRequest request;

    @Override
    public User doGetUserById(long userId) {
        // TODO Auto-generated method stub
        User resultPost = this.userDAO.dbGetUserById(userId);
        return resultPost;
    }

    @Override
    public void doUpdateUser(@Valid User user) {
        // TODO Auto-generated method stub
        this.userDAO.dbUpdateUser(user);
    }

    /**
     * <h2>doGetUserByName</h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     */
    @Override
    public User doGetUserByName(String username) {
        return this.userDAO.dbGetUserByName(username);
    }

    /**
     * <h2>doGetUserCount</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public long doGetUserCount() {

        return this.userDAO.dbGetUserCount();
    }

    /**
     * <h2>loadUserByUsername</h2>
     * <p>
     * 
     * </p>
     * 
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userInfo = this.userDAO.dbGetUserByEmail(email);

        if (userInfo == null) {
            throw new UsernameNotFoundException("Invalid Username or Password!");
        }
        UserDetails user = new CustomUserDetail(userInfo.getEmail(), userInfo.getPassword(), userInfo.getAuthorities());
        return user;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void doSaveUser(@Valid ApplicantDto applicantForm) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        String applicantImgPath = request.getRealPath("/") + "/resources/images/" + applicantForm.getUser().getName();
        Path uploadPath = Paths.get(applicantImgPath);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        applicantImgPath = uploadPath + "/" + applicantForm.getUser().getName() + ".png";
        String imageBase64 = applicantForm.getProfile();
        if (!imageBase64.isEmpty() && !imageBase64.equals("") && !imageBase64.equals(null)) {
            String[] block = imageBase64.split(",");
            String realData = block[1];
            byte[] data = Base64.decodeBase64(realData);
            try (FileOutputStream stream = new FileOutputStream(applicantImgPath)) {
                stream.write(data);
            }
            applicantForm.setProfile(applicantImgPath);
        }
        ApplicantInfo applicantInfo = new ApplicantInfo(applicantForm);
        Date created_date = new Date();
        applicantInfoDao.dbSaveApplicantInfo(applicantInfo);
        User user = new User(applicantForm);
        user.setPassword(passwordEncoder.encode(applicantForm.getUser().getPassword()));
        this.userDAO.dbAddUser(user, applicantInfo, created_date);
    }

    @Override
    public List<User> doGetUserList() {
        // TODO Auto-generated method stub
        return userDAO.dbGetUserList();
    }

    @Override
    public UserDto getUserByID(Long userId) {
        // TODO Auto-generated method stub
        User resultPost = this.userDAO.dbGetUserById(userId);
        UserDto resultPostform = resultPost != null ? new UserDto(resultPost) : null;
        return resultPostform;
    }

    @Override
    public void doUpdateUser(@Valid UserDto userForm) {
        // TODO Auto-generated method stub
        Date updatedDate = new Date();
        User updateUser = this.userDAO.dbGetUserById(userForm.getId());
        updateUser.setName(userForm.getUsername());
        updateUser.setEmail(userForm.getEmail());
        updateUser.setPassword(userForm.getPassword());
        updateUser.setUpdated_at(updatedDate);
        this.userDAO.dbUpdateUser(updateUser);
    }

    /**
     * <h2>doIsEmailExist</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user_email
     * @return
     */
    @Override
    public boolean doIsEmailExist(String user_email) {
        boolean result = false;
        User user = this.userDAO.dbFindUserByAllEmail(user_email);
        if (user != null) {
            result = true;
        }
        return result;
    }

    @Override
    public User doGetUserByEmail(String userEmail) {
        User resultUser = this.userDAO.dbGetUserByEmail(userEmail);
        return resultUser;
    }

    @Override
    public void doDeleteUser(long userId) {
        // TODO Auto-generated method stub
        Date deletedAt = new Date();
        User user = this.userDAO.dbGetUserById(userId);
        this.userDAO.dbDeleteUser(user, deletedAt);
    }

    @Override
    public List<String> doGetEmailList() {
        // TODO Auto-generated method stub
        return userDAO.dbGetUserEmailList();
    }

    @Override
    public void doSaveUser(@Valid UserDto userDto) {
        // TODO Auto-generated method stub
        Date created_date = new Date();
        User user = new User(userDto);
        this.userDAO.dbAddUser(user, null, created_date);
    }

    @Override
    public void doSaveCompany(@Valid CompanyDto companydto) {
        // TODO Auto-generated method stub
        Company companyInfo = new Company(companydto);
        Date created_date = new Date();
        companyDao.dbaddCompany(companyInfo, created_date);
        User user = new User(companydto);
        user.setPassword(passwordEncoder.encode(companydto.getUser().getPassword()));
        this.userDAO.dbAddCompany(user, companyInfo, created_date);
    }

    @Override
    public User doGetLoginInfo() {
        String user_email = null;
        // TODO Auto-generated method stub
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            user_email = ((UserDetails) principal).getUsername();
        } else {
            user_email = principal.toString();
        }
        User user = userDAO.dbGetUserByEmail(user_email);
        return user;
    }

    @Override
    public boolean doIsLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
                && authentication.isAuthenticated();
    }

    @Override
    public List<User> doGetUserNameList() {
        return this.userDAO.dbGetUserNameList();
    }

    @SuppressWarnings("resource")
    @Override
    public User doGetApplicantById(long userIdForApplicant) throws IOException {
        // TODO Auto-generated method stub
        User user = this.doGetUserById(userIdForApplicant);
        UserDto userDto = new UserDto(user);
        if (userDto.getApplicantInfo() != null && userDto.getApplicantInfo().getProfile() != null) {
            String applicantImagePath = userDto.getApplicantInfo().getProfile();
            System.out.println(applicantImagePath + "Path");
            File applicantImgFile = new File(applicantImagePath);
            ApplicantInfo applicant = userDto.getApplicantInfo();
            System.out.println(applicantImgFile + "File");
            if (applicantImgFile.exists()) {
                System.out.println(applicantImgFile.exists() + "boolean");
                FileInputStream fis = new FileInputStream(applicantImgFile);
                byte byteArray[] = new byte[(int) applicantImgFile.length()];
                fis.read(byteArray);
                String imageString = "data:image/png;base64," + Base64.encodeBase64String(byteArray);
                System.out.println(imageString);
                System.out.println(applicant.getAddress());
                applicant.setProfile(imageString);
                userDto.setApplicantInfo(applicant);
            }
        }
        return user;
    }

    @Override
    public ApplicantProfileDto doGetApplicantByEmail(String userEmail) {
        // TODO Auto-generated method stub
        User user = this.userDAO.dbGetUserByEmail(userEmail);
        ApplicantProfileDto resultPost = user != null ? new ApplicantProfileDto(user) : null;
        return resultPost;
    }

    @Override
    public void doUpdateApplicant(@Valid ApplicantProfileDto profileDto) {
        // TODO Auto-generated method stub
        Date updatedDate = new Date();
        User updateUser = this.userDAO.dbGetUserByEmail(profileDto.getEmail());
        updateUser.setName(profileDto.getName());
        updateUser.setEmail(profileDto.getEmail());
        ApplicantInfo applicantdb = this.applicantInfoDao.dbGetApplicantById(profileDto.getApplicantId());
        if (profileDto.getProfile() != "") {
            applicantdb.setProfile(profileDto.getProfile());
        }
        applicantdb.setPhone(profileDto.getPhone());
        applicantdb.setAddress(profileDto.getAddress());
        applicantdb.setJob_exp_year(profileDto.getJob_exp_year());
        applicantdb.setJob_history(profileDto.getJob_history());
        applicantdb.setEdu_bg(profileDto.getEdu_bg());
        applicantdb.setCertificates(profileDto.getCertificates());
        applicantdb.setGender(profileDto.getGender());
        // ApplicantInfo applicant = new ApplicantInfo(profileDto);
        updateUser.setApplicantInfo(applicantdb);
        System.out.println(applicantdb.getId());
        updateUser.setUpdated_at(updatedDate);
        this.userDAO.dbUpdateUser(updateUser);
    }
}