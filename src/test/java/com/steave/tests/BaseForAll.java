package com.steave.tests;

import com.steave.driver.Driver;
import com.steave.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseForAll{

    protected BaseForAll(){}

    @BeforeSuite
    public void beforeSuiteSetup(){
        ExtentReport.initReports();
    }

    @BeforeMethod
    protected void setUp() throws Exception{ Driver.initDriver(); }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }


    @AfterSuite
    public void afterSuite() throws IOException{
        ExtentReport.flushReports();
    }
}
