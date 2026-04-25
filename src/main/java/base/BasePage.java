package base;

import core.config.TimeoutConfig;
import core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage (){
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(TimeoutConfig.mediumTimeout()));
        System.out.println(">>> BASE PAGE CONSTRUCTOR");
    }

    protected void click(By by){
        this.driver.findElement(by).click();
    }

    protected boolean isSelected(By by){
        return this.driver.findElement(by).isSelected();
    }

    protected void waitForUrlEndWith(String path){
        wait.until(ExpectedConditions.urlMatches(".*/"+path+"/?(\\?.*)?$"));
    }

}
