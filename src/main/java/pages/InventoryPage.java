package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class InventoryPage {

    static WebDriver driver;
    WebDriverWait wait;

    // Selectors
    private final By invContainer = By.id("inventory_container");
    private final By productsPageTitleLocator = By.xpath("//div/span[@class='title']");
    private final By sortButton = By.xpath("//*[@id='header_container']/div[2]/div/span/select");
    private final By activeOptionSorting = By.xpath("//div[@class='right_component']/span/span");
    private final By addToCartButtonBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartContainer = By.id("shopping_cart_container");
    private final By AtoZSort = By.xpath("//div/span[@class='select_container']/select/option[1]");
    private final By ZtoASort = By.xpath("//div/span[@class='select_container']/select/option[2]");
    private final By LowToHighSort = By.xpath("//div/span[@class='select_container']/select/option[3]");
    private final By HighToLowSort = By.xpath("//div/span[@class='select_container']/select/option[4]");

    // Constructor
    public InventoryPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods that use the above selectors
    public void clickOnAddToCartButtonBackpack() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonBackpack));
        driver.findElement(addToCartButtonBackpack).click();
    }

    public void clickOnShoppingCartContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartContainer));
        driver.findElement(shoppingCartContainer).click();
    }

    public String getInventoryContainerText() {
        return driver.findElement(invContainer).getText();
    }

    public void clickOnSortButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortButton));
        driver.findElement(sortButton).click();
    }

    public String getActiveOptionText() {
        return driver.findElement(activeOptionSorting).getText();
    }

    public String getProductsPageTitleText() {
        return driver.findElement(productsPageTitleLocator).getText();
    }

    public void clickOnAtoZSort() {
        wait.until(ExpectedConditions.elementToBeClickable(AtoZSort));
        driver.findElement(AtoZSort).click();
    }

    public void clickOnZtoASort() {
        wait.until(ExpectedConditions.elementToBeClickable(ZtoASort));
        driver.findElement(ZtoASort).click();
    }

    public void clickOnLowToHighSort() {
        wait.until(ExpectedConditions.elementToBeClickable(LowToHighSort));
        driver.findElement(LowToHighSort).click();
    }

    public void clickOnHighToLowSort() {
        wait.until(ExpectedConditions.elementToBeClickable(HighToLowSort));
        driver.findElement(HighToLowSort).click();
    }

}
