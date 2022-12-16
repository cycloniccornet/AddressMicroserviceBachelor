package bachelor.address.service;

import java.util.List;
import java.util.Optional;
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
    public Optional<Address> findAddressById(UUID addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public List<Address> findAllAddress() {
        List<Address> allAddress =  addressRepository.findAll();
        return allAddress;
    }

    public Address findByStreetDesignation(String streetDesignation) {
        return addressRepository.findByStreetDesignation(streetDesignation);
    }

    @Override
    public Address createAddress(Address address) {
        Address _address = addressRepository
                .save(address);

        return _address;
    }

    

    
    
}
