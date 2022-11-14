package bachelor.address.service;

import java.util.List;
import java.util.UUID;

import bachelor.address.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import bachelor.address.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public ResponseEntity<Address> findAddressById(UUID addressId) {
        return null;
    }

    @Override
    public List<Address> findAllAddress() {
        List<Address> allAddress =  addressRepository.findAll();
        return allAddress;
    }

    
    
}
