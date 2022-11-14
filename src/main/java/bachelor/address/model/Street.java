package bachelor.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "street")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "street_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID streetId;

    @Column(name = "street_name")
    private String streetName;

    @ManyToMany(mappedBy = "streets")
    private Set<City> cities;

    
}
