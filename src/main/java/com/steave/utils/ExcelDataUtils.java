package com.steave.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class ExcelDataUtils{

    private ExcelDataUtils(){}

    
    public static Object[] getExcelData(String path , String sheetname) throws IOException{

        var fileStream = new FileInputStream( path );
        var workbook = new XSSFWorkbook(fileStream);
        XSSFSheet sheet = workbook.getSheet( sheetname );
        int rownum = sheet.getLastRowNum();
        int columnnum = sheet.getRow( 0 ).getLastCellNum();
        var data = new Object[rownum];
        Map<Object , Object> map;

        for (var i = 1; i <= rownum; i++) {
            map = new HashMap<>();
            for (var j = 0; j < columnnum; j++) {
                var key = sheet.getRow( 0 ).getCell( j ).getStringCellValue();
                var value = sheet.getRow( i ).getCell( j ).getStringCellValue();
                map.put( key,value );
                data[i -1] = map;
            }
            
        }

        return data;
    }


}
