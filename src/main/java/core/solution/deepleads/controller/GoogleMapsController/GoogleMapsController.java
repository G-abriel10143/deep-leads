package core.solution.deepleads.controller.GoogleMapsController;

import core.solution.deepleads.response.googleMapsResponse.GeocodingResponse;
import core.solution.deepleads.service.crudService.GoogleMapsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.openqa.selenium.devtools.v115.network.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/google/maps")
@Tag(name = "api responsavel por integração de serviços google maps", description = "Serviços do Google Maps")
public class GoogleMapsController {

    @Autowired
    private GoogleMapsService googleMapsService;


    @GetMapping("/andress")
    public ResponseEntity<GeocodingResponse> googleMapsGetData(@RequestParam  String param) {

        return ResponseEntity.ok(googleMapsService.getInfosAdress(param));

    }


}
