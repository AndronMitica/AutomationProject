package tests;

import org.testng.annotations.Test;
import pages.AlertWindowFramePage;
import pages.HomePage;
import pages.WindowPage;
import sharedData.SharedData;

public class WindowTest extends SharedData {


    @Test
    public void windowMethod() {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToWindowPage();

        WindowPage windowPage = new WindowPage(getWebDriver());
        windowPage.interactWithTabBrowser();
        windowPage.interactNewWindow();
    }
}