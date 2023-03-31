package pages;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class InventoryPage {
    WebDriver driver;
    WebDriverWait wait;

    // INVENTORY PAGE SELECTORS
    //Add to cart buttons
    private final By backpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By tShirtRedAddToCart = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final By bikeLightAddToCart = By.id("add-to-cart-sauce-labs-bike-light");
    private final By boltTShirtAddToCart = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By fleeceJacketAddToCart = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By bikeLightAddToCartFullXpath = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/button");
    private final By boltTshirtAddnRemoveFullXpathBtn = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[2]/button");
    private final By tShirtRedAddnRemoveFullXpathBtn = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[2]/button");
    private final By onesieAddnRemoveFullXpathBtn = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[5]/div[2]/div[2]/button");
    private final By fleeceJacketAddnRemoveFullXpathBtn = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[4]/div[2]/div[2]/button");
    private final By backpackAddnRemoveFullXpathBtn = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button");

    //Other Inventory page elements
    private final By sauceLabOnesie = By.id("add-to-cart-sauce-labs-onesie");
    private final By invContainer = By.id("inventory_container");
    private final By bikeLightRemoveFromCartButton = By.id("remove-sauce-labs-bike-light");
    private final By burgerMenuButton = By.id("react-burger-menu-btn");
    private final By resetAppStateButton = By.id("reset_sidebar_link");
    private final By productsPageTitleLocator = By.xpath("//div/span[@class='title']");
    private final By shoppingCartButton = By.id("shopping_cart_container");
    private final By inventoryList = By.xpath("//div[@class='inventory_list']");
    private final By sortActiveOption = By.xpath("//div[@class='right_component']/span/span");
    private final By logOutButton = By.id("logout_sidebar_link");

    //Sort buttons
    private final By sortButton = By.xpath("//*[@id='header_container']/div[2]/div/span/select");
    public final By sortZA = By.xpath("//div[@class='right_component']/span/select/option[2]");
    private final By sortAZ = By.xpath("//div[@class='right_component']/span/select/option[1]");
    private final By sortPriceLoHi = By.xpath("//div[@class='right_component']/span/select/option[3]");
    private final By sortHiLo = By.xpath("//div[@class='right_component']/span/select/option[4]");

    //Items title selectors
    private final By firstItemTitle = By.xpath("//*[@id='item_4_title_link']");
    private final By secondItemTitle = By.xpath("//*[@id='item_0_title_link']");
    private final By thirdItemTitle = By.xpath("//*[@id='item_1_title_link']");
    private final By fourthItemTitle = By.xpath("//*[@id='item_5_title_link']");
    private final By fifthItemTitle = By.xpath("//*[@id='item_2_title_link']");
    private final By sixthItemTitle = By.xpath("//*[@id='item_3_title_link']");

    //Items imagines selectors
    private final By firstItmImg = By.xpath("//*[@id='item_4_img_link']/img");
    private final By secondItmImg = By.xpath("//*[@id='item_0_img_link']/img");
    private final By thirdItmImg = By.xpath("//*[@id='item_1_img_link']/img");
    private final By fourthItmImg = By.xpath("//*[@id='item_5_img_link']/img");
    private final By fifthItmImg = By.xpath("//*[@id='item_2_img_link']/img");
    private final By sixthItmImg = By.xpath("//*[@id='item_3_img_link']/img");

    //INDIVIDUAL ITEM CONTAINER SELECTORS
    private final By itemContainerTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    private final By backToProductsButton = By.id("back-to-products");


    public InventoryPage(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void clickOnShoppingCartContainer(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartButton));
        driver.findElement(shoppingCartButton).click();
    }
    public void clickOnRemoveFromCartButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bikeLightRemoveFromCartButton));
        driver.findElement(bikeLightRemoveFromCartButton).click();
    }
    public void clickOnBurgerMenuButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(burgerMenuButton));
        driver.findElement(burgerMenuButton).click();
    }
    public void clickOnResetAppStateButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetAppStateButton));
        driver.findElement(resetAppStateButton).click();
    }
    public void clickOnLogOutBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        driver.findElement(logOutButton).click();
    }

    //as the site has only 6 items inventory I've chosen to add a switch. I am aware there could be sites with thousands of items,
    //and other methods would be more fitting/recommended, but for this instance, I've done it this way.

    public void addToCart(String Item){
        switch (Item) {
            case "TShirtRed":
                wait.until(ExpectedConditions.visibilityOfElementLocated(tShirtRedAddToCart));
                driver.findElement(tShirtRedAddToCart).click();
                Assert.assertTrue(getTShirtRdataTestAtrbVal().contains("remove"));
                break;

            case "Backpack":
                wait.until(ExpectedConditions.visibilityOfElementLocated(backpackAddToCart));
                driver.findElement(backpackAddToCart).click();
                Assert.assertTrue(getBackpackDataTestAtrbVal().contains("remove"));
                break;

            case "Bike Light":
                wait.until(ExpectedConditions.visibilityOfElementLocated(bikeLightAddToCart));
                driver.findElement(bikeLightAddToCart).click();
                Assert.assertTrue(getBikeLightDataTestAttributeValue().contains("remove"));
                break;

            case "Bolt T-Shirt":
                wait.until(ExpectedConditions.visibilityOfElementLocated(boltTShirtAddToCart));
                driver.findElement(boltTShirtAddToCart).click();
                Assert.assertTrue(getBoltTShirtDataTestAtrbVal().contains("remove"));
                break;

            case "Fleece Jacket":
                wait.until(ExpectedConditions.visibilityOfElementLocated(fleeceJacketAddToCart));
                driver.findElement(fleeceJacketAddToCart).click();
                Assert.assertTrue(getFleeceJktDataTestAtrbVal().contains("remove"));
                break;

            case "Labs Onesie":
                wait.until(ExpectedConditions.visibilityOfElementLocated(sauceLabOnesie));
                driver.findElement(sauceLabOnesie).click();
                Assert.assertTrue(getOnesieDataTestAtrbVal().contains("remove"));
                break;
        }
    }

    public String getInventoryContainerText(){
        return driver.findElement(invContainer).getText();
    }
    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
    public String checkRemoveButtonResetsAfterResetApp(){
        return getAttributeValue(driver.findElement(bikeLightAddToCartFullXpath), "id");
    }
    public void clickOnSortButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortButton));
        driver.findElement(sortButton).click();
    }

    //Sorting switch selector and assert
    public void selectSort(String Sort){
        switch (Sort){
            case "Name (A to Z)":
                wait.until(ExpectedConditions.visibilityOfElementLocated(sortAZ));
                driver.findElement(sortAZ).click();
                Assert.assertEquals(Sort,getActiveOptionText());
                break;
            case "Name (Z to A)":
                wait.until(ExpectedConditions.visibilityOfElementLocated(sortZA));
                driver.findElement(sortZA).click();
                Assert.assertEquals(Sort,getActiveOptionText());
                break;
            case "Price (low to high)":
                wait.until(ExpectedConditions.visibilityOfElementLocated(sortPriceLoHi));
                driver.findElement(sortPriceLoHi).click();
                Assert.assertEquals(Sort,getActiveOptionText());
                break;
            case "Price (high to low)":
                wait.until(ExpectedConditions.visibilityOfElementLocated(sortHiLo));
                driver.findElement(sortHiLo).click();
                Assert.assertEquals(Sort,getActiveOptionText());
                break;
        }
    }

    public String getActiveOptionText(){
        return driver.findElement(sortActiveOption).getText();
    }

    public String getProductsPageTitleText(){
        return driver.findElement(productsPageTitleLocator).getText();
    }
    public String getFirstInvItemTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemTitle));
        return driver.findElement(firstItemTitle).getText();
    }
    public String getSecondInvItemTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondItemTitle));
        return driver.findElement(secondItemTitle).getText();
    }
    public String getThirdInvItemTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdItemTitle));
        return driver.findElement(thirdItemTitle).getText();
    }
    public String getFourthInvItemTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fourthItemTitle));
        return driver.findElement(fourthItemTitle).getText();
    }
    public String getFifthInvItemTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fifthItemTitle));
        return driver.findElement(fifthItemTitle).getText();
    }
    public String getSixthInvItemTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sixthItemTitle));
        return driver.findElement(sixthItemTitle).getText();
    }
    public String getItemContainerTitleText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemContainerTitle));
        return driver.findElement(itemContainerTitle).getText();
    }
    public void clickOnFirstInvItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstItemTitle));
        driver.findElement(firstItemTitle).click();
    }
    public void clickOnSecondInvItm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondItemTitle));
        driver.findElement(secondItemTitle).click();
    }
    public void clickOnThirdInvItm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(thirdItemTitle));
        driver.findElement(thirdItemTitle).click();
    }
    public void clickOnFourhInvItm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fourthItemTitle));
        driver.findElement(fourthItemTitle).click();
    }
    public void clickOnFifthInvItm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fifthItemTitle));
        driver.findElement(fifthItemTitle).click();
    }
    public void clickOnSixthInvItm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sixthItemTitle));
        driver.findElement(sixthItemTitle).click();
    }
    public void clickOnBackToProducts(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(backToProductsButton));
        driver.findElement(backToProductsButton).click();
    }

    // Hard Assert methods that verify if the item displayed on the Inventory page list is the same one with the item's container page.
    public void firstItemTitleAssert(){
        String InvFirstItmTitle = getFirstInvItemTitle();
        System.out.println(getFirstInvItemTitle());
        clickOnFirstInvItem();
        String ContainerItemTitle = getItemContainerTitleText();
        System.out.println(getItemContainerTitleText());
        Assert.assertEquals(InvFirstItmTitle, ContainerItemTitle);
        clickOnBackToProducts();
    }
    public void secondItemTitleAssert(){
        String InvSecondItmTitle = getSecondInvItemTitle();
        System.out.println(getSecondInvItemTitle());
        driver.findElement(secondItemTitle).click();
        String ContainerItemTitle = getItemContainerTitleText();
        System.out.println(getItemContainerTitleText());
        Assert.assertEquals(InvSecondItmTitle,ContainerItemTitle);
        clickOnBackToProducts();
    }
    public void thirdItemTitleAssert(){
        String InvThirdItmTitle = getThirdInvItemTitle();
        System.out.println(getThirdInvItemTitle());
        driver.findElement(thirdItemTitle).click();
        String ContainerItemTitle = getItemContainerTitleText();
        System.out.println(getItemContainerTitleText());
        Assert.assertEquals(InvThirdItmTitle,ContainerItemTitle);
        clickOnBackToProducts();
    }
    public void fourthItemTitleAssert(){
        String InvFourthItmTitle = getFourthInvItemTitle();
        System.out.println(getFourthInvItemTitle());
        driver.findElement(fourthItemTitle).click();
        String ContainerItemTitle = getItemContainerTitleText();
        System.out.println(getItemContainerTitleText());
        Assert.assertEquals(InvFourthItmTitle,ContainerItemTitle);
        clickOnBackToProducts();
    }
    public void fifthItemTitleAssert(){
        String InvFifthItmTitle = getFifthInvItemTitle();
        System.out.println(getFifthInvItemTitle());
        driver.findElement(fifthItemTitle).click();
        String ContainerItemTitle = getItemContainerTitleText();
        System.out.println(getItemContainerTitleText());
        Assert.assertEquals(InvFifthItmTitle,ContainerItemTitle);
        clickOnBackToProducts();
    }
    public void sixthItemTitleAssert(){
        String InvSixthItmTitle = getSixthInvItemTitle();
        System.out.println(getSixthInvItemTitle());
        driver.findElement(sixthItemTitle).click();
        String ContainerItemTitle = getItemContainerTitleText();
        System.out.println(getItemContainerTitleText());
        Assert.assertEquals(InvSixthItmTitle, ContainerItemTitle);
        clickOnBackToProducts();
    }
    // Method which includes all hard assert methods
    public void pageItemsAsserts(){
        firstItemTitleAssert();
        secondItemTitleAssert();
        thirdItemTitleAssert();
        fourthItemTitleAssert();
        fifthItemTitleAssert();
        sixthItemTitleAssert();
    }

    //Methods that will return picture's unique(or not) URL, respectively the "src" attribute value
    public String getFirstItemImgAttribute(){
        return getAttributeValue(driver.findElement(firstItmImg), "src");
    }
    public String getSecondItemImgAttribute(){
        return getAttributeValue(driver.findElement(secondItmImg),"src");
    }
    public String getThirdItemImgAttribute(){
        return getAttributeValue(driver.findElement(thirdItmImg),"src");
    }
    public String getFourthItemImgAttribute(){
        return getAttributeValue(driver.findElement(fourthItmImg),"src");
    }
    public String getFifthItemImgAttribute(){
        return getAttributeValue(driver.findElement(fifthItmImg),"src");
    }
    public String getSixthItemImgAttribute(){
        return getAttributeValue(driver.findElement(sixthItmImg),"src");
    }


    //Methods that will return Add/Remove button "data-test" attribute
    public String getBikeLightDataTestAttributeValue(){
        return getAttributeValue(driver.findElement(bikeLightAddToCartFullXpath), "data-test");
    }
    public String getBoltTShirtDataTestAtrbVal(){
        return getAttributeValue(driver.findElement(boltTshirtAddnRemoveFullXpathBtn),"data-test");
    }
    public String getBackpackDataTestAtrbVal(){
        return getAttributeValue(driver.findElement(backpackAddnRemoveFullXpathBtn),"data-test");
    }
    public String getFleeceJktDataTestAtrbVal(){
        return getAttributeValue(driver.findElement(fleeceJacketAddnRemoveFullXpathBtn),"data-test");
    }
    public String getOnesieDataTestAtrbVal(){
        return getAttributeValue(driver.findElement(onesieAddnRemoveFullXpathBtn),"data-test");
    }
    public String getTShirtRdataTestAtrbVal(){
        return getAttributeValue(driver.findElement(tShirtRedAddnRemoveFullXpathBtn),"data-test");
    }




}





