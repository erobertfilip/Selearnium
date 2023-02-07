package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    static WebDriver driver;
    static WebDriverWait wait;

    public CartPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    private static final By shoppingCartItem = By.xpath("//div[@class='inventory_item_name']");

    private static final By checkoutButton = By.xpath("//*[@id='checkout']");



    public static String getShoppingCartItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartItem));
//        System.out.println(getShoppingCartItem);
        return driver.findElement(shoppingCartItem).getText();

    }

    public static void clickOnCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
    }
}
