package tests;

import ObjectData.WebTableObject;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import propertyUtility.PropertyUtility;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest() {
        PropertyUtility propertyUtility = new PropertyUtility("WebTableData");
        WebTableObject webTableObject = new WebTableObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToElementsPage();

        ElementsPage elementsPage = new ElementsPage(getWebDriver());
        elementsPage.navigateToWebTablePage();

        WebTablePage webTablePage = new WebTablePage(getWebDriver());
        webTablePage.addNewEntry(webTableObject);

        webTableObject.setFirstNameValue("Titi");
        webTableObject.setAgeFieldValue("28");

        webTablePage.editEntry(webTableObject);
        webTablePage.deleteEntry();
    }
}