package com.steave.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager{

    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    public static ExtentTest getExtTest() {
        return extTest.get();
    }

    static void setExtTest(ExtentTest test) {
        if (Objects.nonNull( test)) {
            extTest.set( test);
        }
    }

    static void unload() {
        extTest.remove();
    }
}
