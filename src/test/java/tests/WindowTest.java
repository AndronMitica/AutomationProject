package tests;

import helperMethods.ElementMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WindowTest extends SharedData {

    @Test
    public void testMethod() {
        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        WindowMethods windowMethods = new WindowMethods(getWebDriver());

        elementMethods.scrollElementByPixel(0, 450);

        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
        elementMethods.clickElement(consentField);

        WebElement formsField = getWebDriver().findElement(By.xpath("//h5[text() ='Alerts, Frame & Windows']"));
        elementMethods.clickElement(formsField);

        elementMethods.scrollElementByPixel(0, 450);


        WebElement browserFormField = getWebDriver().findElement(By.xpath("//span[text() ='Browser Windows']"));
        elementMethods.clickElement(browserFormField);

        WebElement newTabButton = getWebDriver().findElement(By.id("tabButton"));
        elementMethods.clickElement(newTabButton);

        windowMethods.switchSpecificTabWindow(1);
        windowMethods.closeCurrentTabWindow();
        windowMethods.switchSpecificTabWindow(0);

        WebElement newWindowButton = getWebDriver().findElement(By.id("windowButton"));
        elementMethods.clickElement(newWindowButton);

        windowMethods.switchSpecificTabWindow(1);
        windowMethods.closeCurrentTabWindow();
        windowMethods.switchSpecificTabWindow(0);
    }
}