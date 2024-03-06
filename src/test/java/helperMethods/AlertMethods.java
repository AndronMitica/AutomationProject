package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

   private WebDriver webDriver;

    public AlertMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void acceptAlert() {
        waitForAlert();
        Alert firstAlert = webDriver.switchTo().alert();
        firstAlert.accept();
    }
public void cancelAlert() {
        waitForAlert();
        Alert firstAlert = webDriver.switchTo().alert();
        firstAlert.dismiss();
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void fillAlert(String value) {
        Alert forthAlert = webDriver.switchTo().alert();
        forthAlert.sendKeys(value);
        forthAlert.accept();
    }
}