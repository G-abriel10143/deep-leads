package core.solution.deepleads.model.gptModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name ="TB_DL_GPT")
public class GptModel {
    @Id
    @GeneratedValue
    private Long id;

    private String message;

    private String response;

    private LocalDate dateTimeLog;

    private String base64Image;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public LocalDate getDateTimeLog() {
        return dateTimeLog;
    }

    public void setDateTimeLog(LocalDate dateTimeLog) {
        this.dateTimeLog = dateTimeLog;
    }
}
