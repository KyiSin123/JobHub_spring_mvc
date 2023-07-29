package cgmgl.springmvc.app.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.ApplicantJobPostDto;
import cgmgl.springmvc.app.bl.dto.JobPostDto;
import cgmgl.springmvc.app.bl.service.ApplicantJobPostService;
import cgmgl.springmvc.app.bl.service.JobPostService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.ApplicantJobPost;
import cgmgl.springmvc.app.persistence.entity.JobPost;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * <h2> ApplicantJobPostController Class</h2>
 * <p>
 * Process for Displaying ApplicantJobPostController
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Controller
public class ApplicantJobPostController {
    /**
     * <h2> applicantJobPostService</h2>
     * <p>
     * applicantJobPostService
     * </p>
     */
    @Autowired
    private ApplicantJobPostService applicantJobPostService;

    /**
     * <h2> userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2> messageSource</h2>
     * <p>
     * messageSource
     * </p>
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * <h2> jobPostService</h2>
     * <p>
     * jobPostService
     * </p>
     */
    @Autowired
    private JobPostService jobPostService;

    /**
     * <h2> applyJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @param id
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/post/apply", method = RequestMethod.GET)
    public ModelAndView applyJobPost(ModelAndView model, @RequestParam int id) {
        ModelAndView applyJobPost = new ModelAndView("applyJobPost");
        ApplicantJobPostDto applicantJobPostDto = new ApplicantJobPostDto();
        JobPostDto jobPostDto = this.jobPostService.doGetJobPostById(id);
        JobPost jobPost = new JobPost(jobPostDto);
        applicantJobPostDto.setJobPost(jobPost);
        applyJobPost.addObject("ApplicantJobPostDto", applicantJobPostDto);
        applyJobPost.setViewName("applyJobPost");
        return applyJobPost;
    }

    /**
     * <h2> applyJobPost</h2>
     * <p>
     * 
     * </p>
     *
     * @param cvUpload
     * @param applicantJobDto
     * @param result
     * @param request
     * @param response
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/post/apply/insert", method = RequestMethod.POST)
    public ModelAndView applyJobPost(@RequestParam CommonsMultipartFile[] cvUpload,
            @ModelAttribute("ApplicantJobPostDto") @Valid ApplicantJobPostDto applicantJobDto, BindingResult result,
            HttpServletRequest request, HttpServletResponse response) {
        ModelAndView applyJobPostView = new ModelAndView("redirect:/post/applicant/list");
        if (result.hasErrors()) {
            System.out.println(result.getFieldError());
            System.out.println("ERROR CV File name......" + cvUpload);
            ModelAndView errorView = new ModelAndView("applyJobPost");
            errorView.addObject("ApplicantJobPostDto", applicantJobDto);
            errorView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return errorView;
        }
        if (cvUpload == null || cvUpload.length <= 0) {
            ModelAndView errorView = new ModelAndView("applyJobPost");
            errorView.addObject("ApplicantJobPostDto", applicantJobDto);
            errorView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return errorView;
        }
        if (cvUpload != null && cvUpload.length > 0) {
            for (CommonsMultipartFile aFile : cvUpload) {
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                applicantJobDto.setCv_file_name(aFile.getOriginalFilename());
                applicantJobDto.setFile_data(aFile.getBytes());
            }
        }
        this.applicantJobPostService.doAddApplicantJobPost(applicantJobDto);
        System.out.println("CV File name......" + cvUpload);
        return applyJobPostView;
    }

    /**
     * <h2> download</h2>
     * <p>
     * 
     * </p>
     *
     * @param applicantJobPostId
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @return ModelAndView
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView download(@RequestParam("id") Integer applicantJobPostId, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView view = new ModelAndView("redirect:/post/apply/list");
        ApplicantJobPost applicantJobPost = applicantJobPostService.doGetApplicantJobPostById(applicantJobPostId);
        response.setContentLength(applicantJobPost.getFile_data().length);
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + applicantJobPost.getCv_file_name() + "\"");
        FileCopyUtils.copy(applicantJobPost.getFile_data(), response.getOutputStream());
        return view;
    }

    /**
     * <h2> applicantApplyJobList</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return ModelAndView
     * @throws IOException 
     */

    @RequestMapping(value = "/post/apply/list")
    public ModelAndView applicantApplyJobList(ModelAndView model) throws IOException {
        User user = userService.doGetLoginInfo();
        List<ApplicantJobPost> applicantJobPostList = applicantJobPostService.doGetApplicantJobPostList();
        List<User> userList = this.userService.doGetUserList();
        List<ApplicantJobPost> applicantJobPostListByComId=new ArrayList<ApplicantJobPost>();
        for(ApplicantJobPost applicantJobPost:applicantJobPostList) {
            if(applicantJobPost.getJobPost().getCompany().getCompany_id()==user.getCompany().getCompany_id()) {
                applicantJobPostListByComId.add(applicantJobPost);
                String applicantImagePath = applicantJobPost.getApplicantInfo().getProfile();
                System.out.println(applicantImagePath + "Path");
                File applicantImgFile = new File(applicantImagePath);
                ApplicantInfo applicant = applicantJobPost.getApplicantInfo();
                if (applicantImgFile.exists()) {
                    FileInputStream fis = new FileInputStream(applicantImgFile);
                    byte byteArray[] = new byte[(int) applicantImgFile.length()];
                    fis.read(byteArray);
                    String imageString = "data:image/png;base64," + Base64.encodeBase64String(byteArray);
                    applicant.setProfile(imageString);
                    applicantJobPost.setApplicantInfo(applicant);
                }
            }
        }
        model.addObject("UserList", userList);
        model.addObject("ApplicantJobPostList", applicantJobPostListByComId);
        model.setViewName("applicantJobPostList");
        return model;
    }

