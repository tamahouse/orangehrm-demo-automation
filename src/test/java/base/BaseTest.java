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


    @BeforeMethod
    public void setUp(ITestContext context){
        String browser = System.getProperty("browser","chrome");
        WebDriver driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
        String url = ConfigLoader.get("baseUrl");
        driver.get(url);
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quit();
    }

}
