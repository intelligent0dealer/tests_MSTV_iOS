package setup;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

public class SetupConfigSimulator {
    public AppiumDriver<MobileElement> driver;

    public SetupConfigSimulator() {
        URL url;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to connect to remote device");
        }
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "iOS");
        cap.setCapability("platformVersion", "14.5");
        cap.setCapability("deviceName", "iPhone 12");
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("clearSystemFiles","true");
        cap.setCapability("clearKeychains","true");
        cap.setCapability("app","/Users/intdeal/Library/Developer/Xcode/DerivedData/Motorsport.tv-fqfqnjwijzvtdgbivkgylmayjcru/Build/Products/Debug-iphonesimulator/Motorsport.tv.app");
        this.driver = new AppiumDriver<MobileElement>(url,cap);
        openAppiumSession();
    }

    public void openAppiumSession() {
        WebDriverRunner.setWebDriver(this.driver);
        this.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Configuration.screenshots = false;
        Configuration.timeout = 30_000;

    }


}
