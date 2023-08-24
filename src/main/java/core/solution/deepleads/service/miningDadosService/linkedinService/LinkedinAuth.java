package core.solution.deepleads.service.miningDadosService.linkedinService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinAuth {


  //  brenojulio87@gmail.com

    //Br07022003#
    public void loginAuthLinkedin(WebDriver driver)  {

        try {


            //WebElement loginArea = driver.findElement(By.className("main__sign-in-link"));
            WebElement loginArea = driver.findElement(By.xpath("//a[@class='nav__button-secondary btn-md btn-secondary-emphasis']"));

            Thread.sleep(2000);

            loginArea.click();

            WebElement loginForm = driver.findElement(By.id("username"));
            loginForm.sendKeys("brenojulio87@gmail.com"); //jhonatas2004@gmail.com



            WebElement passForm = driver.findElement(By.id("password"));
            passForm.sendKeys("Br07022003#"); //26042004JHON


            WebElement buttonSend = driver.findElement(By.tagName("button"));
            buttonSend.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
