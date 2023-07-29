package cgmgl.springmvc.app.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.bl.service.JobPostService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.Authority;
import cgmgl.springmvc.app.persistence.entity.JobType;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * <h2>LoginController Class</h2>
 * <p>
 * Process for Displaying LoginController
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */

@Controller
public class LoginController {
    /**
     * <h2>userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2>jobPostService</h2>
     * <p>
     * jobPostService
     * </p>
     */
    @Autowired
    private JobPostService jobPostService;

    /**
     * <h2>session</h2>
     * <p>
     * session
     * </p>
     */
    @Autowired
    private HttpSession session;

    /**
     * <h2>Homepage</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public ModelAndView Homepage(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("homePage");
        List<JobType> typeList = jobPostService.doGetJobTypeList();
        model.addObject("JobTypeList", typeList);
        return model;
    }

    /**
     * <h2>homePageView</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/homePageView")
    public ModelAndView homePageView(ModelAndView model) {
        List<JobType> typeList = jobPostService.doGetJobTypeList();
        model.addObject("JobTypeList", typeList);
        model.setViewName("homePage");
        return model;
    }

    /**
     * <h2>homePage</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return ModelAndView
     * @throws IOException 
     */
    @RequestMapping(value = "/home")
    public ModelAndView homePage(ModelAndView model, Principal authentication) throws IOException {
        // ModelAndView model = new ModelAndView();
        List<JobType> typeList = jobPostService.doGetJobTypeList();
        model.addObject("JobTypeList", typeList);
        User user = this.userService.doGetLoginInfo();
        model.setViewName("homePage");
        if (user.getApplicantInfo() != null && user.getApplicantInfo().getProfile() != null) {
            String applicantImagePath = user.getApplicantInfo().getProfile();
            System.out.println(applicantImagePath + "Path");
            File applicantImgFile = new File(applicantImagePath);
            ApplicantInfo applicant = user.getApplicantInfo();
            if (applicantImgFile.exists()) {
                FileInputStream fis = new FileInputStream(applicantImgFile);
                byte byteArray[] = new byte[(int) applicantImgFile.length()];
                fis.read(byteArray);
                String imageString = "data:image/png;base64," + Base64.encodeBase64String(byteArray);
                applicant.setProfile(imageString);
                user.setApplicantInfo(applicant);
            }
        }
        session.setAttribute("Login", user);
        return model;
    }

    /**
     * <h2>aboutUsPage</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/aboutus")
    public ModelAndView aboutUsPage(ModelAndView model) {
        model.setViewName("aboutus");
        return model;
    }

    /**
     * <h2>companyPage</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String companyPage() {
        return "admin";
    }

    /**
     * <h2>AccessDenied</h2>
     * <h2>applicantPage</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView AccessDenied(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("access-denied");
        return model;
    }
    /**
     * <h2>Logout</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    /*
     * @RequestMapping(value = "/logout", method = RequestMethod.GET) public
     * ModelAndView Logout(HttpServletRequest request) { ModelAndView model = new
     * ModelAndView("redirect:/homePageView"); return model; }
     */
}