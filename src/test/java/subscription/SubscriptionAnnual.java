package subscription;

import fixture.UserConstants;
import org.testng.annotations.Test;
import pages.HomePage;
import setup.SetupConfigSimulator;

public class SubscriptionAnnual {
    SetupConfigSimulator setupConfigSimulator = new SetupConfigSimulator();
    HomePage homePage = new HomePage(setupConfigSimulator.driver);


    @Test
    public void buySubscriptionFromProfileAnnual() {
        homePage.openProfile()
                .tapSignInButton()
                .performLoginProcess(UserConstants.EMAIL_FOR_SIGNINS,UserConstants.PASS_FOR_ALL_TESTS)
                .checkSignInWasOk()
                .tapOnSubscription()
                .chooseAnnualPlan();
    }
}
