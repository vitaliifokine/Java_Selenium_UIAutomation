package pages.ebayPages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
    @FindBy(css = "#gh-ug")
    WebElement userName;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public String getUser() {
        WebElement waitRegistration = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#gh-ug")));
        return userName.getText();
    }
}