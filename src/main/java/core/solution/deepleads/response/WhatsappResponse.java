package core.solution.deepleads.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WhatsappResponse {

    private String result;

    @JsonProperty(value = "message_id")
    private String messageId;

    @JsonProperty(value = "contact_phone_number")
    private String contactNumber;
}
