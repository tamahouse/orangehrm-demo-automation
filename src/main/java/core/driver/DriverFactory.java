package core.driver;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    static boolean isHeadless;

    public static WebDriver createDriver(String browser) {
        isHeadless = System.getenv("CI") != null;
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("-headless=new");
                }
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

    }
}
