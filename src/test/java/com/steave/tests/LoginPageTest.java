package com.steave.tests;


import com.steave.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public final class LoginPageTest extends BaseForAll{

    @Test
    public void firstTest(){
        System.out.println(Thread.currentThread().getId() + " in first Test " + DriverManager.getDriver());
        DriverManager.getDriver().findElement( By.name("q") ).sendKeys( "Testing mini bytes", Keys.ENTER );
    }

    @Test
    public void firstTest2(){
        System.out.println(Thread.currentThread().getId() + " in first Test 2" + DriverManager.getDriver());
        DriverManager.getDriver().findElement( By.name("q") ).sendKeys( "Testng SureFire", Keys.ENTER );
    }
}
