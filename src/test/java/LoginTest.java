import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

//    @Test
//    public void TestLoginSuccess_StandardUser() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("standard_user", "secret_sauce");
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
//    }

    @Test
    public void TestLoginFailed_StandardUser() {
        // code goes here
    }

    @Test
    public void TestLogin_LockedOutUser() {
        // code goes here
    }

}
