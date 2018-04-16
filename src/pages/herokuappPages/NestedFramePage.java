package pages.herokuappPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramePage extends BasePage {
    public NestedFramePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public NestedFramePage openNestedFrames() {
        wd.get("http://the-internet.herokuapp.com/nested_frames");
        return this;
    }

    @Step
    public NestedFramePage switchToTopFrame() {
        wd.switchTo().frame("frame-top");
        return this;
    }

    @Step
    public NestedFramePage switchToMiddleFrame() {
        wd.switchTo().frame("frame-middle");
        return this;
    }

    @Step
    public String getTextFromFrame() {
        return  wd.findElement(By.id("content")).getText();
    }

}
