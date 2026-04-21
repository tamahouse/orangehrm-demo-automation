package pages;

import base.BasePage;
import core.constants.UrlPaths;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstallerWelcomePage extends BasePage {

    private final By nextButton = By.xpath("//div[@class='oxd-form-actions orangehrm-installer-page-action']//button[@type='submit']");

    public InstallerWelcomePage (){
        super();
    }

    private void clickNextButton(){
        this.click(nextButton);
    }

    private void waitForPage(){
        this.waitForUrlEndWith(UrlPaths.WELCOME_PATH);
    }

    @Step("Click next button on installer welcome page")
    public void next(){
        this.waitForPage();
        this.clickNextButton();
    }
}
