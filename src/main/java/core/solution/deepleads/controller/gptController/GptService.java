package core.solution.deepleads.controller.gptController;

import cn.gjsm.api.openai.OpenAiClient;
import cn.gjsm.api.openai.OpenAiClientFactory;
import cn.gjsm.api.pojo.chat.ChatCompletionRequest;
import cn.gjsm.api.pojo.chat.ChatCompletionResponse;
import cn.gjsm.api.pojo.chat.ChatMessage;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.solution.deepleads.model.gptModel.GptModel;
import core.solution.deepleads.request.GptRequest;
import core.solution.deepleads.response.GptResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class GptService {

    public GptResponse chatGptIntegration(String message, String apiKey) throws IOException {

        GptResponse gptResponse = new GptResponse();

        String token = apiKey;

        OpenAiClient openAiClient = OpenAiClientFactory.createClient(token);

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole("user");
        chatMessage.setContent(message);

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .messages(Arrays.asList(chatMessage))
                .maxTokens(100)
                .model("gpt-3.5-turbo")
                .build();

        Call<ChatCompletionResponse> chatCompletion = openAiClient.callChatCompletion(request);
        Response<ChatCompletionResponse> response = chatCompletion.execute();

        if (response.isSuccessful())
        {
            String result= JSON.toJSONString(response.body());
            ObjectMapper objectMapper=new ObjectMapper();

            JsonNode jsonNode=objectMapper.readTree(result);

            JsonNode msgJsonNode=jsonNode.at("/choices/0/message");


            LocalDateTime  localDate = LocalDateTime.now();
            gptResponse.setResponse(msgJsonNode.get("content").asText());
            gptResponse.setMessage(message);
            gptResponse.setTimeResponse(localDate);

            return gptResponse;
        }

        return null;
    }

}
