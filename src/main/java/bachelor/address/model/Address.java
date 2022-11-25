package bachelor.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID addressId;

    // @OneToOne(cascade = CascadeType.DETACH)
    // @JoinColumn(name = "street_id", referencedColumnName = "street_id")
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_city", referencedColumnName = "city_id")
    @JsonIdentityReference(alwaysAsId = true)
    private City cityId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_street", referencedColumnName = "street_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Street streetId;


    private String streetNumber;
    private int floor;
    private String additinalInfo;

}