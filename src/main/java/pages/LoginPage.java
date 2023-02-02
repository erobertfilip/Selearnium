package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;
public class LoginPage extends LoadableComponent<LoginPage> {
    //*********Page Variables*********
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage page;
    private LoadableComponent<HomePage> parent;
    private final String loginURL = "https://capriciicolorate.ro";
    //*********Constructor*********
    public LoginPage (WebDriver driver, LoadableComponent<HomePage> parent) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        page = new BasePage(this.driver);
        this.parent = parent;
    }
    //*********Web Elements*********
    By usernameBy = By.name("username");
    By passwordBy = By.id("password");
    By loginButtonBy = By.name("login");
    By errorMessageUsernameBy = By.xpath("//*[@role='alert']//*[contains(text(),'utilizator')]");
    By errorMessagePasswordBy = By.xpath("//*[@role='alert']//*[contains(text(),'parolă')]");
    //*********Override LoadableComponent Methods*********
    //We need to go to the page at load method
    @Override
    protected void load() {
        parent.get().goToLoginPage();
    }
    //We need to check that the page has been loaded.
    @Override
    protected void isLoaded() throws Error {
        assertTrue("LoginPage is not loaded!", driver.getCurrentUrl().contains(loginURL));
    }
    //*********Page Methods*********
    public void loginToN11 (String username, String password){
        //Enter Username(Email)
        page.writeText(usernameBy,username);
        //Enter Password
        page.writeText(passwordBy, password);
        //Click Login Button
        page.click(usernameBy); //In order to click right, this line needed. Site related.
        page.click(loginButtonBy);
    }
    //Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageUsernameBy));
        Assert.assertEquals(page.readText(errorMessageUsernameBy), expectedText);
    }
    //Verify Password Condition
    public void verifyLoginPassword (String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessagePasswordBy));
        Assert.assertEquals(page.readText(errorMessagePasswordBy), expectedText);
    }
}
