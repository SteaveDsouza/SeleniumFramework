package com.steave.pages;

import com.steave.constants.FrameWorkConstants;
import com.steave.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{

    protected void click(By elementName){
        new WebDriverWait( DriverManager.getDriver(), FrameWorkConstants.getExplicitWait() ).until( ExpectedConditions.elementToBeClickable( elementName ) ).click();
    }

    protected void sendKeys(By elementName , String value){
        new WebDriverWait( DriverManager.getDriver(),FrameWorkConstants.getExplicitWait() ).until( ExpectedConditions.presenceOfElementLocated( elementName ) ).sendKeys( value );
    }

    protected String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
