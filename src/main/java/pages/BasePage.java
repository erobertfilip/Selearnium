package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Click Method
    public void click (By elementLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(elementLocation));
        driver.findElement(elementLocation).click();
    }
    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }
    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}