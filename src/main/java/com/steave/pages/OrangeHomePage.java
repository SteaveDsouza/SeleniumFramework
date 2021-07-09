package com.steave.pages;

import com.steave.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHomePage extends BasePage{

    private final By linkWelcome = By.id( "welcome" );
    private final By linkLogout = By.xpath( "//a[text()='Logout']" );



    public OrangeLoginPage logoutFromApp(){
        click( linkWelcome, WaitStrategy.CLICKABLE );
        click( linkLogout, WaitStrategy.CLICKABLE );
        return new OrangeLoginPage();
    }
}
