package com.steave.cucumberRunner;

import com.steave.driver.Driver;
import com.steave.utils.PropertyUtils;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

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
        System.out.println("In Before class");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        Driver.initDriver( "chrome" );
    }


    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        System.out.println("in Data Provider");
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
        Reporter.loadXMLConfig( new File( PropertyUtils.getReportConfigPath()) );
        Driver.quitDriver();
    }
}