package subscription;

import api.TestAPI;
import fixture.UserConstants;
import org.testng.annotations.Test;
import pages.HomePage;
import setup.SetupConfigSimulator;

public class SubscriptionFromPPVSubscribe {
    SetupConfigSimulator setupConfigSimulator = new SetupConfigSimulator();
    HomePage homePage = new HomePage(setupConfigSimulator.driver);
    TestAPI testAPI = new TestAPI();

    @Test
    public void registrationFromPPVBySubscribeButton() {
        homePage.openProfile()
                .chooseEuropeRegion()
                .clickDoneButtonInProfile()
                .pullToRefresh();
        homePage.openPPV()
                .tapSubscribeByNotLoginUser()
                .regProcessForEurope(UserConstants.EMAIL_FOR_REGISTRATION, UserConstants.PASS_FOR_ALL_TESTS)
                .completeRegAndConfirmEmailForEurope(testAPI);
                // choose Monthly Plan for EU Locale
    }
}
