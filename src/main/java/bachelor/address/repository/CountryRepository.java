package bachelor.address.repository;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bachelor.address.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, UUID>{
    
        
}

