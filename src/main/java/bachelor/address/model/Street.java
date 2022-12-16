package bachelor.address.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "streetId", scope = Street.class)
@Table(name = "street")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "street_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID streetId;

    @Column(name = "street_name")
    private String streetName;

   /*  @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address_fk; */

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "streets", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<City> cities;

    public Street(String streetName) {
        this.streetName = streetName;
    }

    public Street(UUID streetId2, String streetName2) {
    }


}