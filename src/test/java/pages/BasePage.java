package pages;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public  WebDriver webDriver;
    public  ElementMethods elementMethods;
    public AlertMethods alertMethods;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        elementMethods = new ElementMethods(webDriver);
        alertMethods = new AlertMethods(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}