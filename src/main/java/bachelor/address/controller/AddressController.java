package bachelor.address.controller;

import bachelor.address.model.Address;
import org.springframework.web.bind.annotation.RestController;

import bachelor.address.service.AddressService;
import bachelor.address.service.AddressServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;
    
    @GetMapping("/") 
    public List<Address> getAllAddress() {
        
        return addressService.findAllAddress();
    }

    @GetMapping("/FetchAddressById/{addressUUID}")
    public Optional<Address> fetchById(@PathVariable UUID addressUUID) {
        return addressService.findAddressById(addressUUID);
    }
}
