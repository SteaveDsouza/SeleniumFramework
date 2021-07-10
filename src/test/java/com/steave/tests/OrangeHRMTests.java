package com.steave.tests;

import com.steave.pages.OrangeLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRMTests extends BaseForAll{

    private OrangeHRMTests(){}

    OrangeLoginPage loginPage = new OrangeLoginPage();

    @Test(dataProvider = "getData")
    public void loginLogoutTest(String username , String password , String expectedTitle){
        String title = loginPage.enterUsername( username )
                        .enterPassword( password )
                        .submitForm()
                        .logoutFromApp().getPageTitle();

        Assertions.assertThat( title )
                .containsIgnoringCase( expectedTitle )
                .isNotNull();
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"Admin" , "admin123","orangehrm"},
                {"Admin" , "admin123", "orangehrm"},
        };
    }
}
