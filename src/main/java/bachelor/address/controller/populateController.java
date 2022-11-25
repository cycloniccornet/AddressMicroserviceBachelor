package bachelor.address.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bachelor.address.model.City;
import bachelor.address.model.Country;
import bachelor.address.model.DkAddressDTO;
import bachelor.address.model.Street;
import bachelor.address.service.CityServiceImpl;
import bachelor.address.service.CountryService;
import bachelor.address.service.CountryServiceImpl;
import bachelor.address.service.DataforsyningenApi;

@RestController
@RequestMapping("/populate")
public class populateController {
    
    @Autowired
    CityServiceImpl cityServiceImpl;
    @Autowired
    CountryService countryService;
    @Autowired
    DataforsyningenApi dataforsyningenApi;

    @GetMapping("/addToDbByStreetName")
    public ResponseEntity<Object> populateDB() {
        try {
            DkAddressDTO[] addressList = dataforsyningenApi.fetchCityByStreetFromDataforsyningenApi("Ellemosevej");
            
            Set<City> cities = new HashSet<City>();
            
            Country newCountry = new Country();
            
            for (int i = 0; i < addressList.length; i++) {

                Boolean countryExist = countryService.findByCountryName(addressList[i].getCountryName()).isPresent();
                if (!countryExist) { 
                    newCountry = new Country(UUID.randomUUID(), addressList[i].getCountryName(), addressList[i].getCountryCode());
                    countryService.createcountry(newCountry); 
                }
                if(countryExist) {newCountry = countryService.findBCountryName(addressList[i].getCountryName());}
                //Country newCountry = new Country(UUID.randomUUID(), addressList[i].getCountryName(), addressList[i].getCountryCode());
                
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
            
        return null;
    }

}
