package core.solution.deepleads.service.miningDadosService;


import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import core.solution.deepleads.request.UrlRequest;
import core.solution.deepleads.service.miningDadosService.googleMapsService.GetCompanies;
import core.solution.deepleads.service.miningDadosService.googleMapsService.MapsUrlCompanies;
import core.solution.deepleads.service.miningDadosService.googleMapsService.googleMapsInterface.GoogleMapsCompaniesService;
import core.solution.deepleads.service.miningDadosService.linkedinService.LinkedinAuth;
import core.solution.deepleads.service.miningDadosService.linkedinService.LinkedinGetUrl;
import core.solution.deepleads.service.miningDadosService.linkedinService.linkedinInterface.LinkedinUsersService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class MiningService<T> {

    private static final String chromeBinaryPath = "C:\\chrome-win64\\chrome.exe";

    private static final String chromeBinaryPath1 = "src/drive/chrome-win64/chrome.exe";


    public static final String FACEBOOK = "FACEBOOK";

    public static final String LINKEDIN = "FACEBOOK";

    public static final String MAPSGOOGLE = "FACEBOOK";

    public static final String INSTAGRAM = "FACEBOOK";


    @Autowired
    LinkedinUsersService linkedinUsersService;



    private  String pageNext = "&page=";





    public static  WebDriver getDriverChrome() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();


        WebDriver driver = new ChromeDriver(options);

        return driver;

    }

    @PostMapping
    public List<LeadsModel> extractWebData(UrlRequest url) throws InterruptedException {

        List<LeadsModel> leadsModel = new ArrayList<>();

        String urlSite = url.getUrl();

        WebDriver driver = getDriverChrome();

        driver.get(urlSite);

        switch (url.getTypeSearch()) {


            case FACEBOOK:


            case LINKEDIN:

                LinkedinAuth linkedinAuth = new LinkedinAuth();
                LinkedinGetUrl linkedinGetUrl = new LinkedinGetUrl();

                linkedinAuth.loginAuthLinkedin(driver);

                List<String> linkUsers = new ArrayList<>();

                String urlPeople = linkedinGetUrl.getPeopleSection(driver, url);

                linkUsers = linkedinUsersService.LinkedinUrl(driver, urlPeople);

                leadsModel = linkedinUsersService.linkedinExtractUserData(driver, linkUsers);


            case MAPSGOOGLE:

                driver.manage().window().maximize();

                MapsUrlCompanies mapsUrlCompanies = new MapsUrlCompanies();

                GoogleMapsCompaniesService getCompanies = new GetCompanies();

                mapsUrlCompanies.getCompaniesUrl(driver, url);

                leadsModel = getCompanies.getAllCompaniesByKey (driver);


            case INSTAGRAM: // Minerar dados com base nos seguidores de usuario


                break;
            default:
                throw new IllegalStateException("Unexpected value: " + url.getTypeSearch());
        }


        return leadsModel;
    }


}
