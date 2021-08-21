package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import api.TestAPI;
import com.codeborne.selenide.Condition;
import fixture.UserConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignUpPage extends PageObject {
    private final LocalizedStringStorage stringStorage;
    private final Locale appLocale;

    public SignUpPage(LocaleInfo.Locale locale, LocalizedStringStorage localizedStringStorage, AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = locale;
        stringStorage = localizedStringStorage;
    }
    public SignInPage pressSignInFromSignUp() {
        $(By.xpath("//XCUIElementTypeButton[@name="+"\""+stringStorage.signInFromSignUp(appLocale)+"\"]")).click();
        return new SignInPage(appLocale,stringStorage,driver);
    }
    public SignUpPage regProcess(String email, String pass) {
        $(By.className("XCUIElementTypeTextField")).sendKeys(email);
        $$(By.className("XCUIElementTypeSecureTextField")).findBy(Condition.value(UserConstants.passwordField(appLocale))).sendKeys(pass);
        $$(By.className("XCUIElementTypeSecureTextField")).findBy(Condition.value(UserConstants.confirmPasswordField(appLocale))).sendKeys(pass);
        $(By.name("eye")).click();
        $(By.name(stringStorage.continueButton(appLocale))).click();
        return this;
    }
    public SignUpPage regProcessForEurope(String email, String pass) {
        $(By.className("XCUIElementTypeTextField")).sendKeys(email);
        $$(By.className("XCUIElementTypeSecureTextField")).findBy(Condition.value("Password")).sendKeys(pass);
        $$(By.className("XCUIElementTypeSecureTextField")).findBy(Condition.value("Confirm Password")).sendKeys(pass);
        $(By.name("eye")).click();
        $(By.name("Continue")).click();
        return this;
    }
    public SignUpPage regProcessWithActiveCheckbox(String email, String pass) {
        $(By.className("XCUIElementTypeTextField")).sendKeys(email);
        $$(By.className("XCUIElementTypeSecureTextField")).findBy(Condition.value(UserConstants.passwordField(appLocale))).sendKeys(pass);
        $$(By.className("XCUIElementTypeSecureTextField")).findBy(Condition.value(UserConstants.confirmPasswordField(appLocale))).sendKeys(pass);
        $(By.name("eye")).click();
        $(By.name(stringStorage.checkBoxText(appLocale))).click();
        $(By.name(stringStorage.continueButton(appLocale))).click();
        return this;
    }
    public SubscriptionPage completeRegAndConfirmEmail(TestAPI testAPI) {
        $(By.name(stringStorage.openMailAppAndConfirmButton(appLocale))).shouldBe(Condition.visible.because("confirm button not found"));
        $(By.name(stringStorage.skipConfirmButton(appLocale))).shouldBe(Condition.visible.because("skip confirm button not found"));
        testAPI.postConfirmEmailForNewUser();
        System.out.println("mail was confirm");
        testAPI.postCheckThatEmailConfirmed();
        return new SubscriptionPage(appLocale,stringStorage,driver);
    }
    public PayPerViewEpisodePage completeRegAndConfirmEmailForEurope(TestAPI testAPI) {
        $(By.name("Open email app")).shouldBe(Condition.visible.because("confirm button not found"));
        $(By.name("Sign Out, I’ll confirm later")).shouldBe(Condition.visible.because("skip confirm button not found"));
        testAPI.postConfirmEmailForNewUser();
        System.out.println("mail was confirm");
        testAPI.postCheckThatEmailConfirmed();
        return new PayPerViewEpisodePage(appLocale,stringStorage,driver);
    }

}
