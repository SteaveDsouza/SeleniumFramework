package com.steave.tests;

import com.aventstack.extentreports.ExtentReports;
import com.steave.dataprovider.LoginData;
import com.steave.pages.OrangeLoginPage;
import com.steave.reports.ExtentReport;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public class OrangeHRMTests extends BaseForAll{

    private OrangeHRMTests(){}

    OrangeLoginPage loginPage = new OrangeLoginPage();

    @Test(dataProvider = "Logindata",dataProviderClass = LoginData.class)
    public void loginLogoutTest(Map<String,String> map){
        ExtentReport.createTest( " Login Test" );
        String title = loginPage.enterUsername( map.get( "Username" ) )
                        .enterPassword( map.get( "Password" ) )
                        .submitForm()
                        .logoutFromApp().getPageTitle();

        Assertions.assertThat( title )
                .containsIgnoringCase( map.get( "ExpectedTitle" ) )
                .isNotNull();
    }


}
