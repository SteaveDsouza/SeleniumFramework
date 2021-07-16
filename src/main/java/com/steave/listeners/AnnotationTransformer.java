package com.steave.listeners;

import com.steave.dataprovider.LoginData;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer{

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){
        annotation.setDataProvider( "Logindata" );
        annotation.setDataProviderClass( LoginData.class );
        annotation.setRetryAnalyzer( RetryFailedTests.class );
    }
}
