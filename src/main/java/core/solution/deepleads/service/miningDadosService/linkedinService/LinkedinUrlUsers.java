package core.solution.deepleads.service.miningDadosService.linkedinService;

import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import core.solution.deepleads.service.miningDadosService.linkedinService.linkedinInterface.LinkedinUsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LinkedinUrlUsers implements LinkedinUsersService {

    private String pageNext = "&page=";


    public List<String> LinkedinUrl(WebDriver driver, String urlSite) {

        List<String> linkUsers = new ArrayList<>();

        List<WebElement> liUsers = new ArrayList<WebElement>();

        for (int i = 1; i <= 1; i++) {

            String numeric = Integer.toString(i);
            System.out.println(numeric);
            driver.get(urlSite + pageNext + numeric);

            liUsers = driver.findElements(By.xpath("//div[@class=\"entity-result__item\"]/div/div/div/div/span/span/a"));

            for (WebElement usuario : liUsers) {

                String usuarioLink = usuario.getAttribute("href");

                if (usuario.getAttribute("href") == "https://www.linkedin.com/search/results/people/headless?origin=CLUSTER_EXPANSION&keywords=ingles%20fluente") {
                    System.out.println("usuario não identificado!");

                } else {
                    linkUsers.add(usuarioLink);

                }


            }
        }


        return linkUsers;

    }

    public List<LeadsModel> linkedinExtractUserData(WebDriver driver, List<String> linkUsers) {

        List<LeadsModel> leadsModelList = new ArrayList<>();
        for (String usuarioProfile : linkUsers) {

            try {

                Thread.sleep(5000);

                driver.get(usuarioProfile);


                String nome = driver.findElement(By.xpath("//div[@class='mt2 relative']/div/div/h1")).getText();

                String localidade = driver.findElement(By.xpath("//span[@class='text-body-small inline t-black--light break-words']")).getText();

                WebElement infoLink = driver.findElement(By.xpath("//*[@id=\"top-card-text-details-contact-info\"]"));

                System.out.println("link perfil: " + usuarioProfile + "\nNome: " + nome + "\nLocalidade: " + localidade);

                infoLink.click();

                Thread.sleep(3000);

                String mail = null ;
                String telefone = null ;

                try {
                     mail = driver.findElement(By.xpath("//section[@class='pv-contact-info__contact-type ci-email']/div/a")).getText();
                    System.out.println( "email: " + mail);

                } catch (Exception e) {
                    System.out.println("==================================================================================================================================================");
                }

                try {

                     telefone = driver.findElement(By.xpath("//section[@class='pv-contact-info__contact-type ci-phone']/ul/li/span[1]")).getText();
                    System.out.printf("Telefone: " + telefone);

                }catch (Exception e) {
                    System.out.println("==================================================================================================================================================");
                }


                if (mail != null || telefone != null ) {

                    LeadsModel leadsModel = new LeadsModel();
                    leadsModel.setName(nome);
                    leadsModel.setPlace(localidade);
                    leadsModel.setMail(mail);
                    leadsModel.setPhone(telefone);
                    leadsModel.setLinkProfile(usuarioProfile);
                    leadsModelList.add(leadsModel);

                    System.out.println("Dado minerado e iniciado processo de persistencia...");


                }


            } catch (Exception e) {

            }
        }
        return leadsModelList;
    }


}
