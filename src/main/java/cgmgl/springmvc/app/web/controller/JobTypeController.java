package cgmgl.springmvc.app.web.controller;

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

import cgmgl.springmvc.app.bl.dto.JobTypeDto;
import cgmgl.springmvc.app.bl.service.JobTypeService;
import cgmgl.springmvc.app.persistence.entity.JobType;

/**
 * <h2>JobTypeController Class</h2>
 * <p>
 * Process for Displaying JobTypeController
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Controller
public class JobTypeController {
    /**
     * <h2>jobTypeService</h2>
     * <p>
     * jobTypeService
     * </p>
     */
    @Autowired
    private JobTypeService jobTypeService;
    /**
     * <h2>messageSource</h2>
     * <p>
     * messageSource
     * </p>
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * <h2>getJobTypeList</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/list")
    public ModelAndView getJobTypeList(ModelAndView model) {
        List<JobType> jobTypeList = jobTypeService.doGetJobTypeList();
        model.addObject("JobTypeList", jobTypeList);
        model.setViewName("jobTypeList");
        return model;
    }

    /**
     * <h2>newJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/create", method = RequestMethod.GET)
    public ModelAndView newJobType(ModelAndView model, BindingResult result, HttpServletRequest request) {
        JobTypeDto jobTypeDto = new JobTypeDto();
        ModelAndView createJobType = new ModelAndView("createJobType");
        createJobType.addObject("rollBackJobTypeDto", jobTypeDto);
        createJobType.setViewName("createJobType");
        return createJobType;
    }

    /**
     * <h2>confirmJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeDto
     * @param result
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/create/confirm", params = "confirmJobType", method = RequestMethod.POST)
    public ModelAndView confirmJobType(@ModelAttribute("rollBackJobTypeDto") @Valid JobTypeDto jobTypeDto,
            BindingResult result, HttpServletRequest request) {
        ModelAndView JobTypeConfirmView = new ModelAndView("createJobTypeConfirm");

        if (result.hasErrors()) {
            ModelAndView errorConfirmView = new ModelAndView("createJobType");
            errorConfirmView.addObject("jobTypeDto", jobTypeDto);
            errorConfirmView.addObject("errorMsg", messageSource.getMessage("M_SC_0007", null, null));
            return errorConfirmView;
        }

        JobTypeConfirmView.addObject("jobTypeDto", jobTypeDto);
        JobTypeConfirmView.setViewName("confirmJobType");
        return JobTypeConfirmView;
    }

    /**
     * <h2>insertJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeDto
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/insert", params = "addJobType", method = RequestMethod.POST)
    public ModelAndView insertJobType(@Valid JobTypeDto jobTypeDto) {
        this.jobTypeService.doAddJobType(jobTypeDto);
        ModelAndView createJobTypeView = new ModelAndView("redirect:/jobType/list");
        return createJobTypeView;
    }

    /**
     * <h2>cancelJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeDto
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/insert", params = "cancel", method = RequestMethod.POST)
    public ModelAndView cancelJobType(@ModelAttribute("jobPostDto") @Valid JobTypeDto jobTypeDto) {
        ModelAndView JobTypeView = new ModelAndView("createJobType");
        JobTypeView.addObject("rollBackJobTypeDto", jobTypeDto);
        return JobTypeView;
    }

    /**
     * <h2>editJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeId
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/edit", method = RequestMethod.GET)
    public ModelAndView editJobType(@RequestParam("id") Integer jobTypeId) {
        JobTypeDto jobTypeDto = jobTypeService.doGetJobTypeById(jobTypeId);
        ModelAndView editJobTypeView = new ModelAndView("updateJobType");
        editJobTypeView.addObject("editJobTypeDto", jobTypeDto);
        editJobTypeView.setViewName("updateJobType");
        return editJobTypeView;
    }

    /**
     * <h2>confirmEditedJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeDto
     * @param result
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/edited/confirm", method = RequestMethod.POST)
    public ModelAndView confirmEditedJobType(@Valid JobTypeDto jobTypeDto, BindingResult result) {
        ModelAndView editedConfirmView = new ModelAndView("updateJobTypeConfirm");
        editedConfirmView.addObject("confirmEditedJobTypeDto", jobTypeDto);
        editedConfirmView.setViewName("confirmEditedJobType");
        return editedConfirmView;
    }

    /**
     * <h2>updateJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeDto
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/update", params = "saveUpdateJobType", method = RequestMethod.POST)
    public ModelAndView updateJobType(@Valid JobTypeDto jobTypeDto) {
        this.jobTypeService.doUpdateJobType(jobTypeDto);
        ModelAndView updateJobTypeView = new ModelAndView("redirect:/jobType/list");
        return updateJobTypeView;
    }

    /**
     * <h2>cancelUpdateJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/update", params = "cancelUpdate", method = RequestMethod.POST)
    public ModelAndView cancelUpdateJobType(@Valid JobTypeDto jobTypeDto) {
        ModelAndView updateJobTypeView = new ModelAndView("redirect:/jobType/list");
        return updateJobTypeView;
    }

    /**
     * <h2>deleteJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/jobType/delete", method = RequestMethod.GET)
    public ModelAndView deleteJobType(HttpServletRequest request) {
        int jobTypeId = Integer.parseInt(request.getParameter("id"));
        jobTypeService.doDeleteJobType(jobTypeId);
        return new ModelAndView("redirect:/jobType/list");
    }
}