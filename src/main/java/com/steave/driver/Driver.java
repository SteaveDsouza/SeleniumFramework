package com.steave.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver{

    private Driver(){}

    public static void initDriver(String browser) {

        if (Objects.isNull( DriverManager.getDriver()) ) {
            if(browser.equalsIgnoreCase( "chrome" )){
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver( new ChromeDriver() );
            }else if(browser.equalsIgnoreCase( "firefox" )){
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver( new FirefoxDriver() );
            }
            DriverManager.getDriver().manage().window().maximize();
            //DriverManager.getDriver().get( PropertyUtils.get( ConfigProperties.URL) );

        }
    }

    public static void quitDriver(){
        if (Objects.nonNull( DriverManager.getDriver() )) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
