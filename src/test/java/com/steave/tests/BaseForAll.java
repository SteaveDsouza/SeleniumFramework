package com.steave.tests;

import com.steave.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseForAll{

    protected BaseForAll(){}

    @SuppressWarnings( "unchecked" )
    @BeforeMethod
    protected void setUp(Object[] data) throws Exception{
        Map<String,String> map = (Map<String,String>)data[0];
        Driver.initDriver(map.get( "browser" ));
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }

}
