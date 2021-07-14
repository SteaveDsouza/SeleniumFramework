package com.steave.dataprovider;

import com.steave.constants.FrameWorkConstants;
import com.steave.utils.ExcelDataUtils;
import org.testng.annotations.DataProvider;

public class LoginData{

    private LoginData(){}

    private static final String LOGINDATAPATH = FrameWorkConstants.getExceldatapath();
    private static final String SHEETNAME = "login";
    private static Object[] dataFromExcel;

    @DataProvider(name = "Logindata", parallel = true)
    public static Object[] getData(){
        dataFromExcel = ExcelDataUtils.getExcelDataForDataProvider( LOGINDATAPATH, SHEETNAME );

        return dataFromExcel;
    }




}
