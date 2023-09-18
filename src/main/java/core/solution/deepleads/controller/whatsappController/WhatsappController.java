package core.solution.deepleads.controller.whatsappController;

import core.solution.deepleads.request.WhatsappRequest;
import core.solution.deepleads.response.WhatsappResponse;
import core.solution.deepleads.response.googleMapsResponse.GeocodingResponse;
import core.solution.deepleads.service.miningDadosService.WhatsappService.WhatsappService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/whatsapp")
@Tag(name = "Interacao com a api Whatsapp", description = "Serviços responsaveis por disparos de campanhas via Whatsapp")
public class WhatsappController {

    @Autowired
    private WhatsappService whatsappService;

    @PostMapping("/send/message")
    @Operation(summary = "Cria uma interação com o Whatsapp", description = "Interage com a API whatsapp")
    @ApiOperation(value = "Consultar Informações do Endereço pelo Google Maps", notes = "Este endpoint permite o envio de campanhas via whatsapp")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta bem-sucedida", response = GeocodingResponse.class),
            @ApiResponse(code = 400, message = "Requisição inválida")
    })
    public ResponseEntity<ArrayList<ResponseEntity<WhatsappResponse>> >SendWhatsappMessage(@RequestBody WhatsappRequest whatsappRequest) {
        ArrayList<ResponseEntity<WhatsappResponse>> response = whatsappService.postMessages(whatsappRequest);
        return ResponseEntity.ok(response);

    }


}
