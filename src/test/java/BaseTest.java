import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    static WebDriver driver;

    @Before
    public void driverSetup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.saucedemo.com/");
    }


}

   /* @After
    public void quitBrowser() {
        driver.quit();
    }

}*/
