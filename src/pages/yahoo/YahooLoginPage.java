package pages.yahoo;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.yahoo.domain.User;

public class YahooLoginPage extends BasePage {
    @FindBy(css = "#uh-signin")
    private WebElement signIn;

    @FindBy(css = "#login-username")
    private WebElement loginName;

    @FindBy(css = "#login-passwd")
    private WebElement loginPassword;

    @FindBy(css = "#login-signin")
    private WebElement loginSign;

    public YahooLoginPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public YahooLoginPage open() {
        wd.get("https://www.yahoo.com/");
        return this;
    }

    @Step
    public YahooMainPage loginAs(User user) {
        signIn.click();
        new WebDriverWait(wd, 8000).until(ExpectedConditions.visibilityOf(loginName));
        loginName.sendKeys(user.getUsername());
        loginSign.click();
        new WebDriverWait(wd, 8000).until(ExpectedConditions.visibilityOf(loginPassword));
        loginPassword.sendKeys(user.getPassword());
        loginSign.click();
        return new YahooMainPage(wd);
    }
}