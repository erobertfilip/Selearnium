import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.List;

import static org.junit.Assert.fail;


public class OrdersTest extends BaseTest {

    // Happy flow test
    @Test
    public void TestHappyFlow_Order() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnAddToCartButtonBackpack();

        CartPage cartPage = new CartPage(driver);
        inventoryPage.clickOnShoppingCartContainer();
        cartPage.getShoppingCartItem();
        Assert.assertTrue(CartPage.getShoppingCartItem().equals("Sauce Labs Backpack"));
        System.out.println(CartPage.getShoppingCartItem());
        CartPage.clickOnCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutInformation("superzeu", "ahile", "123456");
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        for (WebElement e : inputFields) {
            String text = e.getAttribute("value");
            if (text.isEmpty()) {
                fail("Text area field is non-writable");
            }
        }
        checkoutPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.getItemName();
        Assert.assertTrue(CheckoutOverviewPage.getItemName().equals("Sauce Labs Backpack"));
        System.out.println(CheckoutOverviewPage.getItemName());

        checkoutOverviewPage.getItemPrice();
        Assert.assertTrue(CheckoutOverviewPage.getItemPrice().contains("$29.99"));
        System.out.println(CheckoutOverviewPage.getItemPrice());

        checkoutOverviewPage.getPaymentInformation();
        Assert.assertTrue(CheckoutOverviewPage.getPaymentInformation().equals("SauceCard #31337"));
        System.out.println(CheckoutOverviewPage.getPaymentInformation());

        checkoutOverviewPage.getShippingInformation();
        Assert.assertTrue(CheckoutOverviewPage.getShippingInformation().equals("Free Pony Express Delivery!"));
        System.out.println(CheckoutOverviewPage.getShippingInformation());

        checkoutOverviewPage.getTotalPrice();
        Assert.assertTrue(CheckoutOverviewPage.getTotalPrice().contains("$32.39"));
        System.out.println(CheckoutOverviewPage.getTotalPrice());
        CheckoutOverviewPage.clickOnFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals("Thank you for your order!", checkoutCompletePage.getOrderCompleteMessage());
        System.out.println(checkoutCompletePage.getOrderCompleteMessage());
        checkoutCompletePage.clickOnBackHomeButton();
        Assert.assertEquals("Products", inventoryPage.getProductsPageTitleText());
    }

    // Test checks Continue Shopping Button functionality
    @Test
    public void TestContinueShoppingButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnAddToCartButtonBackpack();

        inventoryPage.clickOnShoppingCartContainer();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnContinueShopping();
        Assert.assertEquals("Products", inventoryPage.getProductsPageTitleText());
    }

    // Test checks Cancel Button functionality
    @Test
    public void TestCancelButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnAddToCartButtonBackpack();
        inventoryPage.clickOnShoppingCartContainer();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickOnCancelButton();
        Assert.assertEquals(cartPage.getYourCartPageTitleText(), "Your Cart");
        cartPage.clickOnCheckoutButton();
        checkoutPage.checkoutInformation("superzeu", "ahile", "123456");
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        for (WebElement e : inputFields) {
            String text = e.getAttribute("value");
            if (text.isEmpty()) {
                fail("Text area field is non-writable");
            }
        }
        checkoutPage.clickContinue();
        checkoutPage.clickOnCancelButton();
        Assert.assertEquals("Products", inventoryPage.getProductsPageTitleText());
    }
}