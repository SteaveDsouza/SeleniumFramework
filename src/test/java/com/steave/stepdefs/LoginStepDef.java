package com.steave.stepdefs;

import com.steave.driver.DriverManager;
import com.steave.pages.OrangeHomePage;
import com.steave.pages.OrangeLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;


public class LoginStepDef {

    OrangeLoginPage loginPage = new OrangeLoginPage();
    OrangeHomePage homePage = new OrangeHomePage();

    @Given("^I navigate to Orange HRM website$")
    public void i_navigate_to_Orange_HRM_website() throws Throwable {
        DriverManager.getDriver().get( "https://opensource-demo.orangehrmlive.com/index.php/auth/login" );
    }

    @When("^I submit my username and Password$")
    public void i_submit_my_username_and_Password() throws Throwable {
        loginPage.enterUsername( "Admin" ).enterPassword( "admin123" ).submitForm();
    }

    @When("^I logout from the app$")
    public void i_logout_from_the_app() throws Throwable {
        homePage.logoutFromApp();
    }

    @Then("^I must be navigated back to Login page$")
    public void i_must_be_navigated_back_to_Login_page() throws Throwable {
        Assertions.assertThat( loginPage.getPageTitle() ).isNotNull().containsIgnoringCase( "nook" );
    }

}
