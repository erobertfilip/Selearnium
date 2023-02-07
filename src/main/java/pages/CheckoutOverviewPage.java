package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {

    static WebDriver driver;
    static WebDriverWait wait;

    public CheckoutOverviewPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }


    private static final By itemName = By.xpath("//div[@class='inventory_item_name']");
    private static final By itemPrice = By.xpath("//div[@class='inventory_item_price']");
    private static final By paymentInformation = By.xpath("//div[2][@class='summary_value_label'='SauceCard #31337']");
    private static final By shippingInformation = By.xpath("//div[4][@class='summary_value_label'= 'FREE PONY EXPRESS DELIVERY!']");
    private static final By totalPrice = By.xpath("//div[7][@class='summary_total_label']");
    private static final By finishButton = By.xpath("//*[@id='finish']");
    public static void clickOnFinishButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        driver.findElement(finishButton).click();
    }

    public static String getItemName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));
        return driver.findElement(itemName).getText();

    }

    public static String getItemPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemPrice));
        return driver.findElement(itemPrice).getText();

    }

    public static String getPaymentInformation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInformation));
        return driver.findElement(paymentInformation).getText();

    }

    public static String getShippingInformation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingInformation));
        return driver.findElement(shippingInformation).getText();

    }

    public static String getTotalPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        return driver.findElement(totalPrice).getText();

    }

}
