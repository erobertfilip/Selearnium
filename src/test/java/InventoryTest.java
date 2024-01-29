import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.InventoryPage;
import pages.LoginPage;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class InventoryTest extends BaseTest {

    // This test checks if any product name contains the placeholder word "test"
    @Test
    public void TestInventoryPageForSubstituteText() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertFalse(inventoryPage.getInventoryContainerText().contains("test"));
    }

    // This test checks the filter sorting functionality
    @Test
    public void TestFilterSorting() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnSortButton();
        inventoryPage.clickOnAtoZSort();
        Assert.assertEquals(inventoryPage.getActiveOptionText(), "Name (A to Z)");
        inventoryPage.clickOnZtoASort();
        Assert.assertEquals(inventoryPage.getActiveOptionText(), "Name (Z to A)");
        inventoryPage.clickOnLowToHighSort();
        Assert.assertEquals(inventoryPage.getActiveOptionText(), "Price (low to high)");
        inventoryPage.clickOnHighToLowSort();
        Assert.assertEquals(inventoryPage.getActiveOptionText(), "Price (high to low)");
    }

    // This test checks if there are no placeholder images for each inventory item.
    // For problem_user the test fails as all the inventory items have the same placeholder image
    @Test
    public void TestWrongItemsImages() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        List<WebElement> imgElements = driver.findElements(By.tagName("img"));
        List<String> srcValues = new ArrayList<String>();
        for (WebElement element : imgElements) {
            String src = element.getAttribute("src");
            srcValues.add(src);
            if (srcValues.contains("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg")) {
                fail("Wrong image(s) found: " + srcValues);
            }
        }
    }
}
