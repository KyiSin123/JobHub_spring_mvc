package cgmgl.springmvc.app.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.PasswordResetForm;
import cgmgl.springmvc.app.bl.dto.PasswordResetMailForm;
import cgmgl.springmvc.app.bl.service.PasswordResetService;
import cgmgl.springmvc.app.bl.service.UserService;

/**
 * <h2> PasswordResetController Class</h2>
 * <p>
 * Process for Displaying PasswordResetController
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Controller
public class PasswordResetController {
    /**
     * <h2> mailSender</h2>
     * <p>
     * mailSender
     * </p>
     */
    @Autowired
    JavaMailSender mailSender;

    /**
     * <h2> userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    UserService userService;

    /**
     * <h2> passwordResetService</h2>
     * <p>
     * passwordResetService
     * </p>
     */
    @Autowired
    PasswordResetService passwordResetService;

    /**
     * <h2> messageSource</h2>
     * <p>
     * messageSource
     * </p>
     */
    @Autowired
    MessageSource messageSource;

    /**
     * <h2> email</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/loginForm/forgot_password", method = RequestMethod.GET)
    public ModelAndView email(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("emailSend");
        model.addObject("emailForm", new PasswordResetMailForm());
        model.setViewName("emailSend");
        return model;
    }

    /**
     * <h2> sendEmail</h2>
     * <p>
     * 
     * </p>
     *
     * @param passwordResetMailForm
     * @param result
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/loginForm/password/sendEmail", method = RequestMethod.POST)
    public ModelAndView sendEmail(@Valid @ModelAttribute("emailForm") PasswordResetMailForm passwordResetMailForm,
            BindingResult result, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("emailSend");

        if (result.hasErrors()) {
            model.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return model;
        }

        if (!userService.doIsEmailExist(passwordResetMailForm.getUser_email())) {
            model = new ModelAndView("emailSend");
            model.addObject("errorMsg", "Invalid email address!");
            return model;
        }

        passwordResetMailForm = this.passwordResetService.createResetToken(passwordResetMailForm.getUser_email());
        String url = getBaseUrl(request) + request.getServletPath() + "/" + passwordResetMailForm.getToken();
        this.sendMail(url, passwordResetMailForm);
        ModelAndView newModel = new ModelAndView("redirect:/login");
        return newModel;

    }

    /**
     * <h2> showResetPassword</h2>
     * <p>
     * 
     * </p>
     *
     * @param token
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/loginForm/password/sendEmail/{token}", method = RequestMethod.GET)
    public ModelAndView showResetPassword(@PathVariable String token) {
        ModelAndView mv = new ModelAndView("invalidMail");
        PasswordResetMailForm passwordResetForm = passwordResetService.getDataByToken(token);

        if (passwordResetForm == null) {
            mv.addObject("errorMsg", "Invalid Token! Please check your token url!");
            return mv;
        }

        if (isTokenExpired(passwordResetForm.getExpired_at())) {
            mv.addObject("errorMsg", "Token has been expired!");
            return mv;
        }
        PasswordResetForm passwordChangeResetForm = new PasswordResetForm();
        passwordChangeResetForm.setToken(token);
        mv.setViewName("passwordReset");
        mv.addObject("passwordResetForm", passwordChangeResetForm);
        return mv;
    }

    /**
     * <h2> resetPassword</h2>
     * <p>
     * 
     * </p>
     *
     * @param passwordResetForm
     * @param result
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/loginForm/password/reset", method = RequestMethod.POST)
    public ModelAndView resetPassword(@Valid @ModelAttribute("passwordResetForm") PasswordResetForm passwordResetForm,
            BindingResult result) {

        ModelAndView model = new ModelAndView("passwordReset");
        if (result.hasErrors()) {
            return model;
        }
        String userEmail = passwordResetService.getDataByToken(passwordResetForm.getToken()).getUser_email();
        PasswordResetMailForm newPasswordResetForm = new PasswordResetMailForm();
        newPasswordResetForm.setUser_email(userEmail);
        newPasswordResetForm.setPassword(passwordResetForm.getPassword());
        this.passwordResetService.doUpdatePassword(newPasswordResetForm);
        this.passwordResetService.doDeleteToken(passwordResetForm.getToken());
        ModelAndView mv = new ModelAndView("redirect:/login");
        return mv;

    }

    /**
     * <h2> isTokenExpired</h2>
     * <p>
     * 
     * </p>
     *
     * @param expired_at
     * @return
     * @return boolean
     */
    private boolean isTokenExpired(Timestamp expired_at) {
        Timestamp now = new Timestamp(new Date().getTime());
        return now.after(expired_at);
    }

    /**
     * <h2> getBaseUrl</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return String
     */
    private String getBaseUrl(HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName();
        if (request.getServerPort() != 0) {
            url = url + ":" + request.getServerPort();
        }
        url = url + request.getContextPath();
        return url;
    }

    /**
     * <h2> sendMail</h2>
     * <p>
     * 
     * </p>
     *
     * @param url
     * @param passwordResetMailForm
     * @return void
     */
    public void sendMail(String url, PasswordResetMailForm passwordResetMailForm) {
        String sender = "htetn4494@gmail.com";
        String subject = "Reset Your Password";
        String body = "Reset your password from following url : \n";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(passwordResetMailForm.getUser_email());
        email.setFrom(sender);
        email.setSubject(subject);
        email.setText(body + url);
        mailSender.send(email);
    }
}