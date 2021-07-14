package com.steave.listeners;

import com.steave.reports.ExtentLogger;
import com.steave.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener{

    @Override
    public void onStart(ISuite suite){
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onFinish(ISuite suite){
        try {
            ExtentReport.flushReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result){
        ExtentReport.createTest( result.getMethod().getMethodName() );
    }

    @Override
    public void onTestSuccess(ITestResult result){
        try {
            ExtentLogger.pass( result.getMethod().getMethodName() + " is passed" ,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result){
        try {
            ExtentLogger.fail( result.getMethod().getMethodName() + " is failed",true );
            ExtentLogger.fail( result.getThrowable().toString() );
           // ExtentLogger.fail( Arrays.toString( result.getThrowable().getStackTrace() ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){
        ExtentLogger.skip( result.getMethod().getMethodName() + " is skipped" );
    }

}
