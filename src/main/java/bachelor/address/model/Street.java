package bachelor.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

    @OneToMany(mappedBy = "streetId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> address;

   /*  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinTable(name = "city_street", joinColumns = { @JoinColumn(name = "street_id") }, inverseJoinColumns = {
            @JoinColumn(name = "city_id") }, uniqueConstraints = {
                    @UniqueConstraint(columnNames = { "street_id", "city_id" }) })
    private Set<City> cities; */

    

}
