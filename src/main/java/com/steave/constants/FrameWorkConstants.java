package com.steave.constants;

public class FrameWorkConstants{

    private FrameWorkConstants(){ }


    private static final String RESOURCESPATH = System.getProperty( "user.dir" ) + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH +  "/Executables/chromedriver.exe";
    private static final String CONFIGPATH = RESOURCESPATH + "/Config/config.properties";
    private static final String LOGINDATAPATH = RESOURCESPATH + "/Data/LoginData.xlsx";
    private static final int EXPLICITWAIT = 2;

    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }
    public static String getConfigPath() { return CONFIGPATH; }
    public static int getExplicitWait(){return EXPLICITWAIT;}
    public static String getLogindatapath() {return  LOGINDATAPATH;}
}
