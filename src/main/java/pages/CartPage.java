package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By removeItemButton = By.id("remove-sauce-labs-backpack");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    private final By cartList = By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]");


    public CartPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }
    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
    public void clickOnRemoveButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeItemButton));
        driver.findElement(removeItemButton).click();
    }
    public void clickOnContinueShopping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
        driver.findElement(continueShoppingButton).click();
    }
    public void clickOnCheckoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));
        driver.findElement(checkoutButton).click();
    }

    /*public void checkCartPageButtons(){
        clickOnShoppingCartContainer();
        clickOnContinueShopping();
        clickOnShoppingCartContainer();
        clickOnRemoveButton();
    }*/

    public String getCartListRemoveClassAttribute() {
        return getAttributeValue(driver.findElement(cartList),"class");
    }


}
