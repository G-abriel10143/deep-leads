package core.solution.deepleads.service.miningDadosService.linkedinService;

import core.solution.deepleads.request.UrlRequest;
import org.openqa.selenium.WebDriver;

public class LinkedinGetUrl {


    public String getPeopleSection(WebDriver driver, UrlRequest url) {

        String urlPeople = url.getUrl() + "/search/results/people/?keywords=" + url.getKeys() + "&origin=CLUSTER_EXPANSION";

        driver.get(urlPeople);

        return urlPeople;

    }

}
