package com.steave.driver;

import com.steave.constants.FrameWorkConstants;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver{

    private Driver() {}

    public static void initDriver(){

        if (Objects.isNull( DriverManager.getDriver()) ) {
            System.setProperty( "webdriver.chrome.driver", FrameWorkConstants.getChromeDriverPath() );
            DriverManager.setDriver( new ChromeDriver() );
            DriverManager.getDriver().get( "https://google.com" );
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull( DriverManager.getDriver() )) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
