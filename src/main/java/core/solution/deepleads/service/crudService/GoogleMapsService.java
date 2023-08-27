package core.solution.deepleads.service.crudService;

import com.google.gson.Gson;
import core.solution.deepleads.feign.EnderecoFeign;
import core.solution.deepleads.feign.GoogleFeign;
import core.solution.deepleads.response.googleMapsResponse.GeocodingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleMapsService {
    @Autowired
    private GoogleFeign googleFeign;

    public GeocodingResponse getInfosAdress(String reference) {
        Gson gson = new Gson();

         String jsonResult = googleFeign.getAdressData(reference, GoogleFeign.API_KEY);

        GeocodingResponse googleMapsResponse = gson.fromJson(jsonResult, GeocodingResponse.class);

        return googleMapsResponse;

    }
}
