package cgmgl.springmvc.app.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cgmgl.springmvc.app.bl.dto.JobTypeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>JobType Class</h2>
 * <p>
 * Process for Displaying JobType
 * </p>
 * 
 * @author Htet Su Moe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_type")
public class JobType {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * <h2>type_name</h2>
     * <p>
     * type_name
     * </p>
     */
    @Column(name = "type_name")
    private String type_name;

    /**
     * <h2>description</h2>
     * <p>
     * description
     * </p>
     */
    @Column(name = "description")
    private String description;

    /**
     * <h2>jobPost</h2>
     * <p>
     * jobPost
     * </p>
     */
    @OneToMany(mappedBy = "jobType", cascade = CascadeType.ALL)
    private List<JobPost> jobPost;

    /**
     * <h2>createAt</h2>
     * <p>
     * createAt
     * </p>
     */
    @Column(name = "created_at")
    private Date createAt;

    /**
     * <h2>deleteAt</h2>
     * <p>
     * deleteAt
     * </p>
     */
    @Column(name = "deletet_at")
    private Date deleteAt;
    /**
     * <h2>updateAt</h2>
     * <p>
     * updateAt
     * </p>
     */
    @Column(name = "update_at")
    private Date updateAt;

    /**
     * <h2>Constructor for JobType</h2>
     * <p>
     * Constructor for JobType
     * </p>
     * 
     * @param jobTypeForm
     */
    public JobType(JobTypeDto jobTypeDto) {
        this.id = jobTypeDto.getId();
        this.type_name = jobTypeDto.getType_name();
        this.description = jobTypeDto.getDescription();
        this.createAt = jobTypeDto.getCreateAt();
        this.deleteAt = jobTypeDto.getDeleteAt();
        this.jobPost = jobTypeDto.getJobPost();
        this.updateAt = jobTypeDto.getUpdateAt();
    }
}