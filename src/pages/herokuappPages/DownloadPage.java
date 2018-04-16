package pages.herokuappPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class DownloadPage extends BasePage {
    WebDriverWait wait;
    @FindBy(css = "#file-upload")
    private WebElement uploadButton;

    @FindBy(css = "#file-submit")
    private WebElement submitButton;

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public DownloadPage open() {
        wd.get("https://the-internet.herokuapp.com/upload");
        return this;
    }

    @Step
    public UploadResultPage uploadFileAndSubmit(String filepath) {
        File file = new File(filepath);
        uploadButton.sendKeys(filepath);
        submitButton.click();
        WebElement uploadFIle = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#uploaded-files")));
        return new UploadResultPage(wd);
    }
}
