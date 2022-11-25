package bachelor.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bachelor.address.model.City;
import bachelor.address.service.CityServiceImpl;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityServiceImpl cityServiceImpl;


    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        try {
            List<City> cities = cityServiceImpl.getAllCities();
            
            return new ResponseEntity<>(cities, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        try {
            System.out.println("\n\n KOMMER VI HER");
            System.out.println(city);
            City newCity = cityServiceImpl.createCity(city);

            return new ResponseEntity<>(newCity, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception from create\n\n");
            System.out.println(e);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
