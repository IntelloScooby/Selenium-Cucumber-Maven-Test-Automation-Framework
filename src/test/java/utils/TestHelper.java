package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.Constants.TEST_REPORT_SCREENSHOTS_DIR;

public class TestHelper {

    public void waitForPageToLoad(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(pageLoadCondition);
    }

    public String takeScreenshot(WebDriver driver) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
        String fileName = timeStamp + ".jpg";
        String filePath = TEST_REPORT_SCREENSHOTS_DIR + fileName;

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath), true);
        } catch (IOException e) {
            System.out.println("Error copy screenshots!");
            e.printStackTrace();
        }
        return fileName;
    }

}
