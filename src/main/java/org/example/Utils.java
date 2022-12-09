package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Utils extends BasePage {

    public static void clickOnElement(By by) {
        by.findElement(driver).click();
    }

    public static void sendkey(By by, String text) {
        by.findElement(driver).sendKeys(text);
    }

    public static void driverWaitUntilURLToBeClickable(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public static void WaitUntilExpectedURL(int time, String url) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait1.until(ExpectedConditions.urlToBe(url));


    }

}

