package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{
    public WebTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addButton;
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "userEmail")
    private WebElement emailField;
    @FindBy(id = "age")
    private WebElement ageField;
    @FindBy(id = "salary")
    private WebElement salaryField;
    @FindBy(id = "department")
    private WebElement departmentField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(id = "edit-record-4")
    private WebElement editButton;
    @FindBy(id = "delete-record-4")
    private WebElement deleteButton;

    public void addNewEntry(String firstNameValue,String lastNameValue, String emailFieldValue, String ageFieldValue,
                            String salaryFieldValue, String departmentFieldValue){
        addButton.click();
        elementMethods.fillElement(firstNameField,firstNameValue);
        elementMethods.fillElement(lastNameField,lastNameValue);
        elementMethods.fillElement(emailField, emailFieldValue);
        elementMethods.fillElement(ageField, ageFieldValue);
        elementMethods.fillElement(salaryField, salaryFieldValue);
        elementMethods.fillElement(departmentField, departmentFieldValue);
        submitButton.click();
    }

    public void editEntry(String firstNameValue, String ageFieldValue){
        elementMethods.clickElement(editButton);
        elementMethods.refillElement(firstNameField, firstNameValue);
        elementMethods.refillElement(ageField, ageFieldValue);
        elementMethods.clickElement(submitButton);
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteButton);
    }
}
