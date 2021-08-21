package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends PageObject {
    private final LocalizedStringStorage stringStorage;
    private final Locale appLocale;

    public ProfilePage(LocaleInfo.Locale locale, LocalizedStringStorage localizedStringStorage, AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = locale;
        stringStorage = localizedStringStorage;
    }

    public SignInPage tapSignInButton() {
        $(By.name(stringStorage.signInButton(appLocale))).click();
        return new SignInPage(appLocale,stringStorage,driver);
    }
    public ProfilePage checkSignInWasOk() {
        $(By.name(stringStorage.subscriptionView(appLocale))).shouldBe(Condition.visible);
        return new ProfilePage(appLocale,stringStorage,driver);
    }
    public ProfilePage checkSignInWasOkForEnLocale() {
        $(By.name("Subscription")).shouldBe(Condition.visible);
        return new ProfilePage(appLocale,stringStorage,driver);
    }
    public SignUpPage openSignUpPage() {
        $(By.name(stringStorage.signUpButton(appLocale))).click();
        return new SignUpPage(appLocale,stringStorage,driver);
    }
    public ProfilePage chooseEuropeRegion() {
        $(By.name(stringStorage.region(appLocale))).click();
        $(By.name("EUROPE")).click();
        $(By.name(stringStorage.doneButtonAtTop(appLocale))).click();
        return this;
    }
    public HomePage clickDoneButtonInProfile() {
        $(By.name("Done")).click();
        return new HomePage(driver);
    }

    public SubscriptionPage tapOnSubscription() {
        $(By.name(stringStorage.subscriptionView(appLocale))).click();
        return new SubscriptionPage(appLocale,stringStorage,driver);
    }



}
