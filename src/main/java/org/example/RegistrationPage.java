package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RegistrationPage extends Utils{
    private By firstName = By.id("FirstName");
    private By lastName=By.id("LastName");
    private By email=By.id("Email");
    private By companyName= By.xpath("//input[contains(@name,'Company')]");
    private By password=By.id("Password");
    private By confirmPassword=By.name("ConfirmPassword");
    private By registerButton=By.xpath("//button[@id=\"register-button\"]");
@Test
    public  void verifyUserIsOnRegistrationPage(){
        WaitUntilExpectedURL(20,"https://demo.nopcommerce.com/register?returnUrl=%2F");

    }
    public void userFillRegistrationForm(){
        //select gender
        driver.findElement(By.xpath("//input[@id=\"gender-male\"]")).click();
        sendkey(firstName,"Nipa");
        sendkey(lastName,"Patel");
        sendkey(email,"nipa.patel1988@gmail.com");
        sendkey(companyName,"ABC");
        sendkey(password,"abc123");
        sendkey(confirmPassword,"abc123");

    }
    public void userclickOnRegisterButton(){
        clickOnElement(registerButton);
    }

}
