import org.junit.Assert;
import org.junit.Test;
import pages.InventoryPage;
import pages.LoginPage;
import org.testng.asserts.SoftAssert;

public class InventoryTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TestAddToCartButtonForEachItemOnThePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart("Backpack");
        inventoryPage.addToCart("TShirtRed");
        inventoryPage.addToCart("Bike Light");
        inventoryPage.addToCart("Bolt T-Shirt");
        inventoryPage.addToCart("Fleece Jacket");
        inventoryPage.addToCart("Labs Onesie");
        inventoryPage.clickOnBurgerMenuButton();  ///add  //remove
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
        Assert.assertEquals(expectedValue, idType);                              //the assertion fails due to the fact that the "Remove" button does not change back
        System.out.println(inventoryPage.checkRemoveButtonResetsAfterResetApp());//to "Add to cart" after using the "Reset App State" button, only after refreshing the page.
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce"); //for problem_user the test will fail for Z to A, Lo to Hi and Hi to Lo, as the option are unclickable
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnSortButton();
        inventoryPage.selectSort("Price (low to high)"); // "Name (A to Z)"| "Name (Z to A)" | "Price (low to high)" | "Price (high to low)"
}

    @Test
    public void CheckIfTheSameInventoryItemIsDisplayedWithinItsContainer(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user", "secret_sauce"); // switch to "problem_user" in order to observe the assertions fail
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
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("problem_user", "secret_sauce"); // switch to "problem_user" in order to observe the assertions fail.
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
        loginPage.login("problem_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.placeHolderImgCheck();
    }



}



