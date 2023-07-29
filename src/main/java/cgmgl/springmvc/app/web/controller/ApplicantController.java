package cgmgl.springmvc.app.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.ApplicantProfileDto;
import cgmgl.springmvc.app.bl.service.ApplicantInfoService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.entity.ApplicantInfo;
import cgmgl.springmvc.app.persistence.entity.User;

@Controller
public class ApplicantController {
	@Autowired
	MessageSource messageSource;

	@Autowired
	private ApplicantInfoService applicantService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/applicant/list")
	public ModelAndView getApplicantList(ModelAndView model) throws IOException {
		List<ApplicantInfo> applicantList = applicantService.doGetApplicantList();
		model.addObject("ApplicantList", applicantList);
		model.setViewName("applicantList");
		return model;
	}

	@RequestMapping(value = "/applicant/profile", method = RequestMethod.GET)
	public ModelAndView showApplicantProfile(ModelAndView model) throws IOException {
		User user = userService.doGetLoginInfo();
		long userIdForApplicant = user.getId();
		System.out.println(userIdForApplicant);
		User applicant = this.userService.doGetApplicantById(userIdForApplicant);
		model.addObject("ApplicantProfile", applicant);
		model.setViewName("applicantProfile");
		return model;
	}

	@RequestMapping(value = "/applicant/profile/edit", params = "close", method = RequestMethod.POST)
	public ModelAndView closeApplicant() {
		ModelAndView updateUserView = new ModelAndView("redirect:/home");
		return updateUserView;
	}

	@RequestMapping(value = "/applicant/profile/edit", params = "editApplicant", method = RequestMethod.POST)
	public ModelAndView editApplicant(@RequestParam("email") String userEmail, HttpServletRequest request) {
		ApplicantProfileDto appProfile = userService.doGetApplicantByEmail(userEmail);
		ModelAndView model = new ModelAndView("updateApplicantProfile");
		model.addObject("updateApplicant", appProfile);
		model.setViewName("updateApplicantProfile");
		return model;
	}

	@RequestMapping(value = "/applicant/profile/update", params = "updateApplicant", method = RequestMethod.POST)
	public ModelAndView updateApplicant(@ModelAttribute("updateApplicant") @Valid ApplicantProfileDto profileDto,
	        BindingResult result, @RequestParam("imageData") String imageData)
	        throws ParseException, FileNotFoundException, IOException {
		ModelAndView model = new ModelAndView("updateApplicantProfile");
		if (result.hasErrors()) {
			model.addObject("updateApplicant", profileDto);
			model.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
			return model;
		}
		profileDto.setProfile(imageData);
		this.userService.doUpdateApplicant(profileDto);
		ModelAndView updateUserView = new ModelAndView("redirect:/applicant/profile");
		return updateUserView;
	}

	@RequestMapping(value = "/applicant/profile/update", params = "close", method = RequestMethod.POST)
	public ModelAndView closeApplicantProfile(@ModelAttribute("updateApplicant") @Valid ApplicantProfileDto profileDto,
	        BindingResult result, @RequestParam("imageData") String imageData)
	        throws ParseException, FileNotFoundException, IOException {
		ModelAndView updateUserView = new ModelAndView("redirect:/home");
		return updateUserView;
	}

	@RequestMapping(value = "/applicant/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		long applicantId = Integer.parseInt(request.getParameter("id"));
		applicantService.doDeleteUser(applicantId);
		// String fileName = StringUtil
		return new ModelAndView("redirect:/applicant/list");
	}

}