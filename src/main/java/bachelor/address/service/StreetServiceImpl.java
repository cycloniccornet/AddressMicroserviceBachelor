package bachelor.address.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bachelor.address.model.Street;
import bachelor.address.repository.StreetRepository;

@Service
public class StreetServiceImpl implements StreetService {
    
    @Autowired
    StreetRepository streetRepository;

    
    public List<Street> getAllCities() {
        List<Street> streets = new ArrayList<Street>();
        streetRepository.findAll().forEach(streets::add);

        return streets;
    }

    public Street createCity(Street street) {
        Street _street = streetRepository
                .save(street);

        return _street;
    }



}
