package cgmgl.springmvc.app.bl.service;

import java.util.List;

import cgmgl.springmvc.app.bl.dto.JobTypeDto;
import cgmgl.springmvc.app.persistence.entity.JobType;

/**
 * <h2>JobTypeService Class</h2>
 * <p>
 * Process for Displaying JobTypeService
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
public interface JobTypeService {
    /**
     * <h2>doGetJobTypeList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<JobType>
     */
    public List<JobType> doGetJobTypeList();

    /**
     * <h2>doGetJobTypeById</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeId
     * @return
     * @return JobTypeDto
     */
    public JobTypeDto doGetJobTypeById(int jobTypeId);

    /**
     * <h2>doAddJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeDto
     * @return void
     */
    public void doAddJobType(JobTypeDto jobTypeDto);

    /**
     * <h2>doDeleteJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeId
     * @return void
     */
    public void doDeleteJobType(Integer jobTypeId);

    /**
     * <h2>doUpdateJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeDto
     * @return void
     */
    public void doUpdateJobType(JobTypeDto jobTypeDto);
}