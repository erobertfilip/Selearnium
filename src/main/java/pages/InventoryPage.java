package pages;

import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InventoryPage {

    WebDriver driver;
    WebDriverWait wait;


    public InventoryPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }
    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");

    private final By shoppingCartContainer = By.id("shopping_cart_container");

    public void clickOnAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
    }

    public void clickOnShoppingCartContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartContainer));
        driver.findElement(shoppingCartContainer).click();
    }
}
