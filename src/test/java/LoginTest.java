import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    }

    @Test
    public void TestLogin_LockedOutUser() {
        // code goes here
    }

}
