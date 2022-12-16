package bachelor.address.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import bachelor.address.model.Address;
import org.springframework.http.ResponseEntity;

public interface AddressService {
   public Optional<Address> findAddressById(UUID addressId);
   public Address createAddress(Address address);
   public List<Address> findAllAddress();
   public Address findByStreetDesignation(String streetDesignation);
   
}
