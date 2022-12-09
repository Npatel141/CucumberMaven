package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class TestSuit {
    protected static WebDriver driver;
    private static By clickRegister = By.className("ico-register");
    private static By firstName = By.id("FirstName");
    private static By lastName = By.id("LastName");
    private static By email = By.id("Email");
    private static By companyName = By.xpath("//input[contains(@name,'Company')]");
    private static By password = By.id("Password");
    private static By confirmPassword = By.name("ConfirmPassword");
    private static By registerButton = By.xpath("//button[@id=\"register-button\"]");
    private static By selectGender = By.xpath(("//label[.=\"Male\"]/preceding::input[contains(@id,'gender-male')]"));
    private static By computer=By.xpath("//ul[contains(@class,'top-menu notmobile')]//li[1]//a[contains(text(),'Computers')]");
    private static By desktop=By.xpath("//div[@class=\"item-grid\"]/div/div/h2/a[contains(text(),' Desktops ')]");
    private static By buildYourOwnComputer=By.xpath("//h2//a[contains(text(),'Build your own computer')]");
    private static By selectPrrocessor=By.xpath("//select[@id=\"product_attribute_1\"]");
    private  static By selectRAM=By.xpath("//select[@id=\"product_attribute_2\"]");
    private static By selectHDD= By.xpath("//input[@name=\"product_attribute_3\" and@value=\"7\"]");
    private static By selectOS=By.xpath("//input[@id=\"product_attribute_4_9\"]");
    private static By addToCartBotton=By.xpath("//button[@id=\"add-to-cart-button-1\"]");
    private static By shoppingCart=By.xpath("//span[contains(text(),'Shopping cart')]");
    private static By currency=By.id("customerCurrency");

    @Test(priority = 0)
    public void userShouldBeAbleToRegisterSuccessfully() {
        //click on regstration button
        driver.findElement(By.className("ico-register")).click();
        //Enter registration details
        clickOnElement(clickRegister);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("register"), "Your registration URL is wrong");
        waitUntilURLToBe(20, "https://demo.nopcommerce.com/register?returnUrl=%2F");
        selectGender();
        //clickOnElement(selectGender);
        typeText(firstName, "Nipa");
        typeText(lastName, "patel");
        selectByVisibleText(By.xpath("//select[@name=\"DateOfBirthDay\"]"), "14");
        selectByVisibleText(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "October");
        selectByVisibleText(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "1988");
        System.out.println(randomDate());
        typeText(email, "nipa" + randomDate() + "@yahoo.com");
        typeText(companyName, "ABC");
        typeText(password, "xyz123");
        typeText(confirmPassword, "xyz123");
        clickOnElement(registerButton);
        String expectedresult = "Your registration completed";
        System.out.println("expectedresult:" + expectedresult);
        String actualResult = getTextFromElement(By.className("result"));
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedresult, "My test case is pass");
    }
//***************************************************------------------------------------------------********************************
    @Test(priority = 1)
    public void addProductToTheCart(){
        clickOnElement(computer);
        String actualURL= driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains("computers"),"you're URL is not correct");
        clickOnElement(desktop);
        String desktopURL=driver.getCurrentUrl();
        Assert.assertTrue(desktopURL.contains("desktops"),"You're URL is not correct");
        clickOnElement(buildYourOwnComputer);
        String message= driver.getTitle();
        System.out.println(message);
        Assert.assertTrue(message.contains("Build your own computer"),"You're no on the right page");
        selectByVisibleText((selectPrrocessor),"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
        selectByVisibleText((selectRAM),"8GB [+$60.00]");
        clickOnElement(selectHDD);
        clickOnElement(selectOS);
        clickOnElement(By.xpath("//input[@id=\"product_attribute_5_12\"]"));
        clickOnElement(By.xpath("//ul[@data-attr=\"5\"and@class=\"option-list\"]/li[2]/input"));
        clickOnElement(addToCartBotton);
        clickOnElement(By.xpath("//span[@title=\"Close\"]"));
        clickOnElement(shoppingCart);
        String actualProductText=getTextFromElement((By.xpath("//td//a[contains(text(),'Build your own computer')]")));
        String expectedPrroductText="Build your own computer";
        Assert.assertEquals(actualProductText,expectedPrroductText);
        String actualText=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        String expectText="Shopping cart";
        Assert.assertEquals(actualText,expectText);


       // WebElement ele=driver.findElement(By.xpath(""));
    }
    @Test(priority=2)
    public void selectCurrency(){
       selectByVisibleText(currency,"US Dollar");


    }
    //***********************************************----------------------------------------------------**************************
    //Reusable Methods
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
        String strDate = format.format(date);
        return format.format(date);
        //System.out.println(strDate);
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    public static void waitUntilURLToBe(int time, String URL) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait1.until(ExpectedConditions.urlToBe(URL));
    }

    public static void waitUntilElementToBeVisible(int time, By by) {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.elementToBeClickable(by));
        wait2.until(ExpectedConditions.alertIsPresent());
    }

    public static void selectByVisibleText(By by, String text) {
        Select dropdownbytext = new Select(driver.findElement(by));
        dropdownbytext.selectByVisibleText(text);

    }

    public static void selectByValue(By by, String value) {
        Select dropdownbyValue = new Select(driver.findElement(by));
        dropdownbyValue.selectByValue(value);
    }

    public static void selectByIndex(By by, int index) {
        Select dropDownByIndex = new Select(driver.findElement(by));
        dropDownByIndex.selectByIndex(index);
    }

    public static void getSelectedOptio(By by) {
        Select getSelectedoption = new Select(driver.findElement(by));
        getSelectedoption.getFirstSelectedOption();
    }

    public static void selectGender() {
        WebElement ele = driver.findElement(By.xpath("//input[@id=\"gender-male\"]"));
        if (!ele.isSelected()) {
            ele.click();
            System.out.println("Radio button is not selected");
        } else {
            System.out.println("Radio button is selected");
        }

    }
//    public static void selectCheckbox(){
//        WebElement ele=driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
//        for(int i=0;i<=2;i++){
//            if(!ele.isSelected()){
//                ele.click();
//            }else{
//                System.out.println("Element is selected");
//            }
//        }
//    }
    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver1.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();

    }
    public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }
}

