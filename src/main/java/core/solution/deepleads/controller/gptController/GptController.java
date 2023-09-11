package core.solution.deepleads.controller.gptController;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.image.CreateImageRequest;
import core.solution.deepleads.model.gptModel.GptModel;
import core.solution.deepleads.model.miningDadosModel.UrlModel;
import core.solution.deepleads.repository.miningDadosRepository.UrlModelRepository;
import core.solution.deepleads.request.GptRequest;
import core.solution.deepleads.request.UrlRequest;
import core.solution.deepleads.response.GptResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Url;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/generative/ia")
@Tag(name = "Interação generativa GPT 3.5", description = "Serviços responsaveis pela geração de campanhas inteligentes")
public class GptController {
    @Autowired
    private GptService gptService;
    @Autowired
    private UrlModelRepository urlModelRepository;


    @Operation(summary = "Cria uma interação com o Chat GPT", description = "Interage com a API do chat GPT")
    @ApiResponse(responseCode = "200", description = "IA gerada com sucesso!!", content = @Content(schema = @Schema(implementation = GptRequest.class)))
    @ApiResponse(responseCode = "404", description = "Erro ao gerar mensagem")
    @GetMapping("/generate/ia/message")
    public GptResponse generateIAMessage(@RequestParam String message,@RequestParam String apiKey ) throws IOException {
        GptResponse gptResponse = new GptResponse();

        gptResponse = gptService.chatGptIntegration(message, apiKey);

        return gptResponse;

    }
    @Operation(summary = "Salva as campanhas geradas pelos usuarios", description = "Requisição POST cadastrando campanhas geradas.")
    @ApiResponse(responseCode = "200", description = "IA gerada com sucesso!!", content = @Content(schema = @Schema(implementation = GptRequest.class)))
    @ApiResponse(responseCode = "404", description = "Erro ao gerar mensagem")
    @PostMapping("/post/campaigns/by-url-id")
    public ResponseEntity<UrlModel> postCampaignByUrlModel(@RequestBody List<GptModel> urlRequest, @RequestParam Long id) {

        UrlModel urlModel = urlModelRepository.findById(id).orElse(null);

        if (urlModel != null) {
            List<GptModel> gptModels = new ArrayList<>(urlModel.getGptModels());
            gptModels.addAll(urlRequest);

            urlModel.setGptModels(gptModels);

            urlModelRepository.save(urlModel);
            return ResponseEntity.ok(urlModel);
        }
        if (urlModel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }

}


