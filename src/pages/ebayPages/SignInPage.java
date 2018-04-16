package pages.ebayPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.yahoo.domain.User;

public class SignInPage extends BasePage {
    @FindBy(css = "#userid")
    WebElement userInput;

    @FindBy(css = "#pass")
    WebElement passwordInput;

    @FindBy(css = "#sgnBt")
    WebElement signIn;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public SignInPage openSignInPage() {
        wd.get("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2F");
        return this;
    }

    @Step
    public MainPage loginWithValidCredentials(User user) {
        userInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        signIn.click();
        return new MainPage(wd);
    }
}