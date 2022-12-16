package bachelor.address.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 @Entity annotation indicates that the class is a persistent Java class.
 @Table annotation provides the table that maps this entity.
 @Id annotation is for the primary key.
 @GeneratedValue annotation is used to define generation strategy for the primary key.
 @Column annotation is used to define the column in database that maps annotated field.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cityId", scope = City.class)
@Table(name = "city")
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "city_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
  private UUID cityId;

  @Nullable
  @OneToOne(cascade = CascadeType.ALL) //Her
  @JoinColumn(name = "country_id", referencedColumnName = "country_id")
  private Country country_fk;

  @Column(name = "city_name")
  private String cityName;

  @Column(name = "postal_code")
  private int postalCode;

  @Column(name = "region")
  private String region;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "city_street", 
             joinColumns = { @JoinColumn(name = "city_id") }, 
             inverseJoinColumns = {@JoinColumn(name = "street_id") }, 
             uniqueConstraints = {@UniqueConstraint(columnNames = { "street_id", "city_id" }) }
  )
  private List<Street> streets;



  
  

}