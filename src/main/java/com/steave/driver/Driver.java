package com.steave.driver;

import com.steave.enums.ConfigProperties;
import com.steave.exceptions.BrowserInvocationFailed;
import com.steave.factories.DriverFactory;
import com.steave.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver{

    private Driver(){}

    public static void initDriver(String browser) {

        if (Objects.isNull( DriverManager.getDriver()) ) {
            try {
                DriverManager.setDriver( DriverFactory.getDriver( browser ) );
                DriverManager.getDriver() .manage().window().maximize();
            } catch (MalformedURLException | NullPointerException e) {
                throw new BrowserInvocationFailed( "Please validate the Capabilities in DriverFactory class, Browser invocation failed",e);
            }
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
