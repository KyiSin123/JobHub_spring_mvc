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

import org.hibernate.annotations.DynamicUpdate;

import cgmgl.springmvc.app.bl.dto.CompanyDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Company")
@DynamicUpdate
public class Company {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;

    private String company_name;
    private String email;
    private String phone;
    private String address;
    private String web_link;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<JobPost> jobPost;

    public Company(CompanyDto CompanyDto) {
        this.company_id = CompanyDto.getCompany_id();
        this.company_name = CompanyDto.getCompany_name();
        System.out.println(CompanyDto.getCompany_name());
        System.out.println("company data");
        this.email = CompanyDto.getEmail();
        this.phone = CompanyDto.getPhone();
        this.address = CompanyDto.getAddress();
        this.created_at = CompanyDto.getCreated_at();
        this.updated_at = CompanyDto.getCreated_at();
        this.deleted_at = CompanyDto.getCreated_at();
        this.web_link = CompanyDto.getWeb_link();
        this.jobPost = CompanyDto.getJobPost();
    }
}