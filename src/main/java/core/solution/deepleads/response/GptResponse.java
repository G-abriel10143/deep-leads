package core.solution.deepleads.response;

import java.time.LocalDate;

public class GptResponse {

    private String message;

    private String response;

    private LocalDate timeResponse;

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

    public LocalDate getTimeResponse() {
        return timeResponse;
    }

    public void setTimeResponse(LocalDate timeResponse) {
        this.timeResponse = timeResponse;
    }
}
