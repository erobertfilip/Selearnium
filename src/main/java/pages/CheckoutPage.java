package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.testng.AssertJUnit.fail;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By firstNameLocator = By.id("first-name");
    private final By lastNameLocator = By.id("last-name");
    private final By postalCodeLocator = By.id("postal-code");
    private final By cancelButton = By.id("cancel");
    private final By continueButton = By.id("continue");


    public CheckoutPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    public void typeFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameLocator));
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameLocator));
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

    public void typePostalCode(String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeLocator));
        driver.findElement(postalCodeLocator).sendKeys(postalCode);
    }

    public void clickOnCancelButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton));
        driver.findElement(cancelButton).click();
    }

    public void clickOnContinueButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
    }

    public void insertCheckoutInformation(String firstName, String lastName, String postalCode) {
        typeFirstName(firstName);
        typeLastName(lastName);
        typePostalCode(postalCode);
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        for (WebElement e : inputFields) {
            String text = e.getAttribute("value");
            if (text.isEmpty()) {
                fail("Input text field is non-editable/readonly");
            }
        }
    }
}



