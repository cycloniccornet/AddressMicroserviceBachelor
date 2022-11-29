package bachelor.address.service;

import java.util.List;
import java.util.Optional;

import bachelor.address.model.Country;

public interface CountryService {
    public List<Country> getAllCountries();
    public Country createcountry(Country country);
    public Country findByCountryNameObject(String countryName);
    public Optional<Country> findByCountryName(String countryName);
}