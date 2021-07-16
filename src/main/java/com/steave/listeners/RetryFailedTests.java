package com.steave.listeners;

import com.steave.enums.ConfigProperties;
import com.steave.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryFailedTests implements IRetryAnalyzer{

    public RetryFailedTests() throws Exception{ }
    private int count = 0;
    private final int retries = Integer.parseInt( PropertyUtils.get( ConfigProperties.RETRYCOUNT ) );

    @Override
    public boolean retry(ITestResult result){
        try {
            if(PropertyUtils.get( ConfigProperties.RETRYFAILEDTESTS ).equalsIgnoreCase( "yes" )){
                boolean value = count < retries;
                count++;
                return value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
