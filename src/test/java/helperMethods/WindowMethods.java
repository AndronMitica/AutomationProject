package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {

    private WebDriver webDriver;

    public WindowMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void switchSpecificTabWindow(Integer index) {

        List<String> tabsOpened = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabsOpened.get(index));
        System.out.println("Tabul curent are URL:" + webDriver.getCurrentUrl());
    }

    public void closeCurrentTabWindow() {
        webDriver.close();
    }
}