package com.steave.constants;

import com.steave.enums.ConfigProperties;
import com.steave.utils.PropertyUtils;

public class FrameWorkConstants{

    private FrameWorkConstants(){ }

    private static final String RESOURCESPATH = System.getProperty( "user.dir" ) + "/src/test/resources";
    private static final String CONFIGPATH = RESOURCESPATH + "/Config/config.properties";
    private static final String EXCELDATAPATH = RESOURCESPATH + "/Data/Data.xlsx";
    private static final String EXTENTREPORTPATH = System.getProperty( "user.dir" ) + "/extent-test-output/";
    private static final String RUNMANAGER = "runmanager";
    private static final String DATASHEET = "main";
    public static String EXTENTREPORTNAME = "";
    private static final int EXPLICITWAIT = 6;

    public static String getConfigPath() { return CONFIGPATH; }
    public static int getExplicitWait(){return EXPLICITWAIT;}
    public static String getExceldatapath() {return EXCELDATAPATH;}
    public static String getRunManager(){ return RUNMANAGER; }
    public static String getDataSheet(){ return DATASHEET; }

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
