package bachelor.address.service;

import java.util.List;
import java.util.UUID;

import bachelor.address.model.Address;
import org.springframework.http.ResponseEntity;

public interface AddressService {
   public ResponseEntity<Address> findAddressById(UUID addressId);
   public List<Address> findAllAddress();
}
