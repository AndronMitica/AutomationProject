package tests;

import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {
        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        FrameMethods frameMethods = new FrameMethods(getWebDriver());

        elementMethods.scrollElementByPixel(0, 450);

        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
        elementMethods.clickElement(consentField);

        WebElement formsField = getWebDriver().findElement(By.xpath
                ("//h5[text() ='Alerts, Frame & Windows']"));
        elementMethods.clickElement(formsField);

        elementMethods.scrollElementByPixel(0, 450);

        WebElement frameFormField = getWebDriver().findElement(By.xpath("//span[text() ='Frames']"));
        elementMethods.clickElement(frameFormField);

        // interactionam cu un iframe
        frameMethods.switchSpecificIframe("frame1");

        WebElement frame1Element = getWebDriver().findElement(By.id("sampleHeading"));
        elementMethods.printElementText(frame1Element);

        // speficam sa revina la frameul curent
        frameMethods.switchParentFrame();
        frameMethods.switchSpecificIframe("frame2");

        WebElement frame2Element = getWebDriver().findElement(By.id("sampleHeading"));
        elementMethods.printElementText(frame2Element);
    }
}