package core.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    @Attachment(value="Screenshot on failure", type="png")
    public static byte[] attachToAllure(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void saveToFile(WebDriver driver, String testName){
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String folderName = System.getProperty("user.dir")+"/screenshots";
        String fileName = testName + System.currentTimeMillis() + ".pgn";
        String outputPath = folderName + "/"+fileName;
        try {
            Files.copy(scr.toPath(), Paths.get(outputPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void captureFailureScreenshot(WebDriver driver, String testName){
        attachToAllure(driver);
        saveToFile(driver,testName);
    }
}
