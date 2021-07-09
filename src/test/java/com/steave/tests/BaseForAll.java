package com.steave.tests;

import com.steave.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseForAll{

    protected BaseForAll(){}

    @BeforeMethod
    protected void setUp2() throws Exception{ Driver.initDriver(); }

    @AfterMethod
    protected void tearDown2(){
        Driver.quitDriver();
    }
}
