package listeners;

import core.driver.DriverManager;
import core.utils.ScreenshotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        WebDriver driver = DriverManager.getDriver();
        String testName = result.getTestName();
        ScreenshotUtils.captureFailureScreenshot(driver,testName);
    }
}
