package bachelor.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "street_id", referencedColumnName = "street_id")
    private Street street;

    private String streetNumber;
    private int floor;
    private String additinalInfo;

}