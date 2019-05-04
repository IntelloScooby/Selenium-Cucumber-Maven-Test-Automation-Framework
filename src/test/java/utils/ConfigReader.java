package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static utils.Constants.TEST_CONFIG_FILE_PATH;

public class ConfigReader {

    public String getBaseUrl() {
        return getPropertyValue("baseUrl");
    }

    public String getBrowser() {
        return getPropertyValue("browser");
    }

    private String getPropertyValue(String propertyKey) {
        String propertyValue = "";

        try {
            InputStream input = new FileInputStream(TEST_CONFIG_FILE_PATH);

            Properties prop = new Properties();
            prop.load(input);
            propertyValue = prop.getProperty(propertyKey);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return propertyValue;
    }

}
