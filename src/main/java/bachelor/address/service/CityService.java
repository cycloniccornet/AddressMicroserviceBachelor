package bachelor.address.service;

import java.util.List;

import bachelor.address.model.City;

public interface CityService {
    public List<City> saveAllCities(List<City> cities);
    public City createCity(City city);
    public City findCityByCityname(String cityName);
}
