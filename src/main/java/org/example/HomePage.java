package org.example;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePage extends Utils{
    private By clickRegister=By.className("ico-register");
@Test
    public void useClickOnRegistrationButton(){
    clickOnElement(clickRegister);
    }
}
