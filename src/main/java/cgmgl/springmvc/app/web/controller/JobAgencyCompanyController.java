package cgmgl.springmvc.app.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import cgmgl.springmvc.app.bl.service.AuthorityService;
import cgmgl.springmvc.app.bl.service.CompanyService;
import cgmgl.springmvc.app.bl.service.UserService;
import cgmgl.springmvc.app.persistence.entity.Authority;
import cgmgl.springmvc.app.persistence.entity.Company;
import cgmgl.springmvc.app.persistence.entity.User;

/**
 * <h2>JobAgencyCompanyController Class</h2>
 * <p>
 * Process for Displaying JobAgencyCompanyController
 * </p>
 * 
 * @author yair naing
 *
 */
@Controller
public class JobAgencyCompanyController {
	@Autowired
	private CompanyService companyservice;

	@Autowired
	private MessageSource messageSources;

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private UserService userService;

	/**
	 * <h2>getCompanyList</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param model
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/company/List", method = RequestMethod.GET)
	public ModelAndView getCompanyList(ModelAndView model) {
		List<Company> companyList = companyservice.dogetCompanyList();
		model.addObject("companyList", companyList);
		model.setViewName("companyList");
		return model;
	}
	
    /*
     * @RequestMapping(value = "/company/applicant/List", method =
     * RequestMethod.GET) public ModelAndView getApplicantJobPostList(ModelAndView
     * model) { model.setViewName("applicantJobPostList"); return model; }
     */

	/**
	 * <h2>createCompany</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param model
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/company/Create", method = RequestMethod.GET)
	public ModelAndView createCompany(ModelAndView model) {

		CompanyDto company = new CompanyDto();
		ModelAndView createCompany = new ModelAndView("createCompany");
		createCompany.addObject("rollBackCompanyForm", company);
		createCompany.setViewName("createCompany");

		return createCompany;
	}

	/**
	 * <h2>resetCompany</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param model
	 * @return
	 * @return ModelAndView
	 */
	/*
	 * @RequestMapping(value = "/createcompanyConfirm", params = "clear", method =
	 * RequestMethod.GET) public ModelAndView resetCompany(ModelAndView model) {
	 * 
	 * CompanyDto company = new CompanyDto(); ModelAndView createCompany = new
	 * ModelAndView("createCompany"); createCompany.addObject("rollBackCompanyForm",
	 * company); createCompany.setViewName("createCompany");
	 * 
	 * return createCompany; }
	 */

	/**
	 * <h2>createCompanyConfirm</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param companydto
	 * @param result
	 * @param request
	 * @return
	 * @throws ParseException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/company/Insert", params = "addCompany", method = RequestMethod.POST)
	public ModelAndView createCompanyConfirm(@ModelAttribute("rollBackCompanyForm") @Valid CompanyDto companydto,
	        BindingResult result, HttpServletRequest request) throws ParseException {
		ModelAndView companyConfirm = new ModelAndView("createCompany");
		if (result.hasErrors()) {

			ModelAndView errorView = new ModelAndView("createCompany");
			errorView.addObject("rollBackCompanyForm", companydto);
			errorView.addObject("errorMsg", messageSources.getMessage("M_SC_0004", null, null));
			errorView.setViewName("createCompany");
			return errorView;
		} else if (this.companyservice.dofindByEmail(companydto.getEmail())) {

			companyConfirm.addObject("rollBackCompanyForm", companydto);
			companyConfirm.addObject("errorMsg", messageSources.getMessage("M_SC_0019", null, null));
			companyConfirm.setViewName("createCompany");
			return companyConfirm;
		} else {

			List<Authority> authorities = new ArrayList<Authority>();
			int authoId = companydto.getAuthority().getId();
			Authority authority = authorityService.doGetAuthById(authoId);
			authorities.add(authority);
			companydto.setAuthorityList(authorities);
			this.userService.doSaveCompany(companydto);
			ModelAndView createCompanyView = new ModelAndView("redirect:/login");
			return createCompanyView;
		}

	}

	/**
	 * <h2>comfirmCompanyCancel</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param companydto
	 * @param result
	 * @param request
	 * @return
	 * @throws ParseException
	 * @return ModelAndView
	 */
	/*
	 * @RequestMapping(value = "/company/Insert", params = "cancel", method =
	 * RequestMethod.POST) public ModelAndView
	 * comfirmCompanyCancel(@ModelAttribute("rollBackCompanyForm") @Valid CompanyDto
	 * companydto, BindingResult result, HttpServletRequest request) throws
	 * ParseException { ModelAndView cancel = new ModelAndView("createCompany");
	 * 
	 * cancel.addObject("rollBackCompanyForm", companydto);
	 * cancel.setViewName("createCompany"); return cancel; }
	 */

