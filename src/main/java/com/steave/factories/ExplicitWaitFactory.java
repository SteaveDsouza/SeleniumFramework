package com.steave.factories;

import com.steave.constants.FrameWorkConstants;
import com.steave.driver.DriverManager;
import com.steave.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitFactory{

    private ExplicitWaitFactory(){}

    public static WebElement performExplicitWait(WaitStrategy strategy , By value){
        if(strategy == WaitStrategy.CLICKABLE){
           return new WebDriverWait( DriverManager.getDriver(), FrameWorkConstants.getExplicitWait() ).until( ExpectedConditions.elementToBeClickable( value ) );
        }
        else if(strategy == WaitStrategy.PRESENCE){
            return new WebDriverWait( DriverManager.getDriver(), FrameWorkConstants.getExplicitWait() ).until( ExpectedConditions.presenceOfElementLocated( value ) );
        }
        else if(strategy == WaitStrategy.VISIBLE){
           return new WebDriverWait( DriverManager.getDriver(), FrameWorkConstants.getExplicitWait() ).until( ExpectedConditions.visibilityOfElementLocated( value ) );
        }
        else if(strategy == WaitStrategy.NONE){
            return DriverManager.getDriver().findElement(value);
        }else{
            return null;
        }
    }
}
