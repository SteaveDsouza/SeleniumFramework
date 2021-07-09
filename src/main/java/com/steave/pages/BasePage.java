package com.steave.pages;

import com.steave.driver.DriverManager;
import com.steave.enums.WaitStrategy;
import com.steave.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class BasePage{

    protected void click(By elementName , WaitStrategy strategy){
        ExplicitWaitFactory.performExplicitWait( strategy,elementName ).click();
    }

    protected void sendKeys(By elementName , String value, WaitStrategy strategy){
       ExplicitWaitFactory.performExplicitWait( strategy,elementName ).sendKeys( value );
    }

    protected String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
