package com.steave.tests;

import com.steave.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HomePageTest extends BaseForAll{

    private HomePageTest(){}

    @Test
    public static void test3(){
        DriverManager.getDriver().findElement( By.name( "q" ) ).sendKeys( "Testing mini bytes - Youtube", Keys.ENTER );
        List<WebElement> elements = DriverManager.getDriver().findElements( By.xpath( "//h3" ) );
        AtomicBoolean isElement = new AtomicBoolean( false );
        elements.forEach( element -> {
            if(element.getText().equalsIgnoreCase( "Testing mini bytes - Youtube" )){
                isElement.set( true );
            }
        } );
        String title = DriverManager.getDriver().getTitle();
        Assert.assertEquals( elements.size(), 10 );
        Assert.assertTrue( Objects.nonNull( title ) );
        Assert.assertTrue( title.length() > 10 );
        Assert.assertTrue( title.length() < 100 );
        Assert.assertTrue( title.toLowerCase().contains( "google search" ) );
        Assert.assertTrue( isElement.get() );
    }
}