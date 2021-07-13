package com.steave.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport{

    private ExtentReport(){}

    private static ExtentReports extent;


    public static void initReports(){

        if (Objects.isNull( extent )) {
            extent =new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter( "index.html" );
            extent.attachReporter( spark );
            spark.config().setTheme( Theme.DARK );
            spark.config().setDocumentTitle( "Orange HRM Automation" );
            spark.config().setReportName( "Login Regression" );
        }
    }

    public static void flushReports() throws IOException{
        if (Objects.nonNull( extent )) {
            extent.flush();
            Desktop.getDesktop().browse( new File( "index.html").toURI() );
        }
    }

    public static void createTest(String testcasename){
        ExtentManager.setExtTest( extent.createTest( testcasename ) );
    }

}
