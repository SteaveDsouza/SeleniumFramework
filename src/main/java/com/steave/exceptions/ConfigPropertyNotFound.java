package com.steave.exceptions;

public class ConfigPropertyNotFound extends FrameworkException{
    public ConfigPropertyNotFound(String mesaage){
        super( mesaage );
    }

    public ConfigPropertyNotFound(String mesaage, Throwable cause){
        super( mesaage, cause );
    }
}
