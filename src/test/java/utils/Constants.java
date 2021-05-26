package utils;

import java.nio.file.Paths;

public class Constants {

    //    File paths
    public static final String PROJECT_PATH = String.valueOf(Paths.get(System.getProperty("user.dir")));
    public static final String TEST_DATA_FILE_PATH = PROJECT_PATH + "/src/test/resources/TestData.json";
    public static final String TEST_REPORT_FILE_PATH = PROJECT_PATH + "/src/test/resources/test-output/CustomTestReport.html";
    public static final String TEST_REPORT_SCREENSHOTS_DIR = PROJECT_PATH + "/src/test/resources/test-output/screenshots/";
    public static final String TEST_CONFIG_FILE_PATH = PROJECT_PATH + "/src/test/resources/config.properties";

    //    Application messages
    public static final String HOME_PAGE_TITLE = "Officeworks | Stationery, Laptops, Furniture, Paper at Low Prices";
    public static final String INVALID_LOGIN_ERROR_MESSAGE = "Sorry, your details were incorrect and we could not log you in. Please try again.";

    //    Test Data file constants
    public static final String LOGIN_CREDENTIALS = "LoginCredentials";
    public static final String VALID_USER = "ValidUser";
    public static final String INVALID_USER = "InvalidUser";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";
}
