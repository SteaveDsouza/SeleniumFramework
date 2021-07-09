package com.steave.utils;

import com.steave.constants.FrameWorkConstants;
import com.steave.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        FileInputStream fileValue = null;
        try {
            fileValue = new FileInputStream( FrameWorkConstants.getConfigPath() );
            property.load( fileValue );
            property.forEach( (key, value) -> CONFIGMAP.put( String.valueOf( key ), String.valueOf( value ).trim() ) );
            fileValue.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties kkk){
        return CONFIGMAP.get( kkk.name().toLowerCase()  );
    }

}
