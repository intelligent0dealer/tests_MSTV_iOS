package subscription;

import api.TestAPI;
import fixture.UserConstants;
import org.testng.annotations.Test;
import pages.HomePage;
import setup.SetupConfigSimulator;

public class SubscriptionFromRegistration {
    SetupConfigSimulator setupConfigSimulator = new SetupConfigSimulator();
    HomePage homePage = new HomePage(setupConfigSimulator.driver);
    TestAPI testAPI = new TestAPI();

    @Test
    public void registrationFromProfile() {
        homePage.openProfile()
                .openSignUpPage()
                .regProcess(UserConstants.EMAIL_FOR_REGISTRATION, UserConstants.PASS_FOR_ALL_TESTS)
                .completeRegAndConfirmEmail(testAPI)
                .chooseMonthlyPlan();
    }
}
