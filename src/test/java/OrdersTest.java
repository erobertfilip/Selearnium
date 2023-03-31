import org.junit.Assert;
import org.junit.Test;
import pages.*;


public class OrdersTest extends BaseTest {

    @Test
    public void HappyPathTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce"); //
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart("Backpack");
        inventoryPage.addToCart("TShirtRed");
        inventoryPage.clickOnShoppingCartContainer();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.insertCheckoutInformation("Place","Holder","123456");
        checkoutPage.clickOnContinueButton();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickOnFinishButton();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutCompletePage.getOrderCompleteMessageText(), "Thank you for your order!");
        checkoutCompletePage.clickOnBackHomeButton();
        Assert.assertEquals(inventoryPage.getProductsPageTitleText(),"Products");
    }

    public void ContinueShoppingButtonFunctionalityTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart("Backpack");
        inventoryPage.addToCart("TShirtRed");

    }

}
