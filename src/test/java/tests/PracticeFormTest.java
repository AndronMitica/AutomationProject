package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormsPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToFormsPage();

        FormsPage formsPage = new FormsPage(getWebDriver());
        formsPage.navigateToPracticeForm();

        String firstNameFieldValue = "Mitica";
        String lastNameFieldValue = "Andron";
        String emailFieldValue = "mitica@example.com";
        String mobileNoFieldValue = "0123456789";
        String monthDateOfBirthValue = "October";
        String yearValue = "1996";
        String dayValue = "26";
        String filePath ="src/test/resources/test_photo.jpg";
        List<String> hobbies = Arrays.asList("Sports", "Music");
        String subjectFieldValue = "Arts";
        String addressFieldValue = "Example, No 5";
        String genderValue = "Male";
        String stateLoc = "NCR";
        String cityLoc = "Delhi";

        PracticeFormsPage practiceFormsPage = new PracticeFormsPage(getWebDriver());
        practiceFormsPage.fillEntireForm(firstNameFieldValue, lastNameFieldValue, emailFieldValue, mobileNoFieldValue, monthDateOfBirthValue,
                yearValue, dayValue, genderValue, hobbies, subjectFieldValue, filePath, addressFieldValue,
                stateLoc, cityLoc);

        practiceFormsPage.validatePracticeFormTable(firstNameFieldValue, lastNameFieldValue, emailFieldValue, genderValue, mobileNoFieldValue,
                monthDateOfBirthValue, yearValue, dayValue, subjectFieldValue, hobbies,  filePath, addressFieldValue, stateLoc, cityLoc);
    }
}