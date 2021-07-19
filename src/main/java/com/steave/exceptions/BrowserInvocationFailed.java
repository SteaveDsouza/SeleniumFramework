package com.steave.exceptions;

public class BrowserInvocationFailed extends FrameworkException{

    public BrowserInvocationFailed(String mesaage){
        super( mesaage );
    }

    public BrowserInvocationFailed(String mesaage, Throwable cause){
        super( mesaage, cause );
    }
}
