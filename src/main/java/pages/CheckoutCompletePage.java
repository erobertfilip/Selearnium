package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutCompletePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    private final By checkoutCompleteMessage = By.xpath("//div[@id='checkout_complete_container']/h2");

    public String getOrderCompleteMessage(){
        return driver.findElement(checkoutCompleteMessage).getText();
    }

}
