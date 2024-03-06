package helperMethods;

import org.openqa.selenium.WebDriver;

public class FrameMethods {

   private WebDriver webDriver;

    public FrameMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void switchSpecificIframe(String value) {
        webDriver.switchTo().frame(value);
    }

    public void switchParentFrame() {
        webDriver.switchTo().parentFrame();
    }
}
