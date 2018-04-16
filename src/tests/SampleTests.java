package tests;

import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.herokuappPages.DownloadPage;
import pages.herokuappPages.IFrameEditor;
import pages.herokuappPages.NestedFramePage;
import pages.herokuappPages.UploadResultPage;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class SampleTests extends BaseTest {

    @Feature("DOWNLOAD FILE")
    @Test
    public void testCanUploadFile() {
        String filepath = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";
        new DownloadPage(wd).open()
                .uploadFileAndSubmit(filepath);
        assertThat(new UploadResultPage(wd).getUploadFileName(),
                containsString("IEDriverServer.exe") );
    }

    @Test
    public void nestedFramesTest() {
      new NestedFramePage(wd).openNestedFrames()
              .switchToTopFrame()
              .switchToMiddleFrame();
        assertThat(new NestedFramePage(wd).getTextFromFrame(),
                is(equalTo("MIDDLE")));
    }

    @Test
    public void iFramesTest() {
        IFrameEditor frameEditor = new IFrameEditor(wd);
        frameEditor.openEditor();
        String beforeText = frameEditor.getTextFromEditor();
        frameEditor.clearEditor()
                .writeInEditor("Hello World!");
        String afterText = frameEditor.getTextFromEditor();
        assertThat(afterText, not(equalTo((beforeText))));
        frameEditor.switchToDefaultPage();
        assertThat(frameEditor.getFrameTitle(),
                is("An iFrame containing the TinyMCE WYSIWYG Editor"));
    }

    @Test
    public void multipleWindowsRedux() {
        wd.get("http://the-internet.herokuapp.com/windows");
        // Get initial window handle
        String firstWindow = wd.getWindowHandle();
        // Create a newWindow variable
        String newWindow = "";
        // Trigger new window to open
        wd.findElement(By.cssSelector(".example a")).click();
        // Grab all window handles
        Set<String> allWindows = wd.getWindowHandles();

        // Iterate through window handles collection
        // Find the new window handle, storing it in the newWindow variable
        for (String window : allWindows) {
            if (!window.equals(firstWindow)) {
                newWindow = window;
            }
        }

        // Switch to the first window & verify
         wd.switchTo().window(firstWindow);
        assertThat(wd.getTitle(), is(not(equalTo("New Window"))));

        // Switch to the new window & verify
        wd.switchTo().window(newWindow);
        assertThat(wd.getTitle(), is(equalTo("New Window")));
    }

    @Test
    public void dropdownTest() {
        wd.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownList = wd.findElement(By.id("dropdown"));
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals("Option 1")) {
                options.get(i).click();
            }
        }
        String selectedOption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()) {
                selectedOption = options.get(i).getText();
            }
        }
        assertThat(selectedOption, is("Option 1"));
    }

    @Test
    public void dropdownTestRedux() {
        wd.get("http://the-internet.herokuapp.com/dropdown");
        Select selectList = new Select(wd.findElement(By.id("dropdown")));
        selectList.selectByVisibleText("Option 1");
        // You could also use select.selectByValue("1");
        assertThat(selectList.getFirstSelectedOption().getText(), is(equalTo("Option 1")));
    }

}