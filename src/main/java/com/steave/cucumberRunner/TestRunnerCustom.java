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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.steave.stepdefs"},
        plugin = { "com.steave.listener.ExtentCucumberFormatter:extent-test-output/index.html"},
        tags = {"@loginLogoutTest"}
        )

public class TestRunnerCustom{
    private TestNGCucumberRunner testNGCucumberRunner;
    private List<String> includeTags = new ArrayList<>();

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String browser){
        System.out.println("In before class");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        Driver.initDriver( browser );
    }



    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println("in Tests");
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }


    @Parameters({"browser"})
    @AfterClass(alwaysRun = true)
    public void tearDownClass(String browser){
        System.out.println("in After Tests");
        if(browser.equalsIgnoreCase( "chrome" )){
            Reporter.assignCategory( "@Chrome" );
        }else if(browser.equalsIgnoreCase( "firefox" )){
            Reporter.assignCategory( "@FireFox" );
        }
        testNGCucumberRunner.finish();
        Driver.quitDriver();
    }


    @AfterSuite
    public void finalTeardown() throws Exception{
        System.out.println("in After Suite");
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
        if( Objects.nonNull(context)){
            this.includeTags = Arrays.asList( context.getIncludedGroups() );
            includeTags.forEach( System.out::println );
        }
        return null;
    }

}