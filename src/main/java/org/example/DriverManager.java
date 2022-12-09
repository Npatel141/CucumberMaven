package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DriverManager extends Utils{
@Test

    public void  openBrowser(){

    System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver1.exe");
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://demo.nopcommerce.com/");
    }

    public  void closeBrowser(){
        driver.quit();
    }
}
