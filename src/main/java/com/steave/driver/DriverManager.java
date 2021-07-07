package com.steave.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverManager{

    private DriverManager(){}

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();


    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void setDriver(WebDriver driver){
        if(Objects.nonNull( driver)) dr.set( driver );
    }

    public static void unload(){
        dr.remove();
    }
}
