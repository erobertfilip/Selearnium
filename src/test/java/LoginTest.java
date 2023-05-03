import org.junit.Test;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void TestLoginSuccess_StandardUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void TestLoginFailed_StandardUser() {
        // code goes here
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user05", "secret_sauce");
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorTextField());
        System.out.println("Assertion Passed");
    }

    @Test
    public void TestLogin_LockedOutUser() {
        // code goes here
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorTextField());
        System.out.println("Assertion Passed");
    }

}
