package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutCompletePage {

    WebDriver driver;
    WebDriverWait wait;

    private final By backHomeButton = By.id("back-to-products");
    private final By checkoutCompleteOrderContainer = By.xpath("//div[@id='checkout_complete_container']/h2");


    public CheckoutCompletePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    public String getOrderCompleteMessageText(){
       return driver.findElement(checkoutCompleteOrderContainer).getText();  //Thank you for your order!
    }

    public void clickOnBackHomeButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(backHomeButton));
        driver.findElement(backHomeButton).click();
    }

}
