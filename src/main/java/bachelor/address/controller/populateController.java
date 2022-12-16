package bachelor.address.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bachelor.address.model.Address;
import bachelor.address.model.City;
import bachelor.address.model.Country;
import bachelor.address.model.DkAddressDTO;
import bachelor.address.model.Street;
import bachelor.address.service.AddressService;
import bachelor.address.service.CityService;
import bachelor.address.service.CountryService;
import bachelor.address.service.DataforsyningenApi;
import bachelor.address.service.StreetService;

@RestController
@RequestMapping("/populate")
public class populateController {

    @Autowired
    AddressService addressService;
    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;
    @Autowired
    StreetService streetService;
    @Autowired
    DataforsyningenApi dataforsyningenApi;

    public List<Street> createCityList(List<DkAddressDTO> dkAddressDTOs) {
        List<Street> streets = new ArrayList<Street>();
       
        int streetsIteratedCounter = 0; 

        for (DkAddressDTO currentAddressDTO : dkAddressDTOs) {
            
            Street currentStreet = streetService.findByStreetNameObject(currentAddressDTO.getStreetName());
            boolean found = streets.stream().anyMatch(currentStreetList -> currentStreetList.getStreetName().equals(currentAddressDTO.getStreetName()));
            
            if (currentStreet == null && !found) {
                streets.add(new Street(currentAddressDTO.getStreetName()));
            } else {
                //System.out.println("Street Already Exist");
            }
            System.out.println("Streets Iterated: " + streetsIteratedCounter + "/" + dkAddressDTOs.size());
            streetsIteratedCounter++;
        }
        
        
        return streets;
    }

    @GetMapping("/test")
    public Address test() {
        try {
            
           return addressService.findByStreetDesignation("Vinagervej 7, 2800 Kongens Lyngby");
        } catch (Exception e) {
            System.out.println(e);
        }
       // System.out.println(streetService.findByStreetNameObject("Rødstensvej"));
        return null;
    }

    @PostMapping("/addCityToDbByPostalCode")
    public ResponseEntity<Object> populateDBFromPostalCode() {
        try {
            List<DkAddressDTO> dkAddressDTOs = dataforsyningenApi.fetchCityByStreetFromDataforsyningenApi("9560 ");
            System.out.println(dkAddressDTOs.size());
           
            Country newCountry = new Country();
            Address address = new Address();
            Street street = new Street();
            int tempCounter = 0;
            for (DkAddressDTO currentDTO : dkAddressDTOs) {
                System.out.println("General counter Iterated: " + tempCounter + "/" + dkAddressDTOs.size());
                tempCounter ++;

                Country currentCountry = countryService.findByCountryNameObject(currentDTO.getCountryName());
                Address currentAddress = addressService.findByStreetDesignation(currentDTO.getStreetDesignation());
                Street currenStreet = streetService.findByStreetNameObject(currentDTO.getStreetName());
                City city = cityService.findCityByCityname(currentDTO.getCityName()); 
                
                if (currentCountry == null) {
                    System.out.println("adding Country");
                    newCountry = countryService.createcountry(new Country(UUID.randomUUID(), currentDTO.getCountryName(), currentDTO.getCountryCode()));
                }
                
                
                if (city == null) {
                    System.out.println("adding City");
                    cityService.createCity(new City(newCountry.getCountryId(), newCountry, currentDTO.getCityName(), currentDTO.getPostalCode(), currentDTO.getRegion(), createCityList(dkAddressDTOs)));
                }
                
                if (currentAddress == null) {
                    System.out.println("adding Address");
                    address = addressService.createAddress(new Address(UUID.fromString(currentDTO.getId()), currentDTO.getStreetNumber(), currentDTO.getFloor(), currentDTO.getHouseNr(), currentDTO.getStreetDesignation(), currenStreet));
                }

            }

            System.out.println("finished");

            return null;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return null;
    }
}
