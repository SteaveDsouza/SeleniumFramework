package com.steave.tests;

import com.steave.annotations.FrameworkAnnotations;
import com.steave.enums.TestTagAnnotation;
import com.steave.pages.OrangeLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class  OrangeHRMTests extends BaseForAll{

    private OrangeHRMTests(){}

    OrangeLoginPage loginPage = new OrangeLoginPage();

    @FrameworkAnnotations(authors = {"Steave"}, testTags = {TestTagAnnotation.REGRESSION,TestTagAnnotation.SANITY})
    @Test
    public void sanityLogin(Map<String,String> map) throws Exception{
        String title = loginPage.enterUsername( map.get( "Username" ) )
                        .enterPassword( map.get( "Password" ) )
                        .submitForm()
                        .logoutFromApp().getPageTitle();

        Assertions.assertThat( title )
                .containsIgnoringCase( map.get( "ExpectedTitle" ) )
                .isNotNull();
    }

    @FrameworkAnnotations(authors = {"NameLess"}, testTags = {TestTagAnnotation.SMOKETEST})
    @Test
    public void trialTest(Map<String,String> map) throws Exception{
        String title = loginPage.enterUsername( map.get( "Username" ) )
                .enterPassword( map.get( "Password" ) )
                .submitForm()
                .logoutFromApp().getPageTitle();

        Assertions.assertThat( title )
                .containsIgnoringCase( map.get( "ExpectedTitle" ) )
                .isNotNull();
    }


}
