package com.steave.dataprovider;

import com.steave.constants.FrameWorkConstants;
import com.steave.utils.ExcelDataUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.*;

public class LoginData{

    private static final String LOGINDATAPATH = FrameWorkConstants.getExceldatapath();
    private static final String SHEETNAME = "main";

    private static Map<String,String>[] dataFromExcel = null;

    @DataProvider(name = "Logindata", parallel = true)
    public static Object[] getData(Method m){
        String testName = m.getName();
        if (Objects.isNull( dataFromExcel )) {
            dataFromExcel = ExcelDataUtils.getExcelData( LOGINDATAPATH, SHEETNAME );
        }
        List<Map<String,String>> finalResult = new ArrayList<>();
        Arrays.stream( dataFromExcel ).forEach( map -> {
            if(map.get( "testname" ).equalsIgnoreCase( testName ) && map.get( "execute" ).equalsIgnoreCase( "yes" )){
                finalResult.add( map );
            }
        } );
        Arrays.asList( dataFromExcel ).remove( finalResult );
        return finalResult.toArray();
    }
}
