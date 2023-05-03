package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    // Selectors
    private final By firstnameInput = By.id("first-name");
    private final By lastnameInput = By.id("last-name");
    private final By zipInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");

    // Methods that use the above selectors
    public void setFirstName(String firstname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameInput));
        driver.findElement(firstnameInput).sendKeys(firstname);
    }

    public void setLastName(String lastname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastnameInput));
        driver.findElement(lastnameInput).sendKeys(lastname);
    }

    public void setZip(String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipInput));
        driver.findElement(zipInput).sendKeys(zip);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    public void clickOnCancelButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton));
        driver.findElement(cancelButton).click();
    }

    public void checkoutInformation(String firstname, String lastname, String zip) {
        setFirstName(firstname);
        setLastName(lastname);
        setZip(zip);
    }
}
