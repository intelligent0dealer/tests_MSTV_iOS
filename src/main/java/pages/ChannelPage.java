package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ChannelPage extends PageObject {
    private final LocalizedStringStorage stringStorage;
    private final Locale appLocale;

    public ChannelPage(LocaleInfo.Locale locale, LocalizedStringStorage localizedStringStorage, AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = locale;
        stringStorage = localizedStringStorage;
    }
    public SignInPage pressAddToMyFeed() {
        $(By.name(stringStorage.addToMyFeedButton(appLocale))).click();
        return new SignInPage(appLocale,stringStorage,driver);
    }
    public HomePage pressCloseButtonToHome() {
        $(By.xpath("//XCUIElementTypeApplication[@name=\"Motorsport.tv\"]" +
                "/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")).click();
        return new HomePage(driver);
    }

}
