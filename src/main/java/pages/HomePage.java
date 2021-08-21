package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends PageObject {
    LocalizedStringStorage stringStorage = new LocalizedStringStorage();

    private final Locale appLocale;

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = getLocale();
    }

    private Locale getLocale() {
        profileButton.shouldBe(Condition.visible);
        String homeButton = $(By.xpath("//XCUIElementTypeTabBar[@name=\"Tab Bar\"]/XCUIElementTypeButton[1]")).getAttribute("name");
        switch (homeButton) {
            case ("Главная"): return Locale.RU;
            case ("Home"): return Locale.EN;
            case ("Accueil"): return Locale.FR;
            default: throw new IllegalArgumentException("WTF?!");
        }
    }

    public SelenideElement profileButton = $(By.xpath("//XCUIElementTypeNavigationBar[@name=\"Motorsport_tv.HomeView\"]/XCUIElementTypeButton[2]"));


    public ProfilePage openProfile() {
        profileButton.click();
        return new ProfilePage(appLocale,stringStorage,driver);
    }
    public MyFeedPage openMyFeed() {
        $(By.name(stringStorage.myFeedButton(appLocale))).click();
        return new MyFeedPage(appLocale,stringStorage,driver);
    }
    public ChannelPage openChannelPage() {
        $(By.name(stringStorage.seeAllButton(appLocale))).click();
        return new ChannelPage(appLocale,stringStorage,driver);
    }
    public LivestreamPage openLivestreamTab() {
        $(By.name(stringStorage.livestreamTab(appLocale))).click();
        return new LivestreamPage(appLocale,stringStorage,driver);
    }
    public PayPerViewEpisodePage openPPV() {
        $(By.name("PPV (don't touch IN TOP CAROUSEL EU REGION)")).click();
        return new PayPerViewEpisodePage(appLocale,stringStorage,driver);
    }


}
