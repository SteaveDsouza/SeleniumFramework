package com.steave.stepdefs;

import com.steave.constants.FrameWorkConstants;
import com.steave.utils.PropertyUtils;
import com.vimalselvam.cucumber.listener.Reporter;
import org.testng.annotations.AfterSuite;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseListener{

    @AfterSuite
    public void finalTeardown() throws Exception{
        Reporter.loadXMLConfig( new File( PropertyUtils.getReportConfigPath()) );
        try {
            Desktop.getDesktop().browse( new File( FrameWorkConstants.getExtentReportPath()).toURI() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
