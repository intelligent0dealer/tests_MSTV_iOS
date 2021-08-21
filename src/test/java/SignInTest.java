import fixture.UserConstants;
import org.testng.annotations.*;
import pages.HomePage;
import setup.SetupConfigSimulator;



public class SignInTest {
    SetupConfigSimulator setupConfigSimulator = new SetupConfigSimulator();
    HomePage homePage = new HomePage(setupConfigSimulator.driver);


    @BeforeMethod
    public void open() {
        setupConfigSimulator.driver.executeScript("mobile: clearKeychains");
        setupConfigSimulator.driver.launchApp();
    }

    @Test
    public void signInFromProfile() {
        homePage.openProfile()
                .tapSignInButton()
                .performLoginProcess(UserConstants.EMAIL_FOR_SIGNINS,UserConstants.PASS_FOR_ALL_TESTS)
                .checkSignInWasOk();
    }
    @Test
    public void signInFromFeedTab() {
        homePage.openMyFeed()
                .tapSignInButton()
                .performLoginProcessFromFeedTab(UserConstants.EMAIL_FOR_SIGNINS,UserConstants.PASS_FOR_ALL_TESTS)
                .openProfileFromFeed()
                .checkSignInWasOk();
    }
    @Test
    public void signInFromAddToMyFeedButton() {
        homePage.openChannelPage()
                .pressAddToMyFeed()
                .performLoginProcessFromAddToMyFeed(UserConstants.EMAIL_FOR_SIGNINS,UserConstants.PASS_FOR_ALL_TESTS)
                .pressCloseButtonToHome()
                .openProfile()
                .checkSignInWasOk();
    }
    @Test
    public void signInFromRegistration() {
        homePage.openProfile()
                .openSignUpPage()
                .pressSignInFromSignUp()
                .performLoginProcess(UserConstants.EMAIL_FOR_SIGNINS,UserConstants.PASS_FOR_ALL_TESTS)
                .checkSignInWasOk();
    }

    @AfterMethod
    public void clearKeychains() {
        setupConfigSimulator.driver.closeApp();
    }

}
