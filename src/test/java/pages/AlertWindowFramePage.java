package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertWindowFramePage extends BasePage {
    public AlertWindowFramePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text() ='Alerts']")
    private WebElement browserFormField;


    public void navigateToAlertPage() {
        elementMethods.scrollElementByPixel(0, 350);
        elementMethods.clickElement(browserFormField);
    }
}