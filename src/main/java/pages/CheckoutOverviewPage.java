package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {
    WebDriver driver;
    WebDriverWait wait;

    private final By finishButtonLocator = By.id("finish");


    public CheckoutOverviewPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    public void clickOnFinishButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButtonLocator));
        driver.findElement(finishButtonLocator).click();
    }

}
