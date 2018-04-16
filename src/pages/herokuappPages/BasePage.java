package pages.herokuappPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public abstract class BasePage extends DriverFactory {

    public BasePage(WebDriver driver) {
        this.wd = driver;
        PageFactory.initElements(driver, this);
    }
}