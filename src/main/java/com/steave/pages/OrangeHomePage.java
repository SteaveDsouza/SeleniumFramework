package com.steave.pages;

import com.steave.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHomePage extends BasePage{

    private final By linkWelcome = By.id( "welcome" );
    private final By linkLogout = By.xpath( "//a[text()='Logout']" );

    public OrangeLoginPage logoutFromApp() throws Exception{
        click( linkWelcome , WaitStrategy.CLICKABLE , "Welcome Link" );
        click( linkLogout, WaitStrategy.CLICKABLE, "Logout Link" );
        return new OrangeLoginPage();
    }
}
