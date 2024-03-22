package propertyUtility;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtility {

    // aceasta clasa reprezinta interactiunea cu un fisier de proprietati
    // trebuie sa facem o metoda care sa incarce un fisier
    // trebuie sa facem o metoda care sa citeasca toate datele dintr-un fisier

    // extensie
    private Properties properties;
    // interactiunea cu fisierul
    private FileInputStream fileInputStream;

    public PropertyUtility(String path) {
        loadFile(path);
    }

    private void loadFile(String path) {
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream("InputData/" + path + ".properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
        }
    }

    public Map<String, String> getAllData() {

        Map<String, String> testData = new HashMap<>();
        for (String key : properties.stringPropertyNames()){
            testData.put(key,properties.getProperty(key));
        }
        return testData;
    }
}