package com.steave.tests;

import com.steave.driver.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseForAll{

    protected BaseForAll(){ }

    @BeforeTest
    protected void setUp(){
        Driver.initDriver();
    }

    @AfterTest
    protected void tearDown(){
        Driver.quitDriver();
    }
}
