package pages.yahoo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.yahoo.component.AccountPopUp;

public class YahooMainPage extends BasePage {
    @FindBy(css = "#uh-avatar")
    private WebElement userButton;

    @FindBy(css = "#uh-signin")
    private WebElement signIn;

    @FindBy(css = "#ODEP4WQ7GFCHDHMVVLUSXVULH5 > button > img")
    private WebElement deleteUser;

    public YahooMainPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public AccountPopUp openAccountPopUp() {
        WebElement popUp = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#uh-avatar")));
        userButton.click();
        return new AccountPopUp(wd);
    }

    @Step
    public YahooMainPage cleanData() {
        new AccountPopUp(wd).logOut();
        WebElement popUp = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.visibilityOf(signIn));
        signIn.click();
        WebElement element = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.visibilityOf(deleteUser));
       deleteUser.click();
       return this;
    }
}
