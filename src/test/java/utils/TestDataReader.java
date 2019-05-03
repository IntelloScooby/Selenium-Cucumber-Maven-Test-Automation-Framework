package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.HashMap;

import static utils.Constants.*;

public class TestDataReader {

    private JsonParser parser = new JsonParser();
    private String testDataFilePath = Paths.get(System.getProperty("user.dir")) + "/src/test/resources/TestData.json";

    public HashMap<String, String> getLoginDetails(String loginType) {
        HashMap<String, String> loginDetails = new HashMap<>();
        Object object;

        {
            try {
                object = parser.parse(new FileReader(testDataFilePath));
                JsonObject allUserDetails = (JsonObject) ((JsonObject) object).get(LOGIN_CREDENTIALS);
                JsonObject user = (JsonObject) allUserDetails.get(loginType);
                loginDetails.put(USERNAME, user.get(USERNAME).getAsString());
                loginDetails.put(PASSWORD, user.get(PASSWORD).getAsString());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return loginDetails;
    }
}