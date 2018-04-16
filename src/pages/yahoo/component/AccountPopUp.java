package pages.yahoo.component;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.yahoo.BasePage;

public class AccountPopUp extends BasePage {
    @FindBy(css = "#uh-as-email")
    private WebElement userName;

    @FindBy(css = "#uh-signout")
    private WebElement logout;

    public AccountPopUp(WebDriver driver) {
        super(driver);
    }

    public String getUserEMail() {
        return new WebDriverWait(wd, 10000)
                .until(ExpectedConditions.visibilityOf(userName)).getText();
    }

    @Step
    public void logOut() {
        WebElement popUp = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#uh-signout")));
        logout.click();
    }


}