package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//h5[text() ='Alerts, Frame & Windows']")
    private WebElement alertsField;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsField;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsField;

    public void navigateToAlertFrameWindowPage(){
        elementMethods.scrollElementByPixel(0,450);
        //  elementMethods.clickElement(consentField);
        elementMethods.clickElement(alertsField);
    }

    public void navigateToFormsPage(){
        elementMethods.scrollElementByPixel(0,450);
        elementMethods.clickElement(formsField);
    }
    public void navigateToElementsPage(){
        elementMethods.scrollElementByPixel(0, 450);
        elementMethods.clickElement(elementsField);
    }
}