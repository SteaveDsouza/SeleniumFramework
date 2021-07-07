package com.steave.tests;

import com.steave.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseForAll{

    private HomePageTest(){ }


    @Test
    public void test3(){
        System.out.println(Thread.currentThread().getId() + " :(In Test3) " + DriverManager.getDriver());
        DriverManager.getDriver().findElement( By.name( "q" ) ).sendKeys( "Automation", Keys.ENTER );
    }
}