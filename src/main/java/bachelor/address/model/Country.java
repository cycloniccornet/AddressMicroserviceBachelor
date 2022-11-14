package bachelor.address.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID countryId;
    
    @Column(name = "country_name")
    private String countryName;
    
    @Column(name = "countryCode")
    private int countryCode;
    


}
