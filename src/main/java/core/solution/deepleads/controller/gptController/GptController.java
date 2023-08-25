package core.solution.deepleads.controller.gptController;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.image.CreateImageRequest;
import core.solution.deepleads.request.GptRequest;
import core.solution.deepleads.response.GptResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/api/generativeIa")
@Tag(name = "api de IA generativa", description = "Serviços responsaveis pela geração de campanhas inteligentes")
public class GptController {

    private static final String API_KEY = "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";

    OpenAiService openAiService = new OpenAiService(API_KEY);

    @Operation(summary = "Cria uma interação com o Chat GPT", description = "Interage com a API do chat GPT")
    @ApiResponse(responseCode = "200", description = "IA gerada com sucesso!!", content = @Content(schema = @Schema(implementation = GptResponse.class)))
    @ApiResponse(responseCode = "404", description = "Erro ao gerar mensagem")
    @GetMapping("/generate/ia/message")
    public CompletionRequest generateIAMessage(@RequestBody GptRequest gptRequest) {
//        GptResponse gptResponse = new GptResponse();
//        CompletionRequest request = CompletionRequest.builder()
//                .model("text-davinci-003").prompt(gptRequest.getMessage()).maxTokens(100)
//                .build();
//
//        System.out.println(request);

        String token = System.getenv("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");
        OpenAiService service = new OpenAiService(token, Duration.ofSeconds(30));

        System.out.println("\nCreating completion...");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Somebody once told me the world is gonna roll me")
                .echo(true)
                .user("testing")
                .n(3)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);

        System.out.println("\nCreating Image...");
        CreateImageRequest request = CreateImageRequest.builder()
                .prompt("A cow breakdancing with a turtle")
                .build();
        return null;

    }




}
