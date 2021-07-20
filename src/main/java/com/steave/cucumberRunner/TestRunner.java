package com.steave.cucumberRunner;

import com.steave.constants.FrameWorkConstants;
import com.steave.driver.Driver;
import com.steave.utils.PropertyUtils;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.steave.stepdefs"},
        plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:extent-test-output/index.html"},
        tags = {"@Sanity_Test"}
        )

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        Driver.initDriver( "chrome" );

    }


    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        Reporter.assignAuthor( "Chrome" );
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
}