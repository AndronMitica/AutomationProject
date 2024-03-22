package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy (id = "alertButton")
    private WebElement alertOk;
    @FindBy (id = "timerAlertButton")
    private WebElement timerAlertButton;
    @FindBy (id = "confirmButton")
    private WebElement confirmButton;
    @FindBy (id = "promtButton")
    private WebElement promptAlertButton;
    @FindBy (id = "confirmResult")
    private WebElement confirmButtonResult;
    @FindBy (id = "promptResult")
    private WebElement promptResult;

    public void dealWithAcceptAlert () {
        elementMethods.clickElement(alertOk);
        alertMethods.acceptAlert();
    }

    public void dealWithDelayAlert () {
        elementMethods.clickElement(timerAlertButton);
        alertMethods.waitForAlert();
        alertMethods.acceptAlert();
    }

    public  void dealWithPromtButton (String text) {
        elementMethods.clickElemForce(promptAlertButton);
        alertMethods.fillAlert(text);
        elementMethods.validateElementText(promptResult, "You entered " + text);
    }

    public void dealWithConfirmButton () {
        elementMethods.clickElement(confirmButton);
        alertMethods.cancelAlert();
    }
}