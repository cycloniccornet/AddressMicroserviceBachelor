package bachelor.address.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bachelor.address.model.City;
import bachelor.address.model.Country;
import bachelor.address.model.DkAddressDTO;
import bachelor.address.model.Street;
import bachelor.address.service.CityService;
import bachelor.address.service.CountryService;
import bachelor.address.service.DataforsyningenApi;

@RestController
@RequestMapping("/populate")
public class populateController {
    
    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;
    @Autowired
    DataforsyningenApi dataforsyningenApi;

    @GetMapping("/addToDbByStreetName")
    public ResponseEntity<Object> populateDB() {
        try {
            DkAddressDTO[] addressList = dataforsyningenApi.fetchCityByStreetFromDataforsyningenApi("Ellemosevej");
            
            List<City> cities = new ArrayList<City>();
            Country newCountry = new Country();
            
            for (int i = 0; i < addressList.length; i++) {

                Boolean countryExist = countryService.findByCountryName(addressList[i].getCountryName()).isPresent();
                if (!countryExist) { 
                    newCountry = new Country(UUID.randomUUID(), addressList[i].getCountryName(), addressList[i].getCountryCode());
                    countryService.createcountry(newCountry); 
                }
                if(countryExist) {newCountry = countryService.findByCountryNameObject(addressList[i].getCountryName());}
                //Country newCountry = new Country(UUID.randomUUID(), addressList[i].getCountryName(), addressList[i].getCountryCode());
                
                
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
            
        return null;
    }

    @GetMapping("/addCityToDbByPostalCode")
    public ResponseEntity<Object> populateDBFromPostalCode() {
        try {
            DkAddressDTO[] dkAddressDTOs = dataforsyningenApi.fetchCityByStreetFromDataforsyningenApi("2900"); //TODO: CHange metod to use int
            
            List<Street> streets = new ArrayList<Street>();
            Country newCountry = new Country();
            
            for (int i = 0; i < dkAddressDTOs.length; i++) {

                Boolean countryExist = countryService.findByCountryName(dkAddressDTOs[i].getCountryName()).isPresent();
                if (!countryExist) { 
                    newCountry = new Country(UUID.randomUUID(), dkAddressDTOs[i].getCountryName(), dkAddressDTOs[i].getCountryCode());
                    countryService.createcountry(newCountry); 
                }
                if(countryExist) {newCountry = countryService.findByCountryNameObject(dkAddressDTOs[i].getCountryName());}
                //Country newCountry = new Country(UUID.randomUUID(), addressList[i].getCountryName(), addressList[i].getCountryCode());
            }
            

            for (int j = 0; j < dkAddressDTOs.length; j++) {
                streets.add( new Street(dkAddressDTOs[j].getStreetName()));
            }
            

            cityService.createCity(new City(newCountry.getCountryId(), newCountry, dkAddressDTOs[0].getCityName(), dkAddressDTOs[0].getPostalCode(), dkAddressDTOs[0].getRegion(), streets));        
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
            
        return null;
    }


}
