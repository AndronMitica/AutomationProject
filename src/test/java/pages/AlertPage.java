package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    @FindBy(id = "alertButton")
    private WebElement alertOK;
    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;
    @FindBy(id = "confirmButton")
    private WebElement confirmButton;
    @FindBy(id = "promtButton")
    private WebElement promptAlertButton;
    @FindBy(id = "confirmResult")
    private WebElement confirmButtonResult;
    @FindBy(id = "promptResult")
    private WebElement promptResult;
    public AlertPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void dealWithAcceptAlert() {
        elementMethods.clickElement(alertOK);
        alertMethods.acceptAlert();
    }

    public void dealWithDellayAlert() {
        elementMethods.clickElement(timerAlertButton);
        alertMethods.acceptAlert();
    }

    public void dealWithConfrimButton() {
        elementMethods.clickElement(confirmButton);
        alertMethods.cancelAlert();
        elementMethods.validateElementText(confirmButtonResult, "You selected Cancel");
    }

    public void dealWithPromtButton(String value) {
        elementMethods.clickElement(promptAlertButton);
        alertMethods.fillAlert(value);
        elementMethods.validateElementText(promptResult, "You entered " + value);
    }
}
