package com.steave.tests;

import com.steave.driver.DriverManager;
import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public final class HomePageTest extends BaseForAll{

    private HomePageTest(){}

    @Test
    public void test3(){
        DriverManager.getDriver().findElement( By.name( "q" ) ).sendKeys( "Testing mini bytes - Youtube", Keys.ENTER );
        List<WebElement> elements = DriverManager.getDriver().findElements( By.xpath( "//h3" ) );
        String title = DriverManager.getDriver().getTitle();

        assertThat( title )
                .containsIgnoringCase( "google search" )
                .isNotNull()
                .hasSizeBetween( 10,100 );

        assertThat( elements )
                .isNotNull()
                .hasSizeBetween( 2,15 )
                .anyMatch( webElement -> webElement.getText().equalsIgnoreCase( "Testing mini bytes - Youtube" ) );
    }
}