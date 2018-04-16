package pages.herokuappPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadResultPage extends BasePage {


    @FindBy(css = "#uploaded-files")
    private WebElement uploadFileName;

    public UploadResultPage(WebDriver driver) {
        super(driver);
    }

    public String getUploadFileName() {
        return uploadFileName.getText();
    }
}
