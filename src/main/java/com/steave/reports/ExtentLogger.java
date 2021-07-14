package com.steave.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.steave.enums.ConfigProperties;
import com.steave.utils.PropertyUtils;
import com.steave.utils.ScreenShotUtils;

public class ExtentLogger{

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtTest().pass( message );
    }

    public static void fail(String message){
        ExtentManager.getExtTest().fail( message );
    }

    public static void skip(String message){
        ExtentManager.getExtTest().skip( message );
    }

    public static void pass(String message, boolean isScreenshotRequired) throws Exception{
        if(PropertyUtils.get( ConfigProperties.PASSEDSTEPSCREENSHOT ).equalsIgnoreCase( "yes" ) && isScreenshotRequired){
            ExtentManager.getExtTest().pass( message, MediaEntityBuilder.createScreenCaptureFromBase64String( ScreenShotUtils.getBase64Image() ).build() );
        }else{
            pass( message );
        }
    }

    public static void fail(String message, boolean isScreenshotRequired) throws Exception{
        if(PropertyUtils.get( ConfigProperties.FAILEDSTEPSCREENSHOT ).equalsIgnoreCase( "yes" ) && isScreenshotRequired){
            ExtentManager.getExtTest().fail( message, MediaEntityBuilder.createScreenCaptureFromBase64String( ScreenShotUtils.getBase64Image() ).build() );
        }else{
            fail( message );
        }
    }

    public static void skip(String message, boolean isScreenshotRequired) throws Exception{
        if(PropertyUtils.get( ConfigProperties.SKIPPEDSTEPSCREENSHOT ).equalsIgnoreCase( "yes" ) && isScreenshotRequired){
            ExtentManager.getExtTest().skip( message, MediaEntityBuilder.createScreenCaptureFromBase64String( ScreenShotUtils.getBase64Image() ).build() );
        }else{
            skip( message );
        }
    }



}
