package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddItemToShoppingCartEmag {

    public WebDriver webDriver;

    @Test
    public void testMethod() {
        // open Firefox browser
        webDriver = new FirefoxDriver();

        // open URL
        webDriver.get("https://www.emag.ro/");

        // maximize
        webDriver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        WebElement acceptatiToateField = webDriver.findElement(
                By.cssSelector("button[class= 'btn btn-primary js-accept gtm_h76e8zjgoo btn-block']"));
//        acceptatiToateField.click();
        js.executeScript("arguments[0].click();", acceptatiToateField);

        WebElement intraInContField = webDriver.findElement(By.id("my_account"));
        intraInContField.click();

        WebElement emailFiled = webDriver.findElement(By.id("user_login_email"));
        String emilValue = "mitica.extra@gmail.com";
        emailFiled.sendKeys(emilValue);

        WebElement continuaButton = webDriver.findElement(By.cssSelector("button[name = 'user_login[continue]']"));
        continuaButton.click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement passwordField = webDriver.findElement(By.id("user_login_password"));
        String passwordValue = "Testtesttest1";
        passwordField.sendKeys(passwordValue);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement continuePasswordField = webDriver.findElement(By.id("user_login_continue"));
        continuePasswordField.click();
        continuePasswordField.click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement confirmaMaiTarziuButton = webDriver.findElement(By.xpath(
                "//a[contains(text(), 'Confirmă mai târziu')]"));
        confirmaMaiTarziuButton.click();

        WebElement laptopTableteTelefoaneButton = webDriver.findElement(By.xpath(
                "//span[text() = 'Laptop, Tablete & Telefoane']"));
        laptopTableteTelefoaneButton.click();

        WebElement wearablesSiGadgeturi = webDriver.findElement(By.xpath(
                "//a[text() = 'Wearables & Gadgeturi' ]"));
        wearablesSiGadgeturi.click();

        WebElement huaweiImage = webDriver.findElement(By.xpath("//img[@alt = 'Huawei' ]"));
        huaweiImage.click();

        js.executeScript("window.scrollBy(0,450)", "");

        WebElement livrateDeEmagCheckBox = webDriver.findElement(By.xpath(
                "//div[@class='filter-body js-scrollable']/a[@data-option-order='2']"));
        livrateDeEmagCheckBox.click();


//        //algoritm selectare tip livrare
//        List<String> livratDe = Arrays.asList("Toate Produsele", "Livrate de eMAG");
//        List<WebElement> livratDeList = webDriver.findElements(By.xpath(
//                "//div[@class='filter-body js-scrollable']"));
//        for(Integer index = 0; index < livratDeList.size();index++){
//            String currentElementText = livratDeList.get(index).getText();
//            if(livratDe.contains(currentElementText)) {
//                livratDeList.get(index).click();
//            }
//        }
        WebElement disponibilitateCheckBox = webDriver.findElement(By.xpath(
                "//a[@class='js-filter-item filter-item' and @data-option-id='stock']"));
        disponibilitateCheckBox.click();

        WebElement intervalPretCheckBox = webDriver.findElement(By.xpath(
                "//a[@class='js-filter-item filter-item' and @data-name='1.000 - 1.500']"));
        intervalPretCheckBox.click();

        WebElement desiredItem = webDriver.findElement(By.xpath(
                "//a[@href = 'https://www.emag.ro/smartwatch-huawei-watch-gt-3-pro-fluoroelastomer-strap-black-55028468/pd/DK4VWSMBM/?' and @data-zone = 'title']"));
        desiredItem.click();


        WebElement adaugaInCosButton = webDriver.findElement(By.xpath(
                "//button[@type='submit' and @class='btn btn-xl btn-primary btn-emag btn-block main-button gtm_680klw yeahIWantThisProduct']\n"));
        adaugaInCosButton.click();

        WebElement veziDetaliiCosButton = webDriver.findElement(By.xpath(
                "//a[@href ='/cart/products?ref=add-to-cart-module_go-to-cart_button' and text() = 'Vezi detalii cos']"));
        veziDetaliiCosButton.click();
//
//        WebElement continuaCosButton = webDriver.findElement(By.xpath(
//                "//div[@class='js-order-summary-actions-wrapper order-summary-actions-wrapper']/a[@href = '/cart/checkout']"));
//        continuaCosButton.click();
    }
}