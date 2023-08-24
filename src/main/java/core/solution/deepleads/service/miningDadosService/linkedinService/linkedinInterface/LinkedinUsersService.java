package core.solution.deepleads.service.miningDadosService.linkedinService.linkedinInterface;

import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import org.openqa.selenium.WebDriver;

import java.util.List;

public interface LinkedinUsersService {

    public List<String> LinkedinUrl(WebDriver driver, String urlSite);

    public List<LeadsModel> linkedinExtractUserData(WebDriver driver, List<String> linkUsers );


}
