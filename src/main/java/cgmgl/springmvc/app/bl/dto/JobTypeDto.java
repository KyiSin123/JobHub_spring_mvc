package cgmgl.springmvc.app.bl.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.JobPost;
import cgmgl.springmvc.app.persistence.entity.JobType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>JobTypeDto Class</h2>
 * <p>
 * Process for Displaying JobTypeDto
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobTypeDto {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    private int id;
    /**
     * <h2>type_name</h2>
     * <p>
     * type_name
     * </p>
     */
    @NotEmpty
    private String type_name;
    /**
     * <h2>description</h2>
     * <p>
     * description
     * </p>
     */
    private String description;
    /**
     * <h2>jobPost</h2>
     * <p>
     * jobPost
     * </p>
     */
    private List<JobPost> jobPost;
    /**
     * <h2>createAt</h2>
     * <p>
     * createAt
     * </p>
     */
    private Date createAt;
    /**
     * <h2>deleteAt</h2>
     * <p>
     * deleteAt
     * </p>
     */
    private Date deleteAt;
    /**
     * <h2>updateAt</h2>
     * <p>
     * updateAt
     * </p>
     */
    private Date updateAt;

    /**
     * <h2>Constructor for JobTypeForm</h2>
     * <p>
     * Constructor for JobTypeForm
     * </p>
     * 
     * @param jobType
     */
    public JobTypeDto(JobType jobType) {
        this.id = jobType.getId();
        this.type_name = jobType.getType_name();
        this.description = jobType.getDescription();
        this.jobPost = jobType.getJobPost();
        this.createAt = jobType.getCreateAt();
        this.deleteAt = jobType.getDeleteAt();
        this.updateAt = jobType.getUpdateAt();
    }
}