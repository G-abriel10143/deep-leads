package core.solution.deepleads.controller.crudController;


import core.solution.deepleads.service.crudService.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "API Controller", description = "Controlador para operações da API")
public class EnderecoController {

    @Autowired
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/consultaCEP/{cep}")
    @ApiOperation(value = "Consultar CEP", notes = "Este endpoint permite consultar informações de um CEP.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta bem-sucedida"),
            @ApiResponse(code = 400, message = "Requisição inválida")
    })
    public ResponseEntity consultaCep(@PathVariable String enderecoRequest) {
        try {

            return ResponseEntity.ok(enderecoService.executa(enderecoRequest));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
