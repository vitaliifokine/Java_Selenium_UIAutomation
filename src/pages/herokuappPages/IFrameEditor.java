package pages.herokuappPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrameEditor extends BasePage {
    @FindBy(id = "tinymce")
    private WebElement editor;

    public IFrameEditor(WebDriver driver) {
        super(driver);
    }

    @Step
    public IFrameEditor openEditor() {
        wd.get("http://the-internet.herokuapp.com/tinymce");
        wd.switchTo().frame("mce_0_ifr");
        return this;
    }

    @Step
    public String getTextFromEditor() {
        WebElement popUp = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.visibilityOf(editor));
        return editor.getText();
    }

    @Step
    public IFrameEditor clearEditor() {
        editor.clear();
        return this;
    }

    @Step
    public IFrameEditor writeInEditor(String text) {
        editor.sendKeys(text);
        return this;
    }

    @Step
    public IFrameEditor switchToDefaultPage() {
        wd.switchTo().defaultContent();
        return this;
    }

    @Step
    public String getFrameTitle() {
       return wd.findElement(By.cssSelector("h3")).getText();
    }
}