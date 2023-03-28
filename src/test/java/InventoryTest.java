import org.junit.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest {
    @Test
    public void wrongIMGTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        System.out.println(inventoryPage.firstItemImgAttribute());
    }

}
