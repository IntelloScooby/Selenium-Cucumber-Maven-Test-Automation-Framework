package utils;

import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static utils.Constants.*;

public class TestDataReader {

    private JsonParser parser = new JsonParser();

    public HashMap<String, String> getLoginDetails(String loginType) {
        HashMap<String, String> loginDetails = new HashMap<>();
        Object object;

        {
            try {
                object = parser.parse(new FileReader(TEST_DATA_FILE_PATH));
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