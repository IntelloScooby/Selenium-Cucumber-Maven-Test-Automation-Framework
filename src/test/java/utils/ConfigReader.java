package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static utils.Constants.TEST_CONFIG_FILE_PATH;

public class ConfigReader {

    public String getBaseUrl() {

        String baseUrl = "";

        try {
            InputStream input = new FileInputStream(TEST_CONFIG_FILE_PATH);

            Properties prop = new Properties();
            prop.load(input);
            baseUrl = prop.getProperty("baseUrl");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return baseUrl;
    }

    public String getBrowser() {
        String browser = "";

        try {
            InputStream input = new FileInputStream(TEST_CONFIG_FILE_PATH);

            Properties prop = new Properties();
            prop.load(input);
            browser = prop.getProperty("browser");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return browser;
    }

}
