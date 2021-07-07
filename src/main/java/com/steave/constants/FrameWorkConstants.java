package com.steave.constants;

public class FrameWorkConstants{

    private FrameWorkConstants(){ }

    private static final String CHROMEDRIVERPATH = System.getProperty( "user.dir" ) + "/src/test/resources/Executables/chromedriver.exe";

    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }
}
