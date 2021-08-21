import api.TestAPI;
import fixture.UserConstants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EpisodePage;
import pages.HomePage;
import setup.SetupConfigSimulator;

public class LivestreamTest {
    SetupConfigSimulator setupConfigSimulator = new SetupConfigSimulator();
    HomePage homePage = new HomePage(setupConfigSimulator.driver);
    TestAPI testAPI = new TestAPI();

    @BeforeMethod
    public void open() {
        setupConfigSimulator.driver.executeScript("mobile: clearKeychains");
        setupConfigSimulator.driver.launchApp();
    }

    @Test
    public void checkThatLivestreamIsLiveNow() {
        String idOfEpisode =
        homePage.openLivestreamTab()
                .checkNameAndStatusOfLivestream()
                .getIdOfLiveDependingOnRegion();
        testAPI.getCheckThatLivestreamIsLiveNow(idOfEpisode);
    }
    @Test
    public void checkFutureLivestreamStatus() {
        EpisodePage episodePage =
        homePage.openMyFeed()
                .tapSignInButton()
                .performLoginProcessFromFeedTab(UserConstants.EMAIL_FOR_LIVESTREAM,UserConstants.PASS_FOR_ALL_TESTS)
                .openFutureLivestream()
                .checkLiveBadgeFuture();
        String DateFromApi = episodePage.parseDateToOneFormat(testAPI.getInfoAboutLivestreamEpisode(UserConstants.ID_OF_FUTURE_LIVESTREAM));
        String DateFromApp = episodePage.parseDateFromApiToApp(DateFromApi);
        System.out.println(DateFromApp);
        episodePage.checkDateOfFutureLivestreamShowsCorrect(DateFromApp);

    }
    @AfterMethod
    public void tearDown() {
        setupConfigSimulator.driver.closeApp();
    }
}
