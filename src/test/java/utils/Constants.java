package utils;

import java.nio.file.Paths;

public class Constants {

//    File paths
    public static final String PROJECT_PATH = String.valueOf(Paths.get(System.getProperty("user.dir")));
    public static final String TEST_DATA_FILE_PATH = PROJECT_PATH + "/src/test/resources/TestData.json";
    public static final String TEST_REPORT_FILE_PATH = PROJECT_PATH + "/src/test/resources/test-output/CustomTestReport.html";
    public static final String TEST_REPORT_SCREENSHOTS_DIR = PROJECT_PATH + "/src/test/resources/test-output/screenshots/";
    public static final String TEST_CONFIG_FILE_PATH = PROJECT_PATH + "/src/test/resources/config.properties";

//    Page titles
    public static final String HOME_PAGE_TITLE = "Office Supplies, Stationery & Office Furniture at the Lowest Prices | Officeworks";

//    Test Data file constants
    public static final String LOGIN_CREDENTIALS = "LoginCredentials";
    public static final String VALID_USER = "ValidUser";
    public static final String INVALID_USER = "InvalidUser";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";
}
