package pages;

import ObjectData.WebTableObject;
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

    public void addNewEntry(WebTableObject webTableObject){
        addButton.click();
        elementMethods.fillElement(firstNameField,webTableObject.getFirstNameValue());
        elementMethods.fillElement(lastNameField,webTableObject.getLastNameValue());
        elementMethods.fillElement(emailField, webTableObject.getEmailFieldValue());
        elementMethods.fillElement(ageField, webTableObject.getAgeFieldValue());
        elementMethods.fillElement(salaryField,webTableObject.getSalaryFieldValue());
        elementMethods.fillElement(departmentField, webTableObject.getDepartmentFieldValue());
        submitButton.click();
    }

    public void editEntry(WebTableObject webTableObject){
        elementMethods.clickElemForce(editButton);
        elementMethods.refillElement(firstNameField,webTableObject.getFirstNameValue());
        elementMethods.refillElement(ageField, webTableObject.getAgeFieldValue());
        elementMethods.clickElement(submitButton);
    }

    public void deleteEntry(){
        elementMethods.clickElemForce(deleteButton);
    }
}