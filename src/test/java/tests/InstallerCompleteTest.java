package tests;

import base.BaseTest;
import flows.InstallerFlow;
import org.testng.annotations.Test;
import org.testng.Assert;

public class InstallerCompleteTest extends BaseTest {

    @Test(groups = {"regression"})
    public void doGoToNextStepFromLicenceAcceptance(){
        new InstallerFlow().completeInstall();

        Assert.assertTrue(false);
    }
}
