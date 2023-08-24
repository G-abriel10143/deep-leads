package core.solution.deepleads.service.miningDadosService.googleMapsService;

import core.solution.deepleads.request.UrlRequest;
import org.openqa.selenium.WebDriver;

public class MapsUrlCompanies {


    public String getCompaniesUrl(WebDriver driver, UrlRequest url) {

        String geoloc = "@-23.6552192,-46.7566592,12z";

        String findAllCompanies = url.getUrl() + "/search/" + url.getKeys() + "/" +   geoloc;

        driver.get(findAllCompanies);

        return findAllCompanies;

    }


}
