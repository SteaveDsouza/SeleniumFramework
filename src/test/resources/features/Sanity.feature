 Feature: Orange HRM Sanity Test

    @loginLogoutTest
    Scenario: End to End Login and Logout
      Given I navigate to Orange HRM website
      When I submit my username and Password
      And I logout from the app
      Then I must be navigated back to Login page