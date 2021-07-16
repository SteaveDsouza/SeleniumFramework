package com.steave.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.steave.constants.FrameWorkConstants;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReport{

    private ExtentReport(){}

    private static ExtentReports extent;


    public static void initReports() throws Exception{

        if (Objects.isNull( extent )) {
            extent = new ExtentReports();
            var spark = new ExtentSparkReporter( FrameWorkConstants.getExtentReportPath() );
            extent.attachReporter( spark );
            spark.config().setTheme( Theme.DARK );
            spark.config().setDocumentTitle( "Orange HRM Automation" );
            spark.config().setReportName( "Login Regression" );
        }
    }

    public static void flushReports() throws Exception{
        if (Objects.nonNull( extent )) {
            extent.flush();
            ExtentManager.unload();
        }
        Desktop.getDesktop().browse( new File( FrameWorkConstants.getExtentReportPath()).toURI() );
    }

    public static void createTest(String testcasename){
        ExtentManager.setExtTest( extent.createTest( testcasename ) );
    }

}