    /**
     * <h2> applicantJobPostAccept</h2>
     * <p>
     * 
     * </p>
     *
     * @param applicantJobPostId
     * @return
     * @return ModelAndView
     * @throws IOException 
     */
    @RequestMapping(value = "/post/apply/accept")
    public ModelAndView applicantJobPostAccept(@RequestParam("id") Integer applicantJobPostId) throws IOException {
        User user = userService.doGetLoginInfo();
        ModelAndView stautsView = new ModelAndView("redirect:/post/apply/list");
        ApplicantJobPostDto applicantJobStatus = applicantJobPostService
                .doGetApplicantJobAcceptById(applicantJobPostId);
        List<ApplicantJobPost> applicantJobPostList = applicantJobPostService.doGetApplicantJobPostList();
        List<User> userList = this.userService.doGetUserList();
        List<ApplicantJobPost> applicantJobPostListByComId=new ArrayList<ApplicantJobPost>();
        for(ApplicantJobPost applicantJobPost:applicantJobPostList) {
            if(applicantJobPost.getJobPost().getCompany().getCompany_id()==user.getCompany().getCompany_id()) {
                applicantJobPostListByComId.add(applicantJobPost);
                String applicantImagePath = applicantJobPost.getApplicantInfo().getProfile();
                System.out.println(applicantImagePath + "Path");
                File applicantImgFile = new File(applicantImagePath);
                ApplicantInfo applicant = applicantJobPost.getApplicantInfo();
                if (applicantImgFile.exists()) {
                    FileInputStream fis = new FileInputStream(applicantImgFile);
                    byte byteArray[] = new byte[(int) applicantImgFile.length()];
                    fis.read(byteArray);
                    String imageString = "data:image/png;base64," + Base64.encodeBase64String(byteArray);
                    applicant.setProfile(imageString);
                    applicantJobPost.setApplicantInfo(applicant);
                }
            }
        }
        stautsView.addObject("UserList", userList);
        stautsView.addObject("ApplicantJobPostList", applicantJobPostListByComId);
        stautsView.addObject("ApplicantJobPostDto", applicantJobStatus);
        stautsView.setViewName("applicantJobPostList");
        return stautsView;
    }

    /**
     * <h2> applicantJobPostReject</h2>
     * <p>
     * 
     * </p>
     *
     * @param applicantJobPostId
     * @return
     * @return ModelAndView
     * @throws IOException 
     */
    @RequestMapping(value = "/post/apply/reject")
    public ModelAndView applicantJobPostReject(@RequestParam("id") Integer applicantJobPostId) throws IOException {
        User user = userService.doGetLoginInfo();
        ModelAndView stautsView = new ModelAndView("redirect:/post/apply/list");
        ApplicantJobPostDto applicantJobStatus = applicantJobPostService.doGetApplicantJobRejectById(applicantJobPostId);
        List<ApplicantJobPost> applicantJobPostList = applicantJobPostService.doGetApplicantJobPostList();
        List<User> userList = this.userService.doGetUserList();
        List<ApplicantJobPost> applicantJobPostListByComId=new ArrayList<ApplicantJobPost>();
        for(ApplicantJobPost applicantJobPost:applicantJobPostList) {
            if(applicantJobPost.getJobPost().getCompany().getCompany_id()==user.getCompany().getCompany_id()) {
                applicantJobPostListByComId.add(applicantJobPost);
                String applicantImagePath = applicantJobPost.getApplicantInfo().getProfile();
                System.out.println(applicantImagePath + "Path");
                File applicantImgFile = new File(applicantImagePath);
                ApplicantInfo applicant = applicantJobPost.getApplicantInfo();
                if (applicantImgFile.exists()) {
                    FileInputStream fis = new FileInputStream(applicantImgFile);
                    byte byteArray[] = new byte[(int) applicantImgFile.length()];
                    fis.read(byteArray);
                    String imageString = "data:image/png;base64," + Base64.encodeBase64String(byteArray);
                    applicant.setProfile(imageString);
                    applicantJobPost.setApplicantInfo(applicant);
                }
            }
        }
        stautsView.addObject("UserList", userList);
        stautsView.addObject("ApplicantJobPostList", applicantJobPostListByComId);
        stautsView.addObject("ApplicantJobPostDto", applicantJobStatus);
        stautsView.setViewName("applicantJobPostList");
        return stautsView;
    }
}