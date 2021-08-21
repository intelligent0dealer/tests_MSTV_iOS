package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PremiumEpisodePage {
    SelenideElement premiumTriangle =  $(By.name("playerTimerBackground"));
    int TIME_TO_CHECK_PRE_ROLL_END_GLOBAL = 32000;
    int TIME_TO_CHECK_PRE_ROLL_END = 2000;

    public PremiumEpisodePage waitForAdsPreRollFinish() {
        try {
            int timerForCheck = 0;
            SelenideElement learnMore = $(By.name("Learn More"));
            SelenideElement mirrorBtn = $(By.name("mirrorButton"));
            while (learnMore.isEnabled() & !(mirrorBtn.isDisplayed() & timerForCheck < TIME_TO_CHECK_PRE_ROLL_END_GLOBAL)) {
                Thread.sleep(2000);
                timerForCheck +=TIME_TO_CHECK_PRE_ROLL_END;
            }
            mirrorBtn.shouldBe(Condition.visible);
            learnMore.shouldNotBe(Condition.visible);

        } catch (InterruptedException e) {
            System.out.println("too long ads mb?");
        }
        return this;
    }

}
