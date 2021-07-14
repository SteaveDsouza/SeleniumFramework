package com.steave.pages;

import com.steave.driver.DriverManager;
import com.steave.enums.WaitStrategy;
import com.steave.factories.ExplicitWaitFactory;
import com.steave.reports.ExtentLogger;
import org.openqa.selenium.By;

public class BasePage{

    protected void click(By elementName , WaitStrategy strategy, String nameOfElement) throws Exception{
        ExplicitWaitFactory.performExplicitWait( strategy ,elementName ).click();
        ExtentLogger.pass( nameOfElement + " Was clicked successfully" , true);
    }

    protected void sendKeys(By elementName , String value, WaitStrategy strategy, String nameOfElement ) throws Exception{
       ExplicitWaitFactory.performExplicitWait( strategy,elementName ).sendKeys( value );
        ExtentLogger.pass( value + " Was entered successfully in " + nameOfElement , true);
    }

    protected String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
