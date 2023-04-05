import org.junit.Assert;
import org.junit.Test;
import pages.*;

public class LoginTest extends BaseTest {

    @Test
    public void TestLoginSuccess_StandardUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void TestLoginFailed_StandardUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standarDd_user", "secret_sauce");
        loginPage.AssertionFailed_StandardUserMessage();
    }

    @Test
    public void TestLogin_LockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.AssertionLockedOutUserMessage();
    }

}
