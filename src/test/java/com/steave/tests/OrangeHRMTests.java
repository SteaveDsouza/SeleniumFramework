package com.steave.tests;

import com.steave.pages.OrangeLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class OrangeHRMTests extends BaseForAll{

    private OrangeHRMTests(){}

    OrangeLoginPage loginPage = new OrangeLoginPage();

    @Test
    public void loginLogoutTest(){
        String title = loginPage.enterUsername( "Admin" )
                        .enterPassword( "admin123" )
                        .submitForm()
                        .logoutFromApp().getPageTitle();

        Assertions.assertThat( title )
                .containsIgnoringCase( "orangehrm" )
                .isNotNull();
    }
}
