package core.solution.deepleads.controller.googleMapsController;

import core.solution.deepleads.response.googleMapsResponse.GeocodingResponse;
import core.solution.deepleads.service.crudService.GoogleMapsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import core.solution.deepleads.service.crudService.EnderecoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/google/maps")
@Tag(name = "Interação Google Maps GeoLoc", description = "Serviços responsaveis por dados de geolocalização do Google Maps")
public class GoogleMapsController {

    @Autowired
    private GoogleMapsService googleMapsService;

    @GetMapping("/address")
    @Operation(summary = "Cria uma interação com o Google Maps GeoLoc", description = "Interage com a API Google Maps")
    @ApiOperation(value = "Consultar Informações do Endereço pelo Google Maps", notes = "Este endpoint permite consultar informações de um endereço pelo Google Maps.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta bem-sucedida", response = GeocodingResponse.class),
            @ApiResponse(code = 400, message = "Requisição inválida")
    })
    public ResponseEntity<GeocodingResponse> googleMapsGetData(@RequestParam String param) {

        return ResponseEntity.ok(googleMapsService.getInfosAdress(param));

    }

}
