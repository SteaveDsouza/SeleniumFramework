package com.steave.driver;

import com.steave.constants.FrameWorkConstants;
import com.steave.enums.ConfigProperties;
import com.steave.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver{

    private Driver(){}

    public static void initDriver(String browser) throws Exception{

        if (Objects.isNull( DriverManager.getDriver()) ) {
            if(browser.equalsIgnoreCase( "chrome" )){
                System.setProperty( "webdriver.chrome.driver", FrameWorkConstants.getChromeDriverPath() );
                DriverManager.setDriver( new ChromeDriver() );
            }else if(browser.equalsIgnoreCase( "firefox" )){
                System.setProperty( "webdriver.gecko.driver", FrameWorkConstants.getFireFoxDriverPath() );
                DriverManager.setDriver( new FirefoxDriver() );
            }
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get( PropertyUtils.get( ConfigProperties.URL) );

        }
    }

    public static void quitDriver(){
        if (Objects.nonNull( DriverManager.getDriver() )) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
