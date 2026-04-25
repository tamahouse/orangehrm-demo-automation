package base;

import core.config.ConfigLoader;
import core.driver.DriverFactory;
import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;

public class BaseTest {


    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        System.out.println("env=" + System.getProperty("env"));
        System.out.println("browser=" + System.getProperty("browser"));
        System.out.println("remoteUrl=" + System.getProperty("remoteUrl"));
        String browser = System.getProperty("browser","chrome");
        WebDriver driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
        String url = ConfigLoader.get("baseUrl");
        driver.get(url);
        System.out.println(">>> BEFORE METHOD RUN");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverManager.quit();
    }

}
