package cgmgl.springmvc.app.persistence.dao;

import java.util.Date;
import java.util.List;

import cgmgl.springmvc.app.persistence.entity.JobType;

/**
 * <h2>JobTypeDao Class</h2>
 * <p>
 * Process for Displaying JobTypeDao
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
public interface JobTypeDao {
    /**
     * <h2>dbGetJobTypeList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<JobType>
     */
    public List<JobType> dbGetJobTypeList();

    /**
     * <h2>dbAddJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobType
     * @param currentDate
     * @return void
     */
    public void dbAddJobType(JobType jobType, Date currentDate);

    /**
     * <h2>dbGetJobTypeById</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeId
     * @return
     * @return JobType
     */
    public JobType dbGetJobTypeById(int jobTypeId);

    /**
     * <h2>dbUpdateJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobType
     * @param currentDate
     * @return void
     */
    public void dbUpdateJobType(JobType jobType, Date currentDate);

    /**
     * <h2>dbDeleteJobType</h2>
     * <p>
     * 
     * </p>
     *
     * @param jobTypeId
     * @param currentDate
     * @return void
     */
    public void dbDeleteJobType(Integer jobTypeId, Date currentDate);
}