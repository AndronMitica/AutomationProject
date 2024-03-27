package tests;

import ObjectData.PracticeFormObject;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormsPage;
import propertyUtility.PropertyUtility;
import sharedData.SharedData;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {
        PropertyUtility propertyUtility = new PropertyUtility("PracticeFormData");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToFormsPage();

        FormsPage formsPage = new FormsPage(getWebDriver());
        formsPage.navigateToPracticeForm();

        PracticeFormsPage practiceFormsPage = new PracticeFormsPage(getWebDriver());
        practiceFormsPage.fillEntireForm(practiceFormObject);

        practiceFormsPage.validatePracticeFormTable(practiceFormObject);
    }
}