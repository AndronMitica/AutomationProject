package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToElementsPage();

        ElementsPage elementsPage = new ElementsPage(getWebDriver());
        elementsPage.navigateToWebTablePage();

        String firstNameValue = "Mitica";
        String lastNameValue = "Andron";
        String emailFieldValue = "mitica@example.com";
        String ageFieldValue = "27";
        String salaryFieldValue = "2000";
        String departmentFieldValue = "QA";
        String firstNameModifyValue = "Titi";
        String ageModifyFieldValue = "28";

        WebTablePage webTablePage = new WebTablePage(getWebDriver());
        webTablePage.addNewEntry(firstNameValue, lastNameValue, emailFieldValue, ageFieldValue, salaryFieldValue, departmentFieldValue);
        webTablePage.editEntry(firstNameModifyValue, ageModifyFieldValue);
        webTablePage.deleteEntry();
    }
}