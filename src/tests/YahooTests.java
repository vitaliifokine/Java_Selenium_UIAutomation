package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.yahoo.YahooLoginPage;
import pages.yahoo.YahooMainPage;
import pages.yahoo.component.AccountPopUp;
import pages.yahoo.domain.User;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class YahooTests extends BaseTest {

    @AfterClass
    public void cleanData() {
        new YahooMainPage(wd).cleanData();
    }

    @Feature("YAHOO - LOGIN")
    @Test
    public void testCanLoginAsValidUser() {
        User user = new User("andrewdavies80", "vf281992");
        new YahooLoginPage(wd).open()
                .loginAs(user)
                .openAccountPopUp();
        assertThat(new AccountPopUp(wd).getUserEMail(),
                containsString(user.getUsernameWithoutMail()));
    }
}