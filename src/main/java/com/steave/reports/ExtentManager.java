package com.steave.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager{

    private ExtentManager(){}

    public static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    public static ExtentTest getExtTest() {
        return extTest.get();
    }

    public static void setExtTest(ExtentTest test) {
        if (Objects.nonNull( test)) {
            extTest.set( test);
        }
    }

    public static void unload() {
        extTest.remove();
    }
}
