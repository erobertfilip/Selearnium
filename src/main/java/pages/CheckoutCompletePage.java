package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CheckoutCompletePage {

    WebDriver driver;
    WebDriverWait wait;

    // Selectors
    private final By backHomeButton = By.id("back-to-products");
    private final By checkoutCompleteMessage = By.xpath("//div[@id='checkout_complete_container']/h2");

    // Constructor
    public CheckoutCompletePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    // Methods that use the above selectors
    public String getOrderCompleteMessage() {
        return driver.findElement(checkoutCompleteMessage).getText();
    }

    public void clickOnBackHomeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(backHomeButton));
        driver.findElement(backHomeButton).click();
    }

}

