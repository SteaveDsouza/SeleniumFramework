package com.steave.tests;


import com.steave.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseForAll{

    private LoginPageTest(){ }

    @Test
    public void seleniumTest(){
        System.out.println(Thread.currentThread().getId() + " :(In SeleniumTest) " + DriverManager.getDriver());
        DriverManager.getDriver().findElement( By.name( "q" ) ).sendKeys( "Selenium Automation", Keys.ENTER );
    }
}
