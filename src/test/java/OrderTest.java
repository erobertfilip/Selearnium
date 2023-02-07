import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CheckoutOverviewPage;


// Happy flow test for buying and finalized a product order
public class OrderTest extends BaseTest {


    @Test
    public void TestHappyFlow_Order() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnAddToCartButton();

        CartPage cartPage = new CartPage(driver);
        inventoryPage.clickOnShoppingCartContainer();
        cartPage.getShoppingCartItem();
        Assert.assertTrue(CartPage.getShoppingCartItem().equals("Sauce Labs Backpack"));
        System.out.println(CartPage.getShoppingCartItem());
        CartPage.clickOnCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutInformations("superzeu", "ahile", "123456");

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
        Assert.assertTrue(CheckoutOverviewPage.getShippingInformation().equals("FREE PONY EXPRESS DELIVERY!"));
        System.out.println(CheckoutOverviewPage.getShippingInformation());

        checkoutOverviewPage.getTotalPrice();
        Assert.assertTrue(CheckoutOverviewPage.getTotalPrice().contains("$32.39"));
        System.out.println(CheckoutOverviewPage.getTotalPrice());
        CheckoutOverviewPage.clickOnFinishButton();
        }
}
