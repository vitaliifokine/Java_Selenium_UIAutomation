package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverFactory;

public abstract class BaseTest extends DriverFactory {

    @BeforeTest
    public void setUp() {
        wd = DriverFactory.setBrowser("chrome");
        wd.manage().window().maximize();
    }

    @AfterTest
    public void quit() {
        wd.quit();
    }
}