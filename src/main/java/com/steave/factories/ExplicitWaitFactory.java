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
        return switch (strategy) {
            case CLICKABLE -> new WebDriverWait( DriverManager.getDriver(), FrameWorkConstants.getExplicitWait() ).until( ExpectedConditions.elementToBeClickable( value ) );
            case PRESENCE -> new WebDriverWait( DriverManager.getDriver(), FrameWorkConstants.getExplicitWait() ).until( ExpectedConditions.presenceOfElementLocated( value ) );
            case VISIBLE -> new WebDriverWait( DriverManager.getDriver(), FrameWorkConstants.getExplicitWait() ).until( ExpectedConditions.visibilityOfElementLocated( value ) );
            case NONE -> DriverManager.getDriver().findElement( value );
        };
    }
}
