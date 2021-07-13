package com.steave.pages;

import com.steave.enums.WaitStrategy;
import com.steave.reports.ExtentManager;
import org.openqa.selenium.By;

public final class OrangeLoginPage extends BasePage{

    private final By textboxUsername = By.id( "txtUsername" );
    private final By textboxPassword = By.xpath( "//input[@id='txtPassword' and @type='password']" );
    private final By btnLogin = By.xpath( "//input[@id='btnLogin' and @value='LOGIN']" );

    public OrangeLoginPage enterUsername(String username){
       sendKeys( textboxUsername, username , WaitStrategy.PRESENCE );
        ExtentManager.getExtTest().pass( "Username Entered" );
        return this;
    }

    public OrangeLoginPage enterPassword(String password){
       sendKeys( textboxPassword, password , WaitStrategy.PRESENCE );
        ExtentManager.getExtTest().pass( "Password Entered" );
        return this;
    }

    public OrangeHomePage submitForm(){
        click( btnLogin, WaitStrategy.CLICKABLE );
        ExtentManager.getExtTest().pass( "Login Button Clicked" );
        return new OrangeHomePage();
    }

    public String getPageTitle(){
        return getTitle();
    }
}