	/**
	 * <h2>insertCompany</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param companydto
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	/*
	 * @RequestMapping(value = "/company/Insert", params = "addCompany", method =
	 * RequestMethod.POST)
	 * 
	 * public ModelAndView insertCompany(@ModelAttribute("CompanyForm") @Valid
	 * CompanyDto companydto, BindingResult result, HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * ModelAndView createCompanyView = new ModelAndView("redirect:/company/List");
	 * this.companyservice.doaddCompay(companydto);
	 * 
	 * return createCompanyView;
	 * 
	 * }
	 */

	/**
	 * <h2>profileCompany</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param company_id
	 * @param model
	 * @param request
	 * @return
	 * @return ModelAndView
	 * @throws IOException 
	 */
	@RequestMapping(value = "/company/Profile", method = RequestMethod.GET)
	public ModelAndView profileCompany(@RequestParam("company_id") Integer company_id, ModelAndView model,
	        HttpServletRequest request) throws IOException {
		Company companyProfile = this.companyservice.dogetCompany(company_id);
		model.addObject("CompanyProfile", companyProfile);	
		User user =userService.doGetLoginInfo();
		long userIdForCompany = user.getId();
		User company = this.userService.doGetApplicantById(userIdForCompany );
		model.addObject("ComapanyProfile", company);
		model.setViewName("companyProfile");
		return model;		
	}

	@RequestMapping(value = "/company/Profile/Update", method = RequestMethod.POST)
	public ModelAndView profileUpdate(@RequestParam("company_id") Integer company_id, HttpServletRequest request) {
		Company companyProfile = this.companyservice.dogetCompany(company_id);
		ModelAndView model = new ModelAndView("CompanyProfile");
		model.addObject("CompanyProfile", companyProfile);
		model.setViewName("companyEditUpdate");

		return model;
	}
	@RequestMapping(value = "/company/Profile/Update", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelCompanyEdit(@ModelAttribute("CompanyProfile") @Valid CompanyDto companydto,
            BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView updateView = new ModelAndView("redirect:/homePageView");
        return updateView;
    }

	/**
	 * <h2>editUpdate</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param company_id
	 * @param request
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/company/Edit-Update", method = RequestMethod.GET)
	public ModelAndView editUpdate(@RequestParam("company_id") Integer company_id, HttpServletRequest request) {

		Company companyProfile = this.companyservice.dogetCompany(company_id);
		ModelAndView model = new ModelAndView("CompanyProfile");
		model.addObject("CompanyProfile", companyProfile);
		model.setViewName("companyEditUpdate");
		return model;
	}

	/**
	 * <h2>UpdateCompanyConfirm</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param companydto
	 * @param result
	 * @param request
	 * @return
	 * @throws ParseException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/company/Confirm/Update", params = "company/Update/Confirm", method = RequestMethod.POST)
	public ModelAndView UpdateCompanyConfirm(HttpServletRequest request, CompanyDto companydto) throws ParseException {
		ModelAndView companyUpdate = new ModelAndView("CompanyProfilecomfirm");
		companyUpdate.addObject("companyUpdate", companydto);
		companyUpdate.setViewName("companyUpdateComfirm");

		return companyUpdate;
	}

	/**
	 * <h2>updateCompany</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param companydto
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/company/Update", params = "updateCompany", method = RequestMethod.POST)
	public ModelAndView updateCompany(@ModelAttribute("CompanyProfile") @Valid CompanyDto companydto,
	        BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		this.companyservice.doupdateCompany(companydto);
		ModelAndView updateView = new ModelAndView("redirect:/homePageView");
		return updateView;
	}
	@RequestMapping(value = "/company/Update", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelCompany(@ModelAttribute("CompanyProfile") @Valid CompanyDto companydto,
            BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView updateView = new ModelAndView("redirect:/homePageView");
        return updateView;
    }

	/**
	 * <h2>companyDelete</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param request
	 * @return
	 * @throws ParseException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/company/Delete", method = RequestMethod.GET)
	public ModelAndView companyDelete(HttpServletRequest request) throws ParseException {

		int company_id = Integer.parseInt(request.getParameter("company_id"));
		this.companyservice.dodeleteCompanyID(company_id);
		ModelAndView deleteView = new ModelAndView("redirect:/company/List");
		return deleteView;
	}
}