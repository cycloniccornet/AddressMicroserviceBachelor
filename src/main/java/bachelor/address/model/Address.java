package bachelor.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import javax.persistence.*;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

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

    @Column(name = "street_number")
    private String streetNumber;

    @Nullable
    @Column(name = "floor")
    private String floor;

    @Column(name = "additinal_info")
    private String additinalInfo;

    @Column(name = "street_designation")
    private String streetDesignation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id", referencedColumnName = "street_id")
    private Street street;

}