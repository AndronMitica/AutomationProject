package ObjectData;

import java.util.Map;

public class WebTableObject {

    private String firstNameValue = "Mitica";
    private String lastNameValue = "Andron";
    private String emailFieldValue = "mitica@example.com";
    private String ageFieldValue = "27";
    private String salaryFieldValue = "2000";
    private String departmentFieldValue = "QA";

    // facem o metoda care sa mapeze datele din fisierul de resursa cu reprezentarea aceastui obiect
    public WebTableObject(Map<String, String> testData) {
        prepareObject(testData);
    }

    private void prepareObject(Map<String, String> testdata) {

        for (String key : testdata.keySet()) {
            switch (key) {
                case "firstNameValue":
                    setFirstNameValue(testdata.get(key));
                    break;

                case "lastNameValue":
                    setLastNameValue(testdata.get(key));
                    break;
                case "emailFieldValue":
                    setEmailFieldValue(testdata.get(key));
                    break;
                case "ageFieldValue":
                    setAgeFieldValue(testdata.get(key));
                    break;
                case "salaryFieldValue":
                    setSalaryFieldValue(testdata.get(key));
                    break;
                case "departmentFieldValue":
                    setDepartmentFieldValue(testdata.get(key));
                    break;
            }
        }
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getEmailFieldValue() {
        return emailFieldValue;
    }

    public void setEmailFieldValue(String emailFieldValue) {
        this.emailFieldValue = emailFieldValue;
    }

    public String getAgeFieldValue() {
        return ageFieldValue;
    }

    public void setAgeFieldValue(String ageFieldValue) {
        this.ageFieldValue = ageFieldValue;
    }

    public String getSalaryFieldValue() {
        return salaryFieldValue;
    }

    public void setSalaryFieldValue(String salaryFieldValue) {
        this.salaryFieldValue = salaryFieldValue;
    }

    public String getDepartmentFieldValue() {
        return departmentFieldValue;
    }

    public void setDepartmentFieldValue(String departmentFieldValue) {
        this.departmentFieldValue = departmentFieldValue;
    }
}