package com.steave.factories;

import com.steave.enums.ConfigProperties;
import com.steave.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory{

    private DriverFactory(){}

    public static RemoteWebDriver getDriver(String browser) throws MalformedURLException{

        String runMode = PropertyUtils.get( ConfigProperties.RUNREMOTE );

        if(browser.equalsIgnoreCase( "chrome" ) && runMode.equalsIgnoreCase( "yes" )){
            ChromeOptions options = new ChromeOptions();
            options.addArguments( "--no-sandbox" );
            options.addArguments( "--disable-dev-shm-usage" );
           // options.addArguments( "--headless" );
            return ( new RemoteWebDriver( new URL( "http://localhost:4444/wd/hub" ), options ) );
        }else if((browser.equalsIgnoreCase( "chrome" ) && runMode.equalsIgnoreCase( "no" ))){
            WebDriverManager.chromedriver().setup();
            return ( new ChromeDriver() );
        }

        if(browser.equalsIgnoreCase( "firefox" ) && runMode.equalsIgnoreCase( "yes" )){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments( "--no-sandbox" );
            options.addArguments( "--disable-dev-shm-usage" );
           // options.addArguments( "--headless" );
            return ( new RemoteWebDriver( new URL( "http://localhost:4444/wd/hub" ), options ) );
        }else if(browser.equalsIgnoreCase( "firefox" ) && runMode.equalsIgnoreCase( "no" )){
            WebDriverManager.firefoxdriver().setup();
            return ( new FirefoxDriver() );
        }

        return null;
    }

}
