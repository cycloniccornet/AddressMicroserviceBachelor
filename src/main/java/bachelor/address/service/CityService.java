package bachelor.address.service;

import java.util.List;

import bachelor.address.model.City;

public interface CityService {
    public List<City> saveACities(List<City> cities);
    public City createCity(City city);
}
