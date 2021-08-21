package pages;

import LocaleInfo.Locale;
import LocaleInfo.LocalizedStringStorage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SubscriptionPage extends PageObject {
    private final LocalizedStringStorage stringStorage;
    private final Locale appLocale;

    public SubscriptionPage(LocaleInfo.Locale locale, LocalizedStringStorage localizedStringStorage, AppiumDriver<MobileElement> driver) {
        super(driver);
        appLocale = locale;
        stringStorage = localizedStringStorage;
    }
    public ProfilePage chooseFreePlan() {
        $(By.name(stringStorage.freePlan(appLocale))).click();
        return new ProfilePage(appLocale,stringStorage,driver);
    }
    public MyFeedPage chooseFreePlanFromFeed() {
        $(By.name(stringStorage.freePlan(appLocale))).click();
        return new MyFeedPage(appLocale,stringStorage,driver);
    }
    public void chooseMonthlyPlan() {
        $(By.name(stringStorage.monthlyPlan(appLocale))).click();
    }
    public void chooseAnnualPlan() {
        $(By.name(stringStorage.annualPlan(appLocale))).click();
    }
}
