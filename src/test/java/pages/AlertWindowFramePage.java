package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertWindowFramePage extends BasePage {

    public AlertWindowFramePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text() ='Alerts']")
    private WebElement alertField;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesField;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsField;


    public void navigateToAlertPage() {
        elementMethods.scrollElementByPixel(0, 350);
        elementMethods.clickElement(alertField);
    }

    public void navigateToFramePage() {
        elementMethods.clickElement(framesField);
    }
    public void navigateToWindowPage(){
        elementMethods.clickElement(browserWindowsField);
    }
}