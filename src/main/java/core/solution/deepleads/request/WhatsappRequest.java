package core.solution.deepleads.request;

import core.solution.deepleads.dataTransferObject.LeadsDto;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class WhatsappRequest {

    private Date dataInicio;

    private Date dataFim;

    private String message;

    private String messageType;

    private String phoneInitial;

    private String sourceBase64;

    private List<LeadsDto> leads;
}
