package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EFortunaSimulareBilet {

    WebDriver webDriver;

    @Test
    public void testMethod() {

        webDriver = new FirefoxDriver();

        webDriver.get("https://efortuna.ro/");

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        webDriver.manage().window().maximize();

        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-consent-button-accept")));

        consentButton.click();
        js.executeScript("window.scrollBy(0,450)", "");


        List<WebElement> topCoteFilds = webDriver.findElements(By.cssSelector("a[class = 'odds-button top-odds']"));
        Integer index = 0;
        while (index != 3) {
            topCoteFilds.get(index).click();
            index++;
        }

        List<WebElement> numeMeciLista = webDriver.findElements(By.cssSelector(".ticket-bet-box .ticket-bet-name"));
        List<WebElement> cotaLista = webDriver.findElements(By.cssSelector(".ticket-bet-box .odds-value"));

        System.out.println("Continut bilet: ");
        System.out.println("=====================");
        for (index = 0; index < cotaLista.size(); index++) {
            System.out.println("Meci: " + numeMeciLista.get(index).getText());
            System.out.println("Cota: " + cotaLista.get(index).getText());
            System.out.println("-------------------");
        }

        WebElement cotaTotala = webDriver.findElement(By.cssSelector(".ticket-summary .total-odds"));
        System.out.println("Cota totala: " + cotaTotala.getText());
        System.out.println("-------------------");


        WebElement miza = webDriver.findElement(By.cssSelector("input[class ='input-total-bet']"));
        miza.click();
        String mizaValue = "5";
        System.out.println("Miza: " + mizaValue);
        System.out.println("-------------------");
        miza.sendKeys(mizaValue);

        WebElement castigPosibil = webDriver.findElement(By.cssSelector("input[name = 'total-win']"));
        String castigPosibilValue = castigPosibil.getAttribute("value");
        System.out.println("Castig posibil: " + castigPosibilValue + " LEI ");

        WebElement plasareAgentie = webDriver.findElement(By.cssSelector("button[class ='retail-ticket ticket-switch ']"));
        plasareAgentie.click();


        WebElement pregatireBilet = new WebDriverWait(webDriver, Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class ='button button-dark']")));
        pregatireBilet.click();

        WebElement arataBilet = new WebDriverWait(webDriver, Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(By.id("afterbet-dialog-show")));
        arataBilet.click();

//        new WebDriverWait(webDriver, Duration.ofSeconds(30));
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        webDriver.quit();
    }
}