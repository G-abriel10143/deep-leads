package core.solution.deepleads.service.miningDadosService.googleMapsService;


import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import core.solution.deepleads.repository.miningDadosRepository.GenericEntityRepository;
import core.solution.deepleads.service.miningDadosService.googleMapsService.googleMapsInterface.GoogleMapsCompaniesService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GetCompanies implements GoogleMapsCompaniesService {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    private String telefone;

    private String estrelas;

    private String endereco;

    private String avaliacoes;

    private String nome;

    private String pluscode;

    private  String categoria;

    private String urlCompany;

    @Override
    public String toString() {
        return "Nome empresa: " + nome
                + "\nNº Avaliações: "+ avaliacoes
                + "\nEstrelas: " + estrelas
                + "\nendereco: " + endereco
                + "\nTelefone: " + telefone
                + "\nPlusCode: " + pluscode
                + "\nLink empresa: " + urlCompany
                + "\n==============================================================================================================================================";
    }

    public List<WebElement> scrollPageAndExtractCompany(WebDriver driver) {

        try {
            int i =0;
            List<WebElement> finalList = new ArrayList<>();
            List<WebElement> cardsEmpresa = driver.findElements(By.xpath("//a[@class='hfpxzc']"));
            while (finalList.isEmpty()) {

                i++;
                for (WebElement rolagem : cardsEmpresa) {
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript("arguments[0].scrollIntoView(true)", rolagem);
                    cardsEmpresa = driver.findElements(By.xpath("//a[@class='hfpxzc']"));
                    finalList = driver.findElements(By.xpath("//span[@class='HlvSq']"));
                    if (cardsEmpresa.size() == i) {
                        Thread.sleep(4000);
                    }

                    if (!finalList.isEmpty()) {
                        System.out.println("========================================================================= ");
                        System.out.println("VOCE CHEGOU AO FIM DA MINERACAOD ESTA PAGINA! \nNR DE EMPRESAS: " + cardsEmpresa.size() );
                        System.out.println("==========================================================================");
                        return cardsEmpresa;
                    }
                }
            }
            return cardsEmpresa;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<LeadsModel> getAllCompaniesByKey(WebDriver driver) throws InterruptedException {

        List<LeadsModel> leadsModelList = new ArrayList<>();

        List<WebElement> scrolls = scrollPageAndExtractCompany(driver);


        for (WebElement cardEmpresa : scrolls) {

            Actions actions = new Actions(driver);

            actions.moveToElement(cardEmpresa).click().perform();


                Thread.sleep(3000);

                List<WebElement> nomeElement  =driver.findElements(By.xpath("//div[@class='lMbq3e']/div/h1"));
                nome = (!nomeElement.isEmpty()) ? nomeElement.get(0).getText() : null;

                List<WebElement> avaliacoesElement = driver.findElements(By.xpath("//div[@class='F7nice ']/span[2]/span/span"));
                avaliacoes = (!avaliacoesElement.isEmpty()) ? avaliacoesElement.get(0).getText().replaceAll("\\D", "") : null;


                List<WebElement> estrelasElement = driver.findElements(By.xpath("//span[@class='ceNzKf']"));
                estrelas = (!estrelasElement.isEmpty()) ? estrelasElement.get(0).getAttribute("aria-label") : null;

                List<WebElement> enderecoElement =  driver.findElements(By.xpath("//button[@data-item-id='address']/div[1]/div[2]/div"));
                endereco = (!enderecoElement.isEmpty()) ? enderecoElement.get(0).getText() : null;

                List<WebElement> pluscodeElement =  driver.findElements(By.xpath("//button[@data-tooltip='Copiar Plus Code']"));
                pluscode = (!pluscodeElement.isEmpty()) ? pluscodeElement.get(0).getText() : null;

                List<WebElement> telefoneElement =  driver.findElements(By.xpath("//button[contains(@aria-label, 'Telefone')]"));
                telefone = (!telefoneElement.isEmpty()) ? telefoneElement.get(0).getAttribute("aria-label").replaceAll("\\D", "") : null;

                List<WebElement> categoriaElement =  driver.findElements(By.xpath("//button[@jsaction='pane.rating.category']"));
                categoria = (!categoriaElement.isEmpty()) ? categoriaElement.get(0).getText() : null;

                urlCompany =  driver.getCurrentUrl();

                System.out.println(toString());
//                System.out.println("Nome empresa: " + nome + "\nNº Avaliações: " + avaliacoes + "\nEstrelas: " + estrelas + "\nendereco: " + endereco + "\nTelefone: " + telefone + "\nPlusCode: " + pluscode + "\nLink empresa: " + urlCompany);
//                System.out.println("==============================================================================================================================================");


            if (telefone != null || nome != null || endereco != null) {
                LeadsModel leadsModel = new LeadsModel();
                leadsModel.setCategory(categoria);
                leadsModel.setPhone(telefone);
                leadsModel.setName(nome);
                leadsModel.setPlace(endereco);
                leadsModel.setStars(estrelas);
                leadsModel.setPlusCode(pluscode);
//                genericEntity.setLinkProfile(urlCompany);
                leadsModel.setRating(avaliacoes);
                leadsModelList.add(leadsModel);
            }

        }
        driver.quit();
        return leadsModelList;
    }

    //TODO: Analisar necessidade de filtragem das empresas, verificar a relevancia de excluir informacoes
    public List<LeadsModel> filterCompanies(List<LeadsModel> companiesList) {
        for (LeadsModel companie : companiesList) {
        }
        return null;
    }



}
