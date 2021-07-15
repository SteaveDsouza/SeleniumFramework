package com.steave.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public final class ExcelDataUtils{

    private ExcelDataUtils(){}

    
    public static Map<String,String>[] getExcelData(String path , String sheetname) {

        XSSFWorkbook workbook;
        Map<String,String>[] data = null;
        FileInputStream fileStream = null;
        DataFormatter formatter;

        try {
             fileStream = new FileInputStream( path );
            workbook = new XSSFWorkbook( fileStream);
            XSSFSheet sheet = workbook.getSheet( sheetname );
            int rownum = sheet.getLastRowNum();
            int columnnum = sheet.getRow( 0 ).getLastCellNum();
            data = new Map[rownum];
            Map<String , String> map;
            formatter = new DataFormatter();

            for (var i = 1; i <= rownum; i++) {
                map = new HashMap<>();
                for (var j = 0; j < columnnum; j++) {
                    var key = formatter.formatCellValue(sheet.getRow( 0 ).getCell( j )  );
                    var value = formatter.formatCellValue( sheet.getRow( i ).getCell( j ) );
                    map.put( key,value );
                }
                data[i - 1] = map;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


        return data;
    }



}
