package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import com.codeborne.selenide.Condition;
import fixture.UserConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public class EpisodePage extends PageObject {
    private final LocalizedStringStorage stringStorage;
    private final Locale appLocale;

    public EpisodePage(LocaleInfo.Locale locale, LocalizedStringStorage localizedStringStorage, AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = locale;
        stringStorage = localizedStringStorage;
    }
    public EpisodePage checkLiveBadgeFuture() {
        $(By.name("liveNowIconSmall")).shouldBe(Condition.enabled.because("Live Badge not found"));
        return this;
    }
    public String parseDateFromApiToApp(String datetime) {
        if (datetime.equals(UserConstants.DATE_OF_FUTURE_LIVE)) {
            return UserConstants.dateOfFutureLive(appLocale);
        }
        else {
            throw new IllegalArgumentException("not correct date");
        }
    }


    public void checkDateOfFutureLivestreamShowsCorrect(String datetime) {
        $(By.name(datetime)).shouldBe(Condition.visible.because("something with date"));
    }
}

