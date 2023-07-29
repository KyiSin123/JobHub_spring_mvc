package cgmgl.springmvc.app.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>Authority Class</h2>
 * <p>
 * Process for Displaying Authority
 * </p>
 * 
 * @author Yin Yin Swe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authorities")
public class Authority {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @Column(name = "authority_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * <h2>name</h2>
     * <p>
     * name
     * </p>
     */
    @Column(name = "name")
    private String name;
}