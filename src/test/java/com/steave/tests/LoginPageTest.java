package com.steave.tests;


import com.steave.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public final class LoginPageTest extends BaseForAll{

    private LoginPageTest(){}

    @Test
    public static void firstTest(){
        DriverManager.getDriver().findElement( By.name("q") ).sendKeys( "Testing mini bytes", Keys.ENTER );
    }

}
