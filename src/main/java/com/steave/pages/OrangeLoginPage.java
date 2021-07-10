package com.steave.pages;

import com.steave.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeLoginPage extends BasePage{

    private final By textboxUsername = By.id( "txtUsername" );
    private final By textboxPassword = By.xpath( "//input[@id='txtPassword' and @type='password']" );
    private final By btnLogin = By.xpath( "//input[@id='btnLogin' and @value='LOGIN']" );

    public OrangeLoginPage enterUsername(String username){
       sendKeys( textboxUsername, username , WaitStrategy.PRESENCE );
        return this;
    }

    public OrangeLoginPage enterPassword(String password){
       sendKeys( textboxPassword, password , WaitStrategy.PRESENCE );
        return this;
    }

    public OrangeHomePage submitForm(){
        click( btnLogin, WaitStrategy.CLICKABLE );
        return new OrangeHomePage();
    }

    public String getPageTitle(){
        return getTitle();
    }
}
