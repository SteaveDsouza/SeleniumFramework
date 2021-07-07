package com.steave.tests;

import com.steave.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseForAll{

    @Test
    public void test3(){
        System.out.println(Thread.currentThread().getId() + " in test 3 " + DriverManager.getDriver());
        DriverManager.getDriver().findElement( By.name( "q" ) ).sendKeys( "Automation", Keys.ENTER );
    }
}