package cgmgl.springmvc.app.bl.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cgmgl.springmvc.app.bl.dto.JobTypeDto;
import cgmgl.springmvc.app.bl.service.JobTypeService;
import cgmgl.springmvc.app.persistence.dao.JobTypeDao;
import cgmgl.springmvc.app.persistence.entity.JobType;

/**
 * <h2>JobTypeServiceImp Class</h2>
 * <p>
 * Process for Displaying JobTypeServiceImp
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Transactional
@Service
public class JobTypeServiceImp implements JobTypeService {
    /**
     * <h2>jobTypeDao</h2>
     * <p>
     * jobTypeDao
     * </p>
     */
    @Autowired
    private JobTypeDao jobTypeDao;

    /**
     * <h2>doGetJobTypeList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public List<JobType> doGetJobTypeList() {
        return jobTypeDao.dbGetJobTypeList();
    }

    /**
     * <h2>doGetJobTypeById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeId
     * @return
     */
    @Override
    public JobTypeDto doGetJobTypeById(int jobTypeId) {
        JobType jobType = jobTypeDao.dbGetJobTypeById(jobTypeId);
        JobTypeDto jobTypeDto = jobType != null ? new JobTypeDto(jobType) : null;
        return jobTypeDto;
    }

    /**
     * <h2>doAddJobType</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeDto
     */
    @Override
    public void doAddJobType(JobTypeDto jobTypeDto) {
        Date currentDate = new Date();
        JobType jobType = new JobType(jobTypeDto);
        this.jobTypeDao.dbAddJobType(jobType, currentDate);
    }

    /**
     * <h2>doDeleteJobType</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeId
     */
    @Override
    @Transactional
    public void doDeleteJobType(Integer jobTypeId) {
        Date currentDate = new Date();
        jobTypeDao.dbDeleteJobType(jobTypeId, currentDate);
    }

    /**
     * <h2>doUpdateJobType</h2>
     * <p>
     * 
     * </p>
     * 
     * @param jobTypeDto
     */
    @Override
    public void doUpdateJobType(JobTypeDto jobTypeDto) {
        JobType updateJobType = this.jobTypeDao.dbGetJobTypeById(jobTypeDto.getId());
        updateJobType.setType_name(jobTypeDto.getType_name());
        updateJobType.setDescription(jobTypeDto.getDescription());
        this.jobTypeDao.dbUpdateJobType(updateJobType, new Date());
    }
}