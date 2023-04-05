import org.junit.Assert;
import org.junit.Test;
import pages.InventoryPage;
import pages.LoginPage;
import org.testng.asserts.SoftAssert;

public class InventoryTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

//  This test reveals the fact that when adding certain items to the cart and then logging out and switching to other users the items added to cart on
//  user in first place, remain added for other users as well
//  This test also verifies the functionality of the "Add to cart" buttons
    @Test
    public void TestAddToCartButtonForEachItemOnThePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart("Backpack");
        inventoryPage.addToCart("TShirtRed");
        inventoryPage.addToCart("Bike Light");
        inventoryPage.addToCart("Bolt T-Shirt");
        inventoryPage.addToCart("Fleece Jacket");
        inventoryPage.addToCart("Labs Onesie");
        inventoryPage.clickOnBurgerMenuButton();
        inventoryPage.clickOnLogOutBtn();
        loginPage.login("problem_user", "secret_sauce");
        softAssert.assertTrue(inventoryPage.getBackpackDataTestAtrbVal().contains("add"));
        softAssert.assertTrue(inventoryPage.getTShirtRdataTestAtrbVal().contains("add"));
        softAssert.assertTrue(inventoryPage.getBikeLightDataTestAttributeValue().contains("add"));
        softAssert.assertTrue(inventoryPage.getBoltTShirtDataTestAtrbVal().contains("add"));
        softAssert.assertTrue(inventoryPage.getFleeceJktDataTestAtrbVal().contains("add"));
        softAssert.assertTrue(inventoryPage.getOnesieDataTestAtrbVal().contains("add"));
        softAssert.assertAll();
    }

    @Test
    public void TestResetAppStateFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart("Bike Light");
        inventoryPage.clickOnBurgerMenuButton();
        inventoryPage.clickOnResetAppStateButton();
        String expectedValue = "add-to-cart-sauce-labs-bike-light";
        String idType = inventoryPage.checkRemoveButtonResetsAfterResetApp();
        Assert.assertEquals(expectedValue, idType);
//  The assertion fails due to the fact that the "Remove" button does not change back to "Add to cart" after using the "Reset App State" button, only after refreshing the page
    }

    @Test
    public void CheckInventoryPageForPlaceholderText() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertFalse(inventoryPage.getInventoryContainerText().contains("test"));
    }

    @Test
    public void CheckFilterSortingFunctionality() {
//  For problem_user the test will fail for Z to A, Lo to Hi and Hi to Lo, as the option are unclickable
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnSortButton();
        inventoryPage.selectSort("Price (low to high)");
//  Sorting options: "Name (A to Z)"| "Name (Z to A)" | "Price (low to high)" | "Price (high to low)"
    }

    @Test
    public void CheckIfTheSameInventoryItemIsDisplayedWithinItsContainer(){
//  Switch to "problem_user" in order to observe the assertions fail as for the problem_user each invetory item has a different item container
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);

        String InvFirstItmTitle = inventoryPage.getFirstInvItemTitle();
        inventoryPage.clickOnFirstInvItem();
        softAssert.assertEquals(InvFirstItmTitle, inventoryPage.getItemContainerTitleText());
        inventoryPage.clickOnBackToProducts();

        String InvSecondItmTitle = inventoryPage.getSecondInvItemTitle();
        inventoryPage.clickOnSecondInvItm();
        softAssert.assertEquals(InvSecondItmTitle, inventoryPage.getItemContainerTitleText());
        inventoryPage.clickOnBackToProducts();

        String InvThirdItmTitle = inventoryPage.getThirdInvItemTitle();
        inventoryPage.clickOnThirdInvItm();
        softAssert.assertEquals(InvThirdItmTitle, inventoryPage.getItemContainerTitleText());
        inventoryPage.clickOnBackToProducts();

        String InvFourthItmTitle = inventoryPage.getFourthInvItemTitle();
        inventoryPage.clickOnFourhInvItm();
        softAssert.assertEquals(InvFourthItmTitle, inventoryPage.getItemContainerTitleText());
        inventoryPage.clickOnBackToProducts();

        String InvFifthItmTitle = inventoryPage.getFifthInvItemTitle();
        inventoryPage.clickOnFifthInvItm();
        softAssert.assertEquals(InvFifthItmTitle, inventoryPage.getItemContainerTitleText());
        inventoryPage.clickOnBackToProducts();

        String InvSixthItmTitle = inventoryPage.getSixthInvItemTitle();
        inventoryPage.clickOnSixthInvItm();
        softAssert.assertEquals(InvSixthItmTitle,inventoryPage.getItemContainerTitleText());
        softAssert.assertAll();
    }

    @Test
    public void checkForDuplicatedItmImagesTest() {
//  Switch to "problem_user" in order to observe the assertions fail.
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        softAssert.assertNotEquals(inventoryPage.getFirstItemImgAttribute(), inventoryPage.getSecondItemImgAttribute());
        softAssert.assertNotEquals(inventoryPage.getSecondItemImgAttribute(),inventoryPage.getThirdItemImgAttribute());
        softAssert.assertNotEquals(inventoryPage.getThirdItemImgAttribute(),inventoryPage.getFourthItemImgAttribute());
        softAssert.assertNotEquals(inventoryPage.getFourthItemImgAttribute(),inventoryPage.getFifthItemImgAttribute());
        softAssert.assertNotEquals(inventoryPage.getFifthItemImgAttribute(),inventoryPage.getSixthItemImgAttribute());
        softAssert.assertAll();
}

    @Test
    public void checkForPlaceHolderImagesTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.placeHolderImgCheck();
    }

}



