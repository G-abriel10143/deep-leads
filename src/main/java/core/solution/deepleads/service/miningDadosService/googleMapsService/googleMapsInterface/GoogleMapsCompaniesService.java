package core.solution.deepleads.service.miningDadosService.googleMapsService.googleMapsInterface;

import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import core.solution.deepleads.response.googleMapsResponse.GeocodingResponse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface GoogleMapsCompaniesService {

    public List<WebElement> scrollPageAndExtractCompany(WebDriver driver);

    public List<LeadsModel> getAllCompaniesByKey(WebDriver driver) throws InterruptedException;


}
