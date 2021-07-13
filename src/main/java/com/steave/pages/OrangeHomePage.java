package com.steave.pages;

import com.steave.enums.WaitStrategy;
import com.steave.reports.ExtentManager;
import org.openqa.selenium.By;

public final class OrangeHomePage extends BasePage{

    private final By linkWelcome = By.id( "welcome" );
    private final By linkLogout = By.xpath( "//a[text()='Logout']" );



    public OrangeLoginPage logoutFromApp(){
        click( linkWelcome, WaitStrategy.CLICKABLE );
        ExtentManager.getExtTest().pass( "Welcome Link Clicked" );
        click( linkLogout, WaitStrategy.CLICKABLE );
        ExtentManager.getExtTest().pass( "Logout Link Clicked" );
        return new OrangeLoginPage();
    }
}
