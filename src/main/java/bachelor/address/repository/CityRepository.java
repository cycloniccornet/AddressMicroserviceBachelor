package bachelor.address.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bachelor.address.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, UUID>{
    
}
