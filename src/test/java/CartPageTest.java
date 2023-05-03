import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartPageTest extends BaseTest {

    //  Test checks the functionality of the Remove Cart Button. If the cart is empty the expected message "QTYDescription" will be found,
    //  else all the products remains in the cart will be displayed (product name, quantity, price) and the test fails
    @Test
    public void TestRemoveButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnAddToCartButtonBackpack();
        inventoryPage.clickOnShoppingCartContainer();
        String expected = "QTYDescription";
        cartPage.clickOnRemoveButton();
        Assert.assertEquals(expected, cartPage.getCartListText());
    }
}
