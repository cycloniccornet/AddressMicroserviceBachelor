package bachelor.address.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bachelor.address.model.Country;
import bachelor.address.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        List<Country> counties = new ArrayList<Country>();
        countryRepository.findAll().forEach(counties::add);

        return counties;
    }

    public Country createcountry(Country country) {
        Country _country = countryRepository
                .save(country);

        return _country;
    }

    @Override
    public Country findByCountryNameObject(String countryName) {
        
        return countryRepository.findByCountryName(countryName);
    }

    @Override
    public Optional<Country> findByCountryName(String countryName) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }
    

}
