package com.steave.constants;

import com.steave.enums.ConfigProperties;
import com.steave.utils.PropertyUtils;

public class FrameWorkConstants{

    private FrameWorkConstants(){ }


    private static final String RESOURCESPATH = System.getProperty( "user.dir" ) + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH +  "/Executables/chromedriver.exe";
    private static final String CONFIGPATH = RESOURCESPATH + "/Config/config.properties";
    private static final String LOGINDATAPATH = RESOURCESPATH + "/Data/LoginData.xlsx";
    private static final String EXTENTREPORTPATH = System.getProperty( "user.dir" ) + "/extent-test-output/";
    public static String EXTENTREPORTNAME = "";

    private static final int EXPLICITWAIT = 2;

    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }
    public static String getConfigPath() { return CONFIGPATH; }
    public static int getExplicitWait(){return EXPLICITWAIT;}
    public static String getLogindatapath() {return  LOGINDATAPATH;}

    public static String getExtentReportPath() throws Exception{
        if(EXTENTREPORTNAME.isEmpty()){
            EXTENTREPORTNAME = createExtentReportPath();
        }
        return EXTENTREPORTNAME;
    }

    private static String createExtentReportPath() throws Exception{
        if(!PropertyUtils.get( ConfigProperties.OVERRIDEREPORTS ).equalsIgnoreCase( "yes" )){
            return EXTENTREPORTPATH  + "index_" + System.currentTimeMillis() + ".html";
        }else {
            return EXTENTREPORTPATH + "index.html";
        }
    }

}
