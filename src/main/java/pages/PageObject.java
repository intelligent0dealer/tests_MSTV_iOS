package pages;

import com.codeborne.selenide.Condition;
import fixture.UserConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public abstract class PageObject {
    public AppiumDriver<MobileElement> driver;
    public PageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public String parseDateToOneFormat(String datetime) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(datetime, ISO_DATE_TIME);
        ZonedDateTime newZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Yekaterinburg"));
        String formattedDateTime = newZonedDateTime.format(DateTimeFormatter.ofPattern("MMM d, HH:mm").withLocale(java.util.Locale.US));
        System.out.println(formattedDateTime);
        return formattedDateTime;
    }
    public void swipeEpisode() {
        $(By.name("clock")).shouldBe(Condition.enabled);
        new TouchAction(this.driver)
                .press(PointOption.point(140,140))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(140,740))
                .perform().release();
    }
    public void pullToRefresh() {
        new TouchAction(this.driver)
                .press(PointOption.point(200,200))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(10000)))
                .moveTo(PointOption.point(200,800))
                .perform().release();
    }
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: swipe", scrollObject);
    }

}

