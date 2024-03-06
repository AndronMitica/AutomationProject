package tests;

import helperMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class WebTableTestForms extends SharedData {

    @Test
    public void metodaTest() {


        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        elementMethods.scrollElementByPixel(0, 450);

        // identificam un element
        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
        elementMethods.clickElement(consentField);

        WebElement formsField = getWebDriver().findElement(By.xpath("//h5[text() ='Forms']"));
        elementMethods.clickElement(formsField);

        WebElement practiceFormField = getWebDriver().findElement(By.xpath("//span[text() ='Practice Form']"));
        elementMethods.clickElement(practiceFormField);

        elementMethods.scrollElementByPixel(0, 450);

        WebElement firstNameField = getWebDriver().findElement(By.id("firstName"));
        String firstNameValue = "Mitica";
        elementMethods.fillElement(firstNameField, firstNameValue);

        WebElement lastNameField = getWebDriver().findElement(By.cssSelector("input[placeholder = 'Last Name']"));
        String lastNameValue = "Andron";
        elementMethods.fillElement(lastNameField, lastNameValue);

        WebElement emailField = getWebDriver().findElement(By.id("userEmail"));
        String emailFieldValue = "mitica.andron@example.com";
        elementMethods.fillElement(emailField, emailFieldValue);

        WebElement mobileField = getWebDriver().findElement(By.id("userNumber"));
        String mobileValue = "0722221222";
        elementMethods.fillElement(mobileField, mobileValue);

        String genderValue = "Male";
        selectGender(genderValue);

        elementMethods.scrollElementByPixel(0, 450);

        WebElement dateOfBirthField = getWebDriver().findElement(By.cssSelector(".react-datepicker__input-container"));
        elementMethods.clickElement(dateOfBirthField);

        WebElement monthField = getWebDriver().findElement(By.cssSelector(".react-datepicker__month-select"));
        String monthValue = "October";
        elementMethods.selectTextElement(monthField, monthValue);

        WebElement yearField = getWebDriver().findElement(By.cssSelector(".react-datepicker__year-select"));
        String yearValue = "1996";
        elementMethods.selectValueElement(yearField, yearValue);

        List<WebElement> dayDateOfBirthField = getWebDriver().findElements(By.xpath
                ("//div[not(contains(@class,'react-datepicker__day--outside-month')) and  contains(@class,'react-datepicker__day') and contains(@class,'react-datepicker__day--')]"));
        String dayValue = "26";
        for (Integer index = 0; index < dayDateOfBirthField.size(); index++) {
            if (dayDateOfBirthField.get(index).getText().equals(dayValue)) {
                dayDateOfBirthField.get(index).click();
                break;
            }
        }
        elementMethods.scrollElementByPixel(0, 450);

        String subjectValue = "Economics";
        WebElement subjectsField = getWebDriver().findElement(By.id("subjectsInput"));
        elementMethods.fillPressElement(subjectsField, subjectValue, Keys.ENTER);

//        selectHobby("Sports");
        // facem un algoritm care sa selecteze valorile pe care le specific
        List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
        List<WebElement> hobbiesList = getWebDriver().findElements(By.xpath
                ("//div[@id='hobbiesWrapper'] //label[@class = 'custom-control-label']"));
        for (Integer index = 0; index < hobbiesList.size(); index++) {
            String currentElementText = hobbiesList.get(index).getText();
            if (hobbies.contains(currentElementText)) {
                elementMethods.clickElemForce(hobbiesList.get(index));
            }
        }

        String filePath = "src/test/resources/test_photo.jpg";
        WebElement pictureField = getWebDriver().findElement(By.id("uploadPicture"));
        elementMethods.fillElement(pictureField, new File(filePath).getAbsolutePath());

        WebElement currentAddressField = getWebDriver().findElement(By.id("currentAddress"));
        String currentAddressValue = "Str Rasaritului Nr 10 Bloc 60 Ap 25";
        elementMethods.fillElement(currentAddressField, currentAddressValue);

        elementMethods.scrollElementByPixel(0, 450);

        WebElement subjectField = getWebDriver().findElement(By.xpath("//div[text()='Select State']"));
        elementMethods.clickElemForce(subjectField);

        WebElement stateField = getWebDriver().findElement(By.id("react-select-3-input"));

        String stateInputValue = "NCR";
        elementMethods.fillPressElement(stateField, stateInputValue, Keys.ENTER);

        WebElement cityField = getWebDriver().findElement(By.id("react-select-4-input"));
        elementMethods.scrollElementByPixel(0, 450);

        String cityInputValue = "Delhi";
        elementMethods.fillPressElement(cityField, cityInputValue, Keys.ENTER);

        WebElement submit = getWebDriver().findElement(By.id("submit"));
        elementMethods.clickElemForce(submit);

        //validam tabelul cu valori
        List<WebElement> labelField = getWebDriver().findElements(By.xpath("//table / tbody/tr/td[1]"));
        List<WebElement> valueField = getWebDriver().findElements(By.xpath("//table / tbody/tr/td[2]"));

        Assert.assertEquals(labelField.get(0).getText(), "Student Name");
        Assert.assertEquals(valueField.get(0).getText(), firstNameValue + " " + lastNameValue);

        Assert.assertEquals(labelField.get(1).getText(), "Student Email");
        Assert.assertEquals(valueField.get(1).getText(), emailFieldValue);

        Assert.assertEquals(labelField.get(2).getText(), "Gender");
        Assert.assertEquals(valueField.get(2).getText(), genderValue);

        Assert.assertEquals(labelField.get(3).getText(), "Mobile");
        Assert.assertEquals(valueField.get(3).getText(), mobileValue);

        Assert.assertEquals(labelField.get(4).getText(), "Date of Birth");
        Assert.assertEquals(valueField.get(4).getText(), "26 October,1996");

        Assert.assertEquals(labelField.get(5).getText(), "Subjects");
        Assert.assertEquals(valueField.get(5).getText(), subjectValue);

        Assert.assertEquals(labelField.get(6).getText(), "Hobbies");
        for (Integer index = 0; index < hobbiesList.size(); index++) {
            Assert.assertTrue(valueField.get(6).getText().contains(hobbies.get(index)));
        }

        Assert.assertEquals(labelField.get(7).getText(), "Picture");
        String[] arrayFile = filePath.split("/");
        Integer desiredIndex = arrayFile.length - 1;
        Assert.assertEquals(valueField.get(7).getText(), arrayFile[desiredIndex]);

        Assert.assertEquals(labelField.get(8).getText(), "Address");
        Assert.assertEquals(valueField.get(8).getText(), currentAddressValue);

        // to do
        Assert.assertEquals(labelField.get(9).getText(), "State and City");
        Assert.assertEquals(valueField.get(9).getText(), stateInputValue + " " + cityInputValue);

    }

    public void selectGender(String input) {

        if (input == "Male") {
            WebElement maleGender = getWebDriver().findElement(By.cssSelector("label[for='gender-radio-1']"));
            maleGender.click();
        } else if (input == "Female") {
            WebElement femaleGender = getWebDriver().findElement(By.cssSelector("label[for='gender-radio-2']"));
            femaleGender.click();
        } else {
            WebElement otherGender = getWebDriver().findElement(By.cssSelector("label[for='gender-radio-3']"));
            otherGender.click();
        }
    }

    public void selectHobby(String input) {

        if (input == "Sports") {
            WebElement sportHobbiesField = getWebDriver().findElement(By.cssSelector("label[for='hobbies-checkbox-1'"));
            sportHobbiesField.click();
        } else if (input == "Reading") {
            WebElement readinghobiesField = getWebDriver().findElement(By.cssSelector("label[for='hobbies-checkbox-2'"));
            readinghobiesField.click();
        } else {
            WebElement musicHobbiesField = getWebDriver().findElement(By.cssSelector("label[for='hobbies-checkbox-3'"));
            musicHobbiesField.click();
        }
    }
}