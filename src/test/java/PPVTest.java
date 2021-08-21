import api.TestAPI;
import fixture.UserConstants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import setup.SetupConfigPhys;
import setup.SetupConfigSimulator;

public class PPVTest {
    SetupConfigPhys setupConfigPhys = new SetupConfigPhys();
    HomePage homePage = new HomePage(setupConfigPhys.driver);
    TestAPI testAPI = new TestAPI();
    @BeforeMethod
    public void startApp() {
        setupConfigPhys.driver.launchApp();
    }

    @Test
    public void rentPPV() {
        homePage.openProfile()
                .tapSignInButton()
                .performLoginProcess(UserConstants.EMAIL_FOR_SIGNINS,UserConstants.PASS_FOR_ALL_TESTS)
                .chooseEuropeRegion()
                .clickDoneButtonInProfile()
                .openPPV()
                .tapRentByLoginUser();
    }
    @Test
    public void buyPPV() {
        homePage.openProfile()
                .tapSignInButton()
                .performLoginProcess(UserConstants.EMAIL_FOR_SIGNINS,UserConstants.PASS_FOR_ALL_TESTS)
                .chooseEuropeRegion()
                .clickDoneButtonInProfile()
                .openPPV()
                .tapBuyByLoginUser();
    }
    @AfterMethod
    public void tearDown() {
        setupConfigPhys.driver.closeApp();
    }
}
