package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    // Selectors
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorBox = By.xpath("//div[@class='login-box']//h3");

    // Methods that use the above selectors
    public void setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLogin();
    }

    public String getErrorTextField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorBox));
        return driver.findElement(errorBox).getText();
    }

}

