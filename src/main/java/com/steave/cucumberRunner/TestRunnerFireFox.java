package com.steave.cucumberRunner;

import com.aventstack.extentreports.ExtentTest;
import com.steave.constants.FrameWorkConstants;
import com.steave.driver.Driver;
import com.steave.listener.Reporter;
import com.steave.utils.PropertyUtils;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.steave.stepdefs"},
        plugin = { "com.steave.listener.ExtentCucumberFormatter:extent-test-output/index.html"},
        tags = {"@Sanity_Test"}
        )

public class TestRunnerFireFox{
    private TestNGCucumberRunner testNGCucumberRunner;

    ExtentTest extent ;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        Driver.initDriver( "firefox" );
    }


    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        testNGCucumberRunner.finish();
        Driver.quitDriver();
    }

    @AfterSuite
    public void finalTeardown() throws Exception{
        Reporter.loadXMLConfig( new File( PropertyUtils.getReportConfigPath()) );
        try {
            Desktop.getDesktop().browse( new File( FrameWorkConstants.getExtentReportPath()).toURI() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}