package setup;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SetupConfigPhys {
        public AppiumDriver<MobileElement> driver;

        public SetupConfigPhys() {
            URL url;
            try {
                url = new URL("http://127.0.0.1:4723/wd/hub");
            } catch (MalformedURLException e) {
                throw new RuntimeException("Unable to connect to remote device");
            }
            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability("platformName", "iOS");
            cap.setCapability("platformVersion", "14.6");
            cap.setCapability("deviceName", "QaIphone");
            cap.setCapability("udid","0564f593ff13f53f4b65b2ec45d31cfd60fbddf0");
            cap.setCapability("automationName", "XCUITest");
            cap.setCapability("noReset","false");
            cap.setCapability("resetOnSessionStartOnly","true");
            cap.setCapability("clearSystemFiles","true");
            cap.setCapability("fullReset","true");
            cap.setCapability("app","/Users/intdeal/Library/Developer/Xcode/DerivedData/Motorsport.tv-fqfqnjwijzvtdgbivkgylmayjcru/Build/Products/Debug-iphoneos/Motorsport.tv.app");
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
