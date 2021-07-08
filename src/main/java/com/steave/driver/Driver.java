package com.steave.driver;

import com.steave.constants.FrameWorkConstants;
import com.steave.utils.ReadPropertyFile;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver{

    private Driver(){}

    public static void initDriver() throws Exception{

        if (Objects.isNull( DriverManager.getDriver()) ) {
            System.setProperty( "webdriver.chrome.driver", FrameWorkConstants.getChromeDriverPath() );
            DriverManager.setDriver( new ChromeDriver() );
            DriverManager.getDriver().get( ReadPropertyFile.get("url") );
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull( DriverManager.getDriver() )) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
