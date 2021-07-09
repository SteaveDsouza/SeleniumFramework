package com.steave.pages;

import org.openqa.selenium.By;

public final class OrangeLoginPage extends BasePage{

    private final By textboxUsername = By.id( "txtUsername" );
    private final By textboxPassword = By.xpath( "//input[@id='txtPassword' and @type='password']" );
    private final By btnLogin = By.xpath( "//input[@id='btnLogin' and @value='LOGIN']" );

    public OrangeLoginPage enterUsername(String username){
       sendKeys( textboxUsername,username );
        return this;
    }

    public OrangeLoginPage enterPassword(String password){
       sendKeys( textboxPassword,password );
        return this;
    }

    public OrangeHomePage submitForm(){
        click( btnLogin );
        return new OrangeHomePage();
    }

    public String getPageTitle(){
        return getTitle();
    }
}
