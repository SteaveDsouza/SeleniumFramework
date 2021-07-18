package com.steave.utils;

import com.steave.constants.FrameWorkConstants;
import com.steave.enums.ConfigProperties;
import com.steave.exceptions.ConfigPropertyNotFound;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public final class PropertyUtils{

    private PropertyUtils(){}
    private static Properties  property = new Properties();
    private static Map<String,String> CONFIGMAP = new ConcurrentHashMap<>();

    static {
        try(FileInputStream fileValue = new FileInputStream( FrameWorkConstants.getConfigPath() )) {
            property.load( fileValue );
            property.forEach( (key, value) -> CONFIGMAP.put( String.valueOf( key ), String.valueOf( value ).trim() ) );
        } catch ( IOException e) {
           e.printStackTrace();
           System.exit( 0 );
        }
    }

    public static String get(ConfigProperties kkk) {
        if(Objects.isNull( CONFIGMAP.get( kkk.toString().toLowerCase() ) )){
            throw new ConfigPropertyNotFound( "Property name " + kkk.toString().toLowerCase() + " is not found. Please check config.properties file");
        }
        return CONFIGMAP.get( kkk.name().toLowerCase()  );
    }

    public static String getReportConfigPath(){
        String reportConfigPath = CONFIGMAP.get( "extentconfigpath" );
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new ConfigPropertyNotFound("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
