package ObjectData;

import java.util.List;
import java.util.Map;

public class PracticeFormObject extends GeneralObject {

    private String firstNameFieldValue;
    private String lastNameFieldValue;
    private String emailFieldValue;
    private String mobileNoFieldValue;
    private String monthDateOfBirthValue;
    private String yearValue;
    private String dayValue;
    private String filePath;
    private List<String> hobbies;
    private String subjectFieldValue;
    private String addressFieldValue;
    private String genderValue;
    private String stateLoc;
    private String cityLoc;

    public PracticeFormObject(Map<String, String> testData) {
        prepareObject(testData);
    }

    private void prepareObject(Map<String, String> testdata) {

        for (String key : testdata.keySet()) {
            switch (key) {
                case "firstNameFieldValue":
                    setFirstNameFieldValue(testdata.get(key));
                    break;

                case "lastNameFieldValue":
                    setLastNameFieldValue(testdata.get(key));
                    break;
                case "emailFieldValue":
                    setEmailFieldValue(testdata.get(key));
                    break;
                case "mobileNoFieldValue":
                    setMobileNoFieldValue(testdata.get(key));
                    break;
                case "monthDateOfBirthValue":
                    setMonthDateOfBirthValue(testdata.get(key));
                    break;
                case "yearValue":
                    setYearValue(testdata.get(key));
                    break;
                case "dayValue":
                    setDayValue(testdata.get(key));
                    break;
                case "filePath":
                    setFilePath(testdata.get(key));
                    break;
                case "hobbies":
                    hobbies = getPreparedValue(testdata.get(key));
                    break;
                case "subjectFieldValue":
                    setSubjectFieldValue(testdata.get(key));
                    break;
                case "addressFieldValue":
                    setAddressFieldValue(testdata.get(key));
                    break;
                case "genderValue":
                    setGenderValue(testdata.get(key));
                    break;
                case "stateLoc":
                    setStateLoc(testdata.get(key));
                    break;
                case "cityLoc":
                    setCityLoc(testdata.get(key));
                    break;
            }
        }
    }

    public String getFirstNameFieldValue() {
        return firstNameFieldValue;
    }

    public void setFirstNameFieldValue(String firstNameFieldValue) {
        this.firstNameFieldValue = firstNameFieldValue;
    }

    public String getLastNameFieldValue() {
        return lastNameFieldValue;
    }

    public void setLastNameFieldValue(String lastNameFieldValue) {
        this.lastNameFieldValue = lastNameFieldValue;
    }

    public String getEmailFieldValue() {
        return emailFieldValue;
    }

    public void setEmailFieldValue(String emailFieldValue) {
        this.emailFieldValue = emailFieldValue;
    }

    public String getMobileNoFieldValue() {
        return mobileNoFieldValue;
    }

    public void setMobileNoFieldValue(String mobileNoFieldValue) {
        this.mobileNoFieldValue = mobileNoFieldValue;
    }

    public String getMonthDateOfBirthValue() {
        return monthDateOfBirthValue;
    }

    public void setMonthDateOfBirthValue(String monthDateOfBirthValue) {
        this.monthDateOfBirthValue = monthDateOfBirthValue;
    }

    public String getDayValue() {
        return dayValue;
    }

    public void setDayValue(String dayValue) {
        this.dayValue = dayValue;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getAddressFieldValue() {
        return addressFieldValue;
    }

    public void setAddressFieldValue(String addressFieldValue) {
        this.addressFieldValue = addressFieldValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getStateLoc() {
        return stateLoc;
    }

    public void setStateLoc(String stateLoc) {
        this.stateLoc = stateLoc;
    }

    public String getCityLoc() {
        return cityLoc;
    }

    public void setCityLoc(String cityLoc) {
        this.cityLoc = cityLoc;
    }

    public String getYearValue() {
        return yearValue;
    }

    public void setYearValue(String yearValue) {
        this.yearValue = yearValue;
    }

    public String getSubjectFieldValue() {
        return subjectFieldValue;
    }

    public void setSubjectFieldValue(String subjectFieldValue) {
        this.subjectFieldValue = subjectFieldValue;
    }
}