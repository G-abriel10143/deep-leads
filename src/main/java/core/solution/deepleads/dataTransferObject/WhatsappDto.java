package core.solution.deepleads.dataTransferObject;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import core.solution.deepleads.request.WhatsappRequest;
import lombok.Data;

@Data
public class WhatsappDto {

    private String apiKey  = "a4952719-c976-4905-bc56-88521ef4d99e";

    @JsonAlias({ "phone_number", "phone_number" })
    private String phone_number;

    @JsonAlias({ "contact_phone_number", "contact_phone_number" })
    private String contact_phone_number;

    @JsonAlias({ "message_custom_id", "message_custom_id" })
    private String message_custom_id;

    @JsonAlias({ "message_type", "message_type" })
    private String message_type;

    @JsonAlias({ "message_body", "message_body" })
    private String message_body;

    @JsonAlias({ "check_status", "check_status" })
    private String check_status;


    public WhatsappDto(LeadsDto leads, WhatsappRequest whatsappRequest) {
        this.phone_number = whatsappRequest.getPhoneInitial();
        this.contact_phone_number = leads.getPhone();
        this.message_custom_id = "1";
        this.message_type = whatsappRequest.getMessageType();
        this.message_body = whatsappRequest.getMessage();
        this.check_status = "1";
    }
}
