package com.steave.exceptions;

public class FrameworkException extends RuntimeException{

    public FrameworkException(String mesaage){
        super(mesaage);
    }

    public FrameworkException(String mesaage, Throwable cause){
        super(mesaage , cause);
    }

}
