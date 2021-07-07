package com.steave.tests;

import com.steave.driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseForAll{

    @BeforeClass
    public void setUp2(){
        Driver.initDriver();
    }

    @AfterClass
    public void tearDown2(){
        Driver.quitDriver();
    }
}
