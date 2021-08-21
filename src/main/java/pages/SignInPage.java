package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage extends PageObject {
    private final LocalizedStringStorage stringStorage;
    private final Locale appLocale;

    public SignInPage(LocaleInfo.Locale locale, LocalizedStringStorage localizedStringStorage, AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = locale;
        stringStorage = localizedStringStorage;
    }
    public SelenideElement mailField = $(By.className("XCUIElementTypeTextField"));
    public SelenideElement passField = $(By.className("XCUIElementTypeSecureTextField"));

    public ProfilePage performLoginProcess(String email,String password) {
    mailField.sendKeys(email);
    passField.sendKeys(password);
    $(By.xpath("//XCUIElementTypeButton[@name="+"\""+stringStorage.signInButton(appLocale)+"\"]")).click();
    return new ProfilePage(appLocale,stringStorage,driver);
    }
    public MyFeedPage performLoginProcessFromFeedTab(String email,String password) {
    mailField.sendKeys(email);
    passField.sendKeys(password);
    $(By.xpath("//XCUIElementTypeButton[@name="+"\""+stringStorage.signInButton(appLocale)+"\"]")).click();
    return new MyFeedPage(appLocale,stringStorage,driver);
    }
    public ChannelPage performLoginProcessFromAddToMyFeed(String email,String password) {
    mailField.sendKeys(email);
    passField.sendKeys(password);
    $(By.xpath("//XCUIElementTypeButton[@name="+"\""+stringStorage.signInButton(appLocale)+"\"]")).click();
    return new ChannelPage(appLocale,stringStorage,driver);
    }
    public SignUpPage openSignUpPage() {
        $(By.name(stringStorage.signUpButton(appLocale))).click();
        return new SignUpPage(appLocale,stringStorage,driver);
    }
    public SignUpPage pressSignUpFromSignIn() {
        $(By.xpath("//XCUIElementTypeButton[@name="+"\""+stringStorage.signUpButton(appLocale)+"\"]")).click();
        return new SignUpPage(appLocale,stringStorage,driver);
    }
}
