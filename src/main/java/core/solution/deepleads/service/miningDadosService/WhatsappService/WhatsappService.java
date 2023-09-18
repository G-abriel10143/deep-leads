package core.solution.deepleads.service.miningDadosService.WhatsappService;

import com.google.gson.Gson;
import core.solution.deepleads.dataTransferObject.LeadsDto;
import core.solution.deepleads.dataTransferObject.WhatsappDto;
import core.solution.deepleads.request.WhatsappRequest;
import core.solution.deepleads.response.WhatsappResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WhatsappService {


    private static final String hostWhatsapp = "https://app.whatsgw.com.br/api/WhatsGw";


    public ResponseEntity<WhatsappResponse> consumeWhatsappService(WhatsappDto whatsappDto) {
        RestTemplate restTemplate = new RestTemplate();

        Gson gson = new Gson();
        String requestBody = gson.toJson(whatsappDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<WhatsappResponse> responseEntity = restTemplate.postForEntity(hostWhatsapp.concat("/Send"), requestEntity, WhatsappResponse.class);

        return responseEntity;

    }


    public ArrayList<ResponseEntity<WhatsappResponse>> postMessages(WhatsappRequest whatsappRequest) {

        //TODO: Realizar tratamento dos Leads em questao de Whatsapp
        List<LeadsDto> leadsDtoList = whatsappRequest.getLeads();

        ArrayList<ResponseEntity<WhatsappResponse>> whatsappResponses = new ArrayList<>();



        for (LeadsDto leads : leadsDtoList) {
            WhatsappDto whatsappDto = new WhatsappDto(leads, whatsappRequest);
            String messageFormatted = "Olá! " + leads.getName() + "\n";
            whatsappDto.setMessage_body(messageFormatted.concat(whatsappDto.getMessage_body()));
            ResponseEntity<WhatsappResponse> responseEntity = consumeWhatsappService(whatsappDto);
            whatsappResponses.add(responseEntity);

        }
        return whatsappResponses;

    }
}
