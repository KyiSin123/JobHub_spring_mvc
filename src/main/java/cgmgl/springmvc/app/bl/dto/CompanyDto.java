package cgmgl.springmvc.app.bl.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import cgmgl.springmvc.app.persistence.entity.Authority;
import cgmgl.springmvc.app.persistence.entity.Company;
import cgmgl.springmvc.app.persistence.entity.JobPost;
import cgmgl.springmvc.app.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private User user;

    private Authority authority;

    private List<Authority> authorityList;

    private int company_id;

    @NotEmpty
    private String company_name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String address;

    @NotEmpty
    private String Web_link;
    
    private List<JobPost> jobPost;

    private Date created_at;

    private Date updated_at;

    private Date deleted_at;

    public CompanyDto(Company Company) {
        super();
        this.company_id = Company.getCompany_id();
        this.company_name = Company.getCompany_name();
        this.email = Company.getEmail();
        this.phone = Company.getPhone();
        this.address = Company.getAddress();
        this.created_at = Company.getCreated_at();
        this.updated_at = Company.getCreated_at();
        this.deleted_at = Company.getCreated_at();
        this.Web_link = Company.getWeb_link();
        this.jobPost = Company.getJobPost();
    }

}