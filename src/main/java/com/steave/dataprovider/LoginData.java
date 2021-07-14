package com.steave.dataprovider;

import com.steave.constants.FrameWorkConstants;
import com.steave.utils.ExcelDataUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginData{

    private LoginData(){}

    private static final String LOGINDATAPATH = FrameWorkConstants.getLogindatapath();
    private static final String SHEETNAME = "login";
    private static Object[] dataFromExcel;

    @DataProvider(name = "Logindata", parallel = true)
    public static Object[] getData(){
        try {
            dataFromExcel = ExcelDataUtils.getExcelData( LOGINDATAPATH, SHEETNAME );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataFromExcel;
    }

}
