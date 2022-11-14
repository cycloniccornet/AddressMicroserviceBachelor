package bachelor.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID cityId;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "postal_code")
    private int postalCode;

    @Column(name = "region")
    private String region;

    @ManyToMany
    @JoinTable(name = "city_street", joinColumns = @JoinColumn(name = "city_id"), inverseJoinColumns = @JoinColumn(name = "street_id"))
    private Set<Street> streets;

}
