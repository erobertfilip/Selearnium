package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    static WebDriver driver;
    static WebDriverWait wait;

    // Selectors
    private static final By removeItemButton = By.id("remove-sauce-labs-backpack");
    private static final By continueShoppingButton = By.id("continue-shopping");
    private static final By checkoutButton = By.id("checkout");
    private static final By shoppingCartItem = By.xpath("//div[@class='inventory_item_name']");
    private static final By cartList = By.xpath("//div[@class='cart_list']");
    private static final By yourCartTitleLocator = By.xpath("//span[@class='title']");

    // Constructor
    public CartPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    // Methods that use the above selectors
    public static String getShoppingCartItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartItem));
        return driver.findElement(shoppingCartItem).getText();
    }

    public static void clickOnCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
    }

    public static void clickOnRemoveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(removeItemButton));
        driver.findElement(removeItemButton).click();
    }

    public static void clickOnContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        driver.findElement(continueShoppingButton).click();
    }

    public String getYourCartPageTitleText() {
        return driver.findElement(yourCartTitleLocator).getText();
    }

    public String getCartListText() {
        return driver.findElement(cartList).getText();
    }
}
