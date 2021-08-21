import DbUtils.DbUtils;
import api.TestAPI;
import fixture.UserConstants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import setup.SetupConfigSimulator;

public class RegistrationTest {
    SetupConfigSimulator setupConfigSimulator = new SetupConfigSimulator();
    HomePage homePage = new HomePage(setupConfigSimulator.driver);
    TestAPI testAPI = new TestAPI();
    DbUtils dbUtils = new DbUtils();

    @BeforeClass
    public void deleteUser() {
        setupConfigSimulator.driver.executeScript("mobile: clearKeychains");
        dbUtils.deleteUser(UserConstants.EMAIL_FOR_REGISTRATION);
    }

    @BeforeMethod
    public void open() {
        setupConfigSimulator.driver.executeScript("mobile: clearKeychains");
        setupConfigSimulator.driver.launchApp();
    }
    @Test
    public void registrationWithActiveCheckbox() {
        homePage.openProfile()
                .openSignUpPage()
                .regProcessWithActiveCheckbox(UserConstants.EMAIL_FOR_REGISTRATION,UserConstants.PASS_FOR_ALL_TESTS)
                .completeRegAndConfirmEmail(testAPI)
                .chooseFreePlan()
                .checkSignInWasOk();
    }

    @Test
    public void registrationFromProfile() {
        homePage.openProfile()
                .openSignUpPage()
                .regProcess(UserConstants.EMAIL_FOR_REGISTRATION,UserConstants.PASS_FOR_ALL_TESTS)
                .completeRegAndConfirmEmail(testAPI)
                .chooseFreePlan()
                .checkSignInWasOk();
    }

    @Test
    public void registrationFromSignInPage() {
        homePage.openProfile()
                .tapSignInButton()
                .pressSignUpFromSignIn()
                .regProcess(UserConstants.EMAIL_FOR_REGISTRATION,UserConstants.PASS_FOR_ALL_TESTS)
                .completeRegAndConfirmEmail(testAPI)
                .chooseFreePlan()
                .checkSignInWasOk();
    }

    @Test
    public void registrationFromFeedTab() {
        homePage.openMyFeed()
                .openSignUpPage()
                .regProcess(UserConstants.EMAIL_FOR_REGISTRATION,UserConstants.PASS_FOR_ALL_TESTS)
                .completeRegAndConfirmEmail(testAPI)
                .chooseFreePlanFromFeed()
                .checkEmptyFeedAfterLogin();
    }

    @Test
    public void registrationFromPPVByRent()  {
        homePage.openProfile()
                .chooseEuropeRegion()
                .clickDoneButtonInProfile()
                .pullToRefresh();
        homePage.openPPV()
                .tapRentByNotLoginUser()
                .regProcessForEurope(UserConstants.EMAIL_FOR_REGISTRATION,UserConstants.PASS_FOR_ALL_TESTS)
                .completeRegAndConfirmEmailForEurope(testAPI)
                .swipeEpisode();
        homePage.openProfile()
                .checkSignInWasOkForEnLocale();
    }

    @Test
    public void registrationFromPPVByBuyButton()  {
        homePage.openProfile()
                .chooseEuropeRegion()
                .clickDoneButtonInProfile()
                .pullToRefresh();
        homePage.openPPV()
                .tapBuyByNotLoginUser()
                .regProcessForEurope(UserConstants.EMAIL_FOR_REGISTRATION,UserConstants.PASS_FOR_ALL_TESTS)
                .completeRegAndConfirmEmailForEurope(testAPI)
                .swipeEpisode();
        homePage.openProfile()
                .checkSignInWasOkForEnLocale();
    }

    @Test
    public void registrationFromPPVBySubscribeButton() {
        homePage.openProfile()
                .chooseEuropeRegion()
                .clickDoneButtonInProfile()
                .pullToRefresh();
        homePage.openPPV()
                .tapSubscribeByNotLoginUser()
                .regProcessForEurope(UserConstants.EMAIL_FOR_REGISTRATION,UserConstants.PASS_FOR_ALL_TESTS)
                .completeRegAndConfirmEmailForEurope(testAPI)
                .chooseFreePlanLocaleEn()
                .swipeEpisode();
        homePage.openProfile()
                .checkSignInWasOkForEnLocale();
    }
    @Test
    public void registrationFromPremiumEpisode() {
        homePage.openEpisode // :TODO
                .
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        dbUtils.deleteUser(UserConstants.EMAIL_FOR_REGISTRATION);
        setupConfigSimulator.driver.closeApp();
    }
}
