package com.steave.cucumberRunner;

import com.steave.constants.FrameWorkConstants;
import com.steave.driver.Driver;
import com.steave.listener.Reporter;
import com.steave.utils.PropertyUtils;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.steave.stepdefs"},
        plugin = { "com.steave.listener.ExtentCucumberFormatter:extent-test-output/index.html"},
        tags = {"@loginLogoutTest"}
        )

public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite(alwaysRun = true)
    public void tryingStuff(ITestContext context){
        System.out.println("In before Suite");
        Arrays.stream( context.getIncludedGroups() ).forEach( System.out::println );
    }

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String browser ){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        System.out.println("In Before Class");
        Driver.initDriver( browser );
    }



    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println("In Test Class");
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());

    }

    @DataProvider
    public Object[][] features() {
        System.out.println("In Data Provider");
        return testNGCucumberRunner.provideFeatures();
    }


    @Parameters({"browser"})
    @AfterClass(alwaysRun = true)
    public void tearDownClass(String browser){
        System.out.println("In after class");
        if(browser.equalsIgnoreCase( "chrome" )){
            Reporter.assignCategory( "@Chrome" );
        }else if(browser.equalsIgnoreCase( "firefox" )){
            Reporter.assignCategory( "@FireFox" );
        }
        testNGCucumberRunner.finish();
        Driver.quitDriver();
    }


    @AfterSuite(alwaysRun=true)
    public void finalTeardown() throws Exception{
        System.out.println("In after Suite");
        Reporter.loadXMLConfig( new File( PropertyUtils.getReportConfigPath()) );
        try {
            Desktop.getDesktop().browse( new File( FrameWorkConstants.getExtentReportPath()).toURI() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Factory
    public Object[] getTestsFromFile(ITestContext context){
        System.out.println( " in Factory");
        return null;
    }


}