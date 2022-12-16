package bachelor.address.service;

import bachelor.address.model.Street;

public interface StreetService {
    public Street findByStreetNameObject(String streetName);
}
