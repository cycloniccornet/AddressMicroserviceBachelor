package bachelor.address.controller;

import bachelor.address.model.Address;
import org.springframework.web.bind.annotation.RestController;

import bachelor.address.service.AddressServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressServiceImpl addressServiceImpl;
    
    @GetMapping("/") 
    public List<Address> getAllAddress() {
        return addressServiceImpl.findAllAddress();
    }

    /* @PostMapping("/populateApi")
    public */
}
