package tests;

import org.testng.annotations.Test;
import pages.AlertPage;
import pages.AlertWindowFramePage;
import pages.HomePage;
import sharedData.SharedData;

public class AlertsTest extends SharedData {


    @Test
    public void testMethod() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToAlertPage();

        AlertPage alertPage = new AlertPage(getWebDriver());
        alertPage.dealWithAcceptAlert();
        alertPage.dealWithDelayAlert();
        alertPage.dealWithPromtButton("test");
        alertPage.dealWithConfirmButton();
    }
}