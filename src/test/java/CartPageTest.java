import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartPageTest extends BaseTest {

    @Test
    public void RemoveButtonFunctionalityTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart("Backpack");
        inventoryPage.clickOnShoppingCartContainer();
        cartPage.clickOnRemoveButton();
        cartPage.getCartListRemoveClassAttribute();
        String removedItmAttribute = "removed_cart_item";
        Assert.assertEquals(cartPage.getCartListRemoveClassAttribute(),removedItmAttribute);
    }

}