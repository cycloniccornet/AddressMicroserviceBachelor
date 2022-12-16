package bachelor.address.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import bachelor.address.model.Country;
import bachelor.address.model.DkAddressDTO;

@Service
public class DataforsyningenApi {

    // https://api.dataforsyningen.dk/adresser?q=Søndre Fasanvej

    ArrayList<Object> listdata = new ArrayList<Object>();

    // Checking whether the JSON array has some value or not

    public List<DkAddressDTO> fetchCityByStreetFromDataforsyningenApi(String postalCode) throws ScriptException {
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            String jsonArray = restTemplate.getForObject("http://localhost:8006/dk/address/" + postalCode, String.class); //TODO: Change Hardcoded URL to Eurika lookup
            //System.out.println("Data: " + jsonArray + "\n\n\n");
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonArray, new TypeReference<List<DkAddressDTO>>(){});
            //System.out.println(dkAddressDTOs[0].getCityName());

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public DkAddressDTO[] createCityFromPostalCode(int postalCode) throws ScriptException {
        DkAddressDTO[] dkAddressDTOs;
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            String jsonArray = restTemplate.getForObject("http://localhost:8006/dk/address/" + postalCode, String.class); //TODO: Change Hardcoded URL to Eurika lookup
            //String jsonArray = restTemplate.getForObject("http://localhost:8006/dk/address/test", String.class); //TODO: Change Hardcoded URL to Eurika lookup

            final ObjectMapper objectMapper = new ObjectMapper();
            dkAddressDTOs = objectMapper.readValue(jsonArray, DkAddressDTO[].class);

            return dkAddressDTOs;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public static void main(String[] args) {


      
    }
}
