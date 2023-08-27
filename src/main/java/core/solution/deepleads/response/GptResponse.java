package core.solution.deepleads.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GptResponse {

    private String message;

    private String response;

    private LocalDateTime timeResponse;

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

    public LocalDateTime getTimeResponse() {
        return timeResponse;
    }

    public void setTimeResponse(LocalDateTime timeResponse) {
        this.timeResponse = timeResponse;
    }
}
