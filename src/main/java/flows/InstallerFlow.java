package flows;

import core.driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.InstallerLicenceAcceptancePage;
import pages.InstallerWelcomePage;

import java.sql.Driver;

public class InstallerFlow {

    protected WebDriver driver;

    public InstallerFlow (){
        this.driver = DriverManager.getDriver();
    }

    @Step("Process the installer flow until completed")
    public void completeInstall(){
        new InstallerWelcomePage().next();
        new InstallerLicenceAcceptancePage().acceptLicenceAndNext();
    }
}
