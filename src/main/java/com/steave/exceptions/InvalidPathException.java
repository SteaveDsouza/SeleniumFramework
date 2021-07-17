package com.steave.exceptions;

public class InvalidPathException extends FrameworkException{

    public InvalidPathException(String mesaage){
        super( mesaage );
    }

    public InvalidPathException(String mesaage, Throwable cause){
        super( mesaage, cause );
    }

}
