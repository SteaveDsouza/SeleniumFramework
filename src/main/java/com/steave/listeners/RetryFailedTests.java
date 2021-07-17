package com.steave.listeners;

import com.steave.enums.ConfigProperties;
import com.steave.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryFailedTests implements IRetryAnalyzer{

    public RetryFailedTests(){ }

    private int count = 0;
    private final int retries = Integer.parseInt( PropertyUtils.get( ConfigProperties.RETRYCOUNT ) );

    @Override
    public boolean retry(ITestResult result){
            if(PropertyUtils.get( ConfigProperties.RETRYFAILEDTESTS ).equalsIgnoreCase( "yes" )){
                boolean value = count < retries;
                count++;
                return value;
            }
        return false;
    }
}
