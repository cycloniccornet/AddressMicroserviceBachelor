package bachelor.address.repository;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bachelor.address.model.Street;

@Repository
public interface StreetRepository extends JpaRepository<Street, UUID> {
}
