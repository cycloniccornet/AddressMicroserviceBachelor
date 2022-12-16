package bachelor.address.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bachelor.address.model.City;
import bachelor.address.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<City>();
        cityRepository.findAll().forEach(cities::add);

        return cities;
    }

    

    public ResponseEntity<City> getCityById(UUID cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("No city found with id = " + cityId));

        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    public City createCity(City city) {
        City _city = cityRepository
                .save(city);

        return _city;
    }

    public List<City> saveAllCities(List<City> cities) {
        return cityRepository.saveAll(cities);
    }



    @Override
    public City findCityByCityname(String cityName) {
        
        return cityRepository.findByCityName(cityName);
    }

}
