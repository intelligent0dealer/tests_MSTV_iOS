package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PayPerViewEpisodePage extends PageObject {
    private final LocalizedStringStorage stringStorage;
    private final Locale appLocale;

    public PayPerViewEpisodePage(LocaleInfo.Locale locale, LocalizedStringStorage localizedStringStorage, AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = locale;
        stringStorage = localizedStringStorage;
    }

    public SignUpPage tapRentByNotLoginUser() {
        $(By.xpath("//XCUIElementTypeButton[@name=\"Rent HD \"]")).click();
        return new SignUpPage(appLocale,stringStorage,driver);
    }
    public PayPerViewEpisodePage tapRentByLoginUser() {
        $(By.xpath("//XCUIElementTypeButton[@name=\"Rent HD \"]")).click();
        return this;
    }

    public SignUpPage tapBuyByNotLoginUser() {
        $(By.xpath("//XCUIElementTypeButton[@name=\"Buy and Watch \"]")).click();
        return new SignUpPage(appLocale,stringStorage,driver);
    }
    public PayPerViewEpisodePage tapBuyByLoginUser() {
        $(By.xpath("//XCUIElementTypeButton[@name=\"Buy and Watch \"]")).click();
        return this;
    }

    public SignUpPage tapSubscribeByNotLoginUser() {
        $(By.name("Subscribe and Watch")).click();
        return new SignUpPage(appLocale,stringStorage,driver);
    }
    public ProfilePage chooseFreePlan() {
        $(By.name(stringStorage.freePlan(appLocale))).click();
        return new ProfilePage(appLocale,stringStorage,driver);
    }
    public ProfilePage chooseFreePlanLocaleEn() {
        $(By.name("Free")).click();
        return new ProfilePage(appLocale,stringStorage,driver);
    }

}
