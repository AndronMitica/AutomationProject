package pages;

import ObjectData.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class PracticeFormsPage extends BasePage{
    public PracticeFormsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameField;
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    @FindBy(css = "input[placeholder='Mobile Number'")
    private WebElement userMobileNumber;
    @FindBy (css = ".react-datepicker__input-container")
    private WebElement dateOfBirthField;
    @FindBy (css = ".react-datepicker__month-select")
    private WebElement monthField;
    @FindBy (css = ".react-datepicker__year-select")
    private WebElement yearField;
    @FindBy (xpath = "//div[not(contains(@class, 'outside-month')) and contains(@class, 'react-datepicker__day react-datepicker__day')]")
    private List<WebElement> dayDateOfBirthFields;
    @FindBy (xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    private List<WebElement> hobbiesList;
    @FindBy (id = "subjectsInput")
    private WebElement subjectsField;
    @FindBy (id = "uploadPicture")
    private WebElement pictureField;
    @FindBy (css = "textarea[placeholder='Current Address']")
    private WebElement addressField;
    @FindBy (xpath = "//div[text()='Select State']")
    private WebElement selectState;
    @FindBy (id = "react-select-3-input")
    private WebElement selectState2;
    @FindBy(xpath = "//div[text()='Select City']")
    private WebElement selectCity;
    @FindBy (id = "react-select-4-input")
    private WebElement selectCity2;
    @FindBy(css = "label[for=gender-radio-1")
    private WebElement userGender;
    @FindBy (id = "submit")
    private WebElement submit;
    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> labelFields;
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private List<WebElement> valueFields;


    public void fillFirstName(String firstNameFieldValue){
        elementMethods.fillElement(firstNameField, firstNameFieldValue);
        elementMethods.scrollElementByPixel(0, 450);
    }

    public void fillLastName(String lastNameFieldValue){
        elementMethods.fillElement(lastNameField, lastNameFieldValue);
        elementMethods.scrollElementByPixel(0, 450);
    }

    public void fillEmailField(String emailFieldValue){

        elementMethods.fillElement(userEmail, emailFieldValue);
    }

    public void pickBirthDate(String monthDateOfBirthValue, String yearValue, String dayValue){
        elementMethods.clickElement(dateOfBirthField);
        elementMethods.selectTextElement(monthField, monthDateOfBirthValue);
        elementMethods.selectValueElement(yearField, yearValue);
        for (Integer i = 0; i < dayDateOfBirthFields.size(); i++){
            if (dayDateOfBirthFields.get(i).getText().equals(dayValue)){
                dayDateOfBirthFields.get(i).click();
                break;
            }
        }
    }

    public void pickGenderOption(String genderSelection) {

        if (Objects.equals(genderSelection, "Male")) {
            elementMethods.clickElement(userGender);
        }
        else if (Objects.equals(genderSelection, "Female")){
            elementMethods.clickElement(userGender);
        }
        else if (Objects.equals(genderSelection, "Other")){
            elementMethods.clickElement(userGender);
        }
    }

    public void fillMobileNoField(String mobileNoValue){
        elementMethods.fillElement(userMobileNumber, mobileNoValue);
    }

    public void pickSubjects(String subjectFieldValue){
        elementMethods.fillPressElement(subjectsField, subjectFieldValue, Keys.ENTER);
    }

    public void pickHobbies(List<String> hobbies){
        for (Integer index=0; index<hobbiesList.size(); index++){
            String currentElementText= hobbiesList.get(index).getText();
            if (hobbies.contains(currentElementText)){
                elementMethods.clickElemForce(hobbiesList.get(index));
            }
        }
    }

    public void uploadPicture(String filePath){
        elementMethods.fillElement(pictureField, new File(filePath).getAbsolutePath());
    }

    public void pickAddress(String addressFieldValue){

        elementMethods.fillElement(addressField, addressFieldValue);
    }

    public void pickState(String stateLoc){
        elementMethods.clickElemForce(selectState);
        elementMethods.fillPressElement(selectState2, stateLoc, Keys.ENTER);
    }

    public void pickCity(String cityLoc){
        elementMethods.clickElemForce(selectCity);
        elementMethods.fillPressElement(selectCity2, cityLoc, Keys.ENTER);
    }

    public void clickSubmit(){

        elementMethods.clickElemForce(submit);
    }

    public void fillEntireForm(PracticeFormObject practiceFormObject){
        fillFirstName(practiceFormObject.getFirstNameFieldValue());
        fillLastName(practiceFormObject.getLastNameFieldValue());
        fillEmailField(practiceFormObject.getEmailFieldValue());
        fillMobileNoField(practiceFormObject.getMobileNoFieldValue());
        pickBirthDate(practiceFormObject.getMonthDateOfBirthValue(), practiceFormObject.getYearValue(), practiceFormObject.getDayValue());
        uploadPicture(practiceFormObject.getFilePath());
        pickHobbies(practiceFormObject.getHobbies());
        pickSubjects(practiceFormObject.getSubjectFieldValue());
        pickAddress(practiceFormObject.getAddressFieldValue());
        pickState(practiceFormObject.getStateLoc());
        pickCity(practiceFormObject.getCityLoc());
        pickGenderOption(practiceFormObject.getGenderValue());
        clickSubmit();
    }

    public void validatePracticeFormTable(PracticeFormObject practiceFormObject){

        Assert.assertEquals(labelFields.get(0).getText(),"Student Name");
        Assert.assertEquals(valueFields.get(0).getText(), practiceFormObject.getFirstNameFieldValue()+ " " + practiceFormObject.getLastNameFieldValue());

        Assert.assertEquals(labelFields.get(1).getText(), "Student Email");
        Assert.assertEquals(valueFields.get(1).getText(), practiceFormObject.getEmailFieldValue());

        Assert.assertEquals(labelFields.get(2).getText(), "Gender");
        Assert.assertEquals(valueFields.get(2).getText(), practiceFormObject.getGenderValue());

        Assert.assertEquals(labelFields.get(3).getText(), "Mobile");
        Assert.assertEquals(valueFields.get(3).getText(), practiceFormObject.getMobileNoFieldValue());

        Assert.assertEquals(labelFields.get(4).getText(), "Date of Birth");
        Assert.assertEquals(valueFields.get(4).getText(), practiceFormObject.getDayValue() + " " + practiceFormObject.getMonthDateOfBirthValue() + "," + practiceFormObject.getYearValue());

        Assert.assertEquals(labelFields.get(5).getText(), "Subjects");
        Assert.assertEquals(valueFields.get(5).getText(), practiceFormObject.getSubjectFieldValue());

        Assert.assertEquals(labelFields.get(6).getText(), "Hobbies");
        for (Integer index = 0; index < practiceFormObject.getHobbies().size(); index ++) {
            Assert.assertTrue(valueFields.get(6).getText().contains(practiceFormObject.getHobbies().get(index)));
        }

        Assert.assertEquals(labelFields.get(7).getText(), "Picture");
        String[] arrayFile= practiceFormObject.getFilePath().split("/");
        Integer desiredIndex=arrayFile.length -1;
        Assert.assertEquals(valueFields.get(7).getText(), arrayFile[desiredIndex]);

        Assert.assertEquals(labelFields.get(8).getText(), "Address");
        Assert.assertEquals(valueFields.get(8).getText(), practiceFormObject.getAddressFieldValue());

        Assert.assertEquals(labelFields.get(9).getText(), "State and City");
        Assert.assertEquals(valueFields.get(9).getText(),practiceFormObject.getStateLoc() + " " + practiceFormObject.getCityLoc());
    }
}