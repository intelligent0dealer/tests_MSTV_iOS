package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public class MyFeedPage extends PageObject  {
    private final LocalizedStringStorage stringStorage;
    private final Locale appLocale;

    public MyFeedPage (LocaleInfo.Locale locale, LocalizedStringStorage localizedStringStorage, AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = locale;
        stringStorage = localizedStringStorage;
    }
    public SignInPage tapSignInButton() {
        $(By.name(stringStorage.signInButton(appLocale))).click();
        return new SignInPage(appLocale,stringStorage,driver);
    }
    public ProfilePage openProfileFromFeed() {
        $(By.xpath("//XCUIElementTypeNavigationBar[@name=\"Motorsport_tv.FeedView\"]/XCUIElementTypeButton[2]")).click();
        return new ProfilePage(appLocale,stringStorage,driver);
    }
    public EpisodePage openFutureLivestream() {
        $(By.name(stringStorage.dateOfTestLive(appLocale))).shouldBe(Condition.visible.because("Live Not Found")).click();
        return new EpisodePage(appLocale,stringStorage,driver);
    }
    public SignUpPage openSignUpPage() {
        $(By.name(stringStorage.signUpButton(appLocale))).click();
        return new SignUpPage(appLocale,stringStorage,driver);
    }
    public void checkEmptyFeedAfterLogin() {
        $(By.name(stringStorage.noFeed(appLocale))).shouldBe(Condition.visible);
    }



}
