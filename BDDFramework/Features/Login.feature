@smokefeature
Feature: DreesHomes Login Functionality

  Background:
    Given browser is open
    And User is on the Login Page

  @smoketest @regression
  Scenario Outline: Successful Login with valid credentials
    When user enters the Valid "<username>" and "<password>"
    Then User is redirected to the SelectHome Page or Dashboard page
    
    Examples:
    
    |username|password|
    |nbhardwaj@ex2india.com|Drees@12345|
    |rjha@ex2india.com|Drees@12345|


@smoketest @regression
  Scenario Outline: Error Message with invalid credentials
    When user enters the InValid "<username>" and "<password>"
    Then User should be able to view the error message 
    
    Examples:
    
    |username|password|
    |nbhardwaj@ex2india.com|Drees@123456|
    |rjha@ex2india.com|Drees@123456|
    
    @regression
  Scenario: Login with both fields empty
    When user enters the Valid "" and ""
    Then User should see an error message "Email and Password are required"
    
    
    @regression
  Scenario: Check the 'Remember Me' functionality
    When user enters the Valid "validUser@example.com" and "ValidPassword123"
    And User checks the 'Remember Me' checkbox
    And User clicks on login button
    Then User should be redirected to the homepage
    And Validate the user is redirected to the correct URL
    And 'Remember Me' should be checked on subsequent visits
    
    @regression
  Scenario: Verify the 'Forgot your Password' link functionality
    When User clicks on the 'Forgot your Password' link
    Then User should be redirected to the 'Forgot Password' page
    And Validate the user is redirected to the correct URL