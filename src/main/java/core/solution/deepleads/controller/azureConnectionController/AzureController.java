package core.solution.deepleads.controller.azureConnectionController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AzureController {

    @GetMapping("/status")
    public String appAlive() {
        return "Parabéns, a aplicação está no ar!";
    }
}
