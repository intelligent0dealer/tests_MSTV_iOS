package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import com.codeborne.selenide.Condition;
import fixture.UserConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.dismiss;

public class LivestreamPage extends PageObject {
    private final LocalizedStringStorage stringStorage;
    private final Locale appLocale;

    public LivestreamPage(LocaleInfo.Locale locale, LocalizedStringStorage localizedStringStorage, AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = locale;
        stringStorage = localizedStringStorage;
    }
    public LivestreamPage checkNameAndStatusOfLivestream() {
        $(By.name("Present (Autotests)")).shouldBe(Condition.visible);
        $(By.className("XCUIElementTypeOther")).$(By.name(stringStorage.liveNowStatus(appLocale)))
       // $(By.xpath("(//XCUIElementTypeStaticText[@name="+"\""+stringStorage.liveNowStatus(appLocale)+"\"][2])"))
                .shouldBe(Condition.visible.because("Status of Livestream not LIVENOW"));
        return this;
    }
    public String getIdOfLiveDependingOnRegion() {
        return UserConstants.idOfLiveNowStream(appLocale);
    }
}
