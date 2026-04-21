package pages;

import base.BasePage;
import core.constants.UrlPaths;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstallerLicenceAcceptancePage extends BasePage {

    private final By acceptanceCheckboxLabel = By.xpath("//div[@class='oxd-checkbox-wrapper']//label");
    private final By acceptanceCheckboxInput = By.xpath("//div[@class='oxd-checkbox-wrapper']//input");
    private final By nextButton = By.xpath("//div[@class='oxd-form-actions orangehrm-installer-page-action']//button[@type='submit']");

    public InstallerLicenceAcceptancePage(){
        super();
    }

    private void clickAcceptanceCheckboxLabel(){
        click(acceptanceCheckboxLabel);
    }

    private void clickNextButton(){
        click(nextButton);
    }

    private void checkAcceptanceCheckbox(){
        if(!isSelected(acceptanceCheckboxInput)){
            this.clickAcceptanceCheckboxLabel();
        }
    }

    private void uncheckAcceptanceCheckbox(){
        if(isSelected(acceptanceCheckboxInput)){
            this.clickAcceptanceCheckboxLabel();
        }
    }

    private void waitForPage(){
        this.waitForUrlEndWith(UrlPaths.INSTALLER_LICENCE_ACCEPTANCE_PATH);
    }

    @Step("Check the term and condition checkbox and click next button")
    public void acceptLicenceAndNext(){
        this.waitForPage();
        this.checkAcceptanceCheckbox();
        this.clickNextButton();
    }




}
