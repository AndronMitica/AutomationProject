package tests;

import helperMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        elementMethods.scrollElementByPixel(0, 450);

        // identificam un element
        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
        elementMethods.clickElement(consentField);

        WebElement elementsField = getWebDriver().findElement(By.xpath("//h5[text() = 'Elements']"));
        elementMethods.clickElement(elementsField);

        elementMethods.scrollElementByPixel(0, 450);

        WebElement webTablesField = getWebDriver().findElement(By.xpath("//span[text() = 'Web Tables']"));
        elementMethods.clickElement(webTablesField);

        WebElement addField = getWebDriver().findElement(By.id("addNewRecordButton"));
        elementMethods.clickElement(addField);

        WebElement firstNameField = getWebDriver().findElement(By.id("firstName"));
        String firstNameValue = "Mitica";
        elementMethods.fillElement(firstNameField, firstNameValue);

        WebElement lastNameField = getWebDriver().findElement(By.id("lastName"));
        String lastNameValue = "Andron";
        elementMethods.fillElement(lastNameField, lastNameValue);

        WebElement emailField = getWebDriver().findElement(By.id("userEmail"));
        String emailValue = "andron.mitica@gmail.com";
        elementMethods.fillElement(emailField, emailValue);

        WebElement ageField = getWebDriver().findElement(By.id("age"));
        String ageValue = "27";
        elementMethods.fillElement(ageField, ageValue);

        WebElement salaryField = getWebDriver().findElement(By.id("salary"));
        String salaryValue = "3000";
        elementMethods.fillElement(salaryField, salaryValue);

        WebElement departmentField = getWebDriver().findElement(By.id("department"));
        String departmentValue = "IT";
        elementMethods.fillElement(departmentField, departmentValue);

        WebElement submitField = getWebDriver().findElement(By.id("submit"));
        elementMethods.clickElement(submitField);

        // modificam entry ul adaugat mai sus
        WebElement editField = getWebDriver().findElement(By.id("edit-record-4"));
//        elementMethods.clickElement(editField);
        elementMethods.clickElemForce(editField);

        WebElement firstNameModifyField = getWebDriver().findElement(By.id("firstName"));
        String firstNameModifyValue = "Titi";
        elementMethods.refillElement(firstNameModifyField, firstNameModifyValue);

        WebElement ageModifyField = getWebDriver().findElement(By.id("age"));
        String ageModifyValue = "32";
        elementMethods.refillElement(ageModifyField, ageModifyValue);


        WebElement submitModifyField = getWebDriver().findElement(By.id("submit"));
        elementMethods.clickElement(submitModifyField);

        // stergem noul entry
        WebElement deleteField = getWebDriver().findElement(By.id("delete-record-4"));
//        elementMethods.clickElement(deleteField);
        elementMethods.clickElemForce(deleteField);
    }
}