package cgmgl.springmvc.app.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.ApplicantDto;
import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.bl.dto.UserDto;
import cgmgl.springmvc.app.bl.service.AuthorityService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.dao.UserDao;
import cgmgl.springmvc.app.persistence.entity.Authority;
import cgmgl.springmvc.app.persistence.entity.User;

@Controller
public class UserController {
	@Autowired
	MessageSource messageSource;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Autowired
	private AuthorityService authorityService;
	
//	@Autowired
//	private HttpSession session;

	/**
	 * <h2>userService</h2>
	 * <p>
	 * userService
	 * </p>
	 */
	@Autowired
	UserService userService;
	
	@Autowired
	private HttpSession session;
	

	/**
	 * <h2>email</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param request
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginEmail(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("loginPage");	
		if(this.userService.doIsLoggedIn()) {
		    model.setViewName("homePage");
		}
		return model;		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView newUser() {
		List<Authority> authorities = authorityService.doGetAuthList();
		UserDto userForm = new UserDto();
		ModelAndView createUser = new ModelAndView("register");
		createUser.addObject("userForm", userForm);
		createUser.addObject("authorityRoles", authorities);
		createUser.setViewName("register");
		return createUser;
	}

	@RequestMapping(value = { "/userInfo" }, method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("userForm") @Valid UserDto userDto, BindingResult result,
	        HttpServletRequest request, HttpServletResponse response) {
		ModelAndView userView = new ModelAndView("register");
		System.out.println("current" + userDto.getEmail());
		int authoId = userDto.getAuthority().getId();
		System.out.println("Error:" + result.hasErrors());
		if (result.hasErrors()) {
			List<Authority> authorities = authorityService.doGetAuthList();
			userView.addObject("userForm", userDto);
			userView.addObject("authorityRoles", authorities);
			userView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
			return userView;
		}

		List<String> emailList = userService.doGetEmailList();
		for (String email : emailList) {
			System.out.println(email);
			if (email.equals(userDto.getEmail())) {
				List<Authority> authorities = authorityService.doGetAuthList();
				userView.addObject("userForm", userDto);
				userView.addObject("authorityRoles", authorities);
				userView.addObject("errorMsg", "Your email has already been registered!");
				return userView;
			}
		}

		System.out.println(!userDto.getPassword().equals(userDto.getConfirmPwd()));
		if (!userDto.getPassword().equals(userDto.getConfirmPwd())) {
			List<Authority> authorities = authorityService.doGetAuthList();
			userView.addObject("userForm", userDto);
			userView.addObject("authorityRoles", authorities);
			userView.addObject("errorMsg", "Invalid Password!");
			return userView;
		}

		System.out.println(authoId);
		if (authoId == 3) {
			List<Authority> authoList = new ArrayList<Authority>();
			Authority authority = authorityService.doGetAuthById(authoId);
			authoList.add(authority);
			userDto.setAuthorityList(authoList);
			ApplicantDto applicantDto = new ApplicantDto();
			ModelAndView applicantRegister = new ModelAndView("applicantInfo");
			applicantRegister.addObject("applicantInfoForm", applicantDto);
			applicantRegister.addObject("user", userDto);
			applicantRegister.setViewName("applicantInfo");
			return applicantRegister;
		} else if (authoId == 2) {
			List<Authority> authoList = new ArrayList<Authority>();
			Authority authority = authorityService.doGetAuthById(authoId);
			authoList.add(authority);
			userDto.setAuthorityList(authoList);
			CompanyDto companyDto = new CompanyDto();
			ModelAndView companyRegister = new ModelAndView("createCompany");
			companyRegister.addObject("rollBackCompanyForm", companyDto);
			companyRegister.addObject("user", userDto);
			companyRegister.setViewName("createCompany");
			return companyRegister;
		} else {
			List<Authority> authorities = authorityService.doGetAuthList();
			userView.addObject("userForm", userDto);
			userView.addObject("authorityRoles", authorities);
			userView.addObject("errorMsg", "You can't choose Admin role!");
		}
		return userView;
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public ModelAndView newAdmin() {
		List<Authority> authorities = authorityService.doGetAuthList();
		UserDto userForm = new UserDto();
		ModelAndView createUser = new ModelAndView("createUser");
		createUser.addObject("userForm", userForm);
		createUser.addObject("authorityRoles", authorities);
		createUser.setViewName("createUser");
		return createUser;
	}

	@RequestMapping(value = "/createUserConfirm", params = "addAdmin", method = RequestMethod.POST)
	public ModelAndView confirmUser(@ModelAttribute("userForm") @Valid UserDto userDto, BindingResult result,
	        HttpServletRequest request) throws ParseException {
		ModelAndView confirmView = new ModelAndView("createUserConfirm");
		List<Authority> authorities = authorityService.doGetAuthList();
		if (result.hasErrors()) {
			confirmView = new ModelAndView("createUser");
			confirmView.addObject("userForm", userDto);
			confirmView.addObject("authorityRoles", authorities);
			confirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
			return confirmView;
		}
		List<String> emailList = userService.doGetEmailList();
		for (String email : emailList) {
			System.out.println(email);
			if (email.equals(userDto.getEmail())) {
				confirmView = new ModelAndView("createUser");
				confirmView.addObject("userForm", userDto);
				confirmView.addObject("authorityRoles", authorities);
				confirmView.addObject("errorMsg", "Your email has already been registered!");
				return confirmView;
			}
		}

		if (!userDto.getPassword().equals(userDto.getConfirmPwd())) {
			confirmView = new ModelAndView("createUser");
			confirmView.addObject("userForm", userDto);
			confirmView.addObject("authorityRoles", authorities);
			confirmView.addObject("errorMsg", "Invalid Password!");
			return confirmView;
		} else {
			confirmView.addObject("userConfirmForm", userDto);
			confirmView.addObject("authorityRoles", authorities);
			confirmView.setViewName("createUserConfirm");
		}
		return confirmView;
	}

	@RequestMapping(value = "/saveAdmin", params = "confirmAdmin", method = RequestMethod.POST)
	public ModelAndView insertNewAdmin(@ModelAttribute("userConfirmForm") @Valid UserDto userDto, BindingResult result,
	        HttpServletRequest request, HttpServletResponse response) {
		List<Authority> authorities = new ArrayList<Authority>();
		int authoId = userDto.getAuthority().getId();
		Authority authority = authorityService.doGetAuthById(authoId);
		authorities.add(authority);
		userDto.setAuthorityList(authorities);
		this.userService.doSaveUser(userDto);
		ModelAndView createAdminView = new ModelAndView("redirect:/userList");
		return createAdminView;
	}

	@RequestMapping(value = "/saveAdmin", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelStudentConfirm(@ModelAttribute("userConfirmForm") @Valid UserDto userForm,
	        BindingResult result) throws ParseException {
		ModelAndView createUserView = new ModelAndView("createUser");
		List<Authority> authorities = authorityService.doGetAuthList();
		createUserView.addObject("userForm", userForm);
		createUserView.addObject("authorityRoles", authorities);
		return createUserView;
	}

	@RequestMapping(value = "/applicantInfoSave", params = "addApplicant", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("applicantInfoForm") @Valid ApplicantDto applicantForm,
	        BindingResult result, @RequestParam("imageData") String imageData, HttpServletRequest request,
	        HttpServletResponse response) throws FileNotFoundException, IOException {
		ModelAndView confirmView = new ModelAndView("applicantInfo");
		applicantForm.setProfile(imageData);
		if (result.hasErrors()) {
			confirmView.addObject("applicantInfoForm", applicantForm);
			confirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
			return confirmView;
		}

		List<Authority> authorities = new ArrayList<Authority>();
		System.out.println(applicantForm.getAuthority().getId());
		int authoId = applicantForm.getAuthority().getId();
		Authority authority = authorityService.doGetAuthById(authoId);
		authorities.add(authority);
		applicantForm.setAuthorityList(authorities);
		this.userService.doSaveUser(applicantForm);
		ModelAndView createUserView = new ModelAndView("redirect:/login");
		return createUserView;
	}

	@RequestMapping(value = "/userList")
	public ModelAndView getUserList(ModelAndView model) throws IOException {
		List<User> userList = userService.doGetUserList();
		model.addObject("UserList", userList);
		model.setViewName("userList");
		return model;
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam("id") Long userId, HttpServletRequest request) {
		UserDto userForm = userService.getUserByID(userId);
		List<Authority> authorities = authorityService.doGetAuthList();
		for (Authority authority : userForm.getAuthorityList()) {
			userForm.setAuthority(authority);
		}
		ModelAndView model = new ModelAndView("updateUser");
		model.addObject("user", userForm);
		model.addObject("authorityRoles", authorities);
		model.setViewName("updateUser");
		return model;
	}

	@RequestMapping(value = "/updateUser", params = "updateUser", method = RequestMethod.POST)
	public ModelAndView callUpdateUserConfirm(@ModelAttribute("user") @Valid UserDto userForm, BindingResult result)
	        throws ParseException, FileNotFoundException, IOException {
		userForm.setPassword(passEncoder.encode(userForm.getPassword()));
		this.userService.doUpdateUser(userForm);
		ModelAndView updateUserView = new ModelAndView("redirect:/userList");
		return updateUserView;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		long userId = Integer.parseInt(request.getParameter("id"));
		userService.doDeleteUser(userId);
		return new ModelAndView("redirect:/userList");
	}
}