package org.example;

public class Hooks extends Utils {
    DriverManager driverManager=new DriverManager();

    public void setUP(){
        driverManager.openBrowser();
    }
    public void tearDown(){
        driverManager.closeBrowser();
    }
}
