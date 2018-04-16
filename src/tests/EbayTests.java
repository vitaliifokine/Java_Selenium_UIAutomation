package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.ebayPages.MainPage;
import pages.ebayPages.SignInPage;
import pages.yahoo.domain.User;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class EbayTests extends BaseTest {

    @Feature("Ebay - LOGIN")
    @Test
    public void loginWithValidCredentials() {
        User user = new User("andrewdavies80", "vf281992");
        new SignInPage(wd).openSignInPage().loginWithValidCredentials(user);
        assertThat(new MainPage(wd).getUser(),
                containsString("Hi Andrew"));
    }
}
