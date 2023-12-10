@appiumtest
Feature: Mobile APK file test

  Scenario: 1. Verify the Form page activate scenario
    When click on Forms button from home page
    And Enter the input value "Test the input value" in input field
    Then Verify the entered input value is displayed in result field
    Then Turn "ON" the switch
    And Select the value "Appium is awesome" in form dropdown field
    And click "Active" button in the form
    Then verify the alert window is displayed
    Then verify the alert window header is displayed
    And verify the alert window message is displayed
    Then click "Ask Me Later" button in the form model window
    And click "Active" button in the form
    Then verify the alert window is displayed
    Then click "Cancel" button in the form model window
    And click "Active" button in the form
    Then verify the alert window is displayed
    Then click "Ok" button in the form model window

  Scenario: 2. Verify the Sign up form field error
    When click on Login button from home page
    And Verify the "Login / Sign up Form" is displayed
    And Click on the "signup" button
    And Click on the "SIGNUP" button
    And Verify the "Please enter a valid email address" is displayed
    And Verify the "Please enter at least 8 characters" is displayed
    Then Enter the password as "Test"
    Then Enter the "different" confirm password
    And Click on the "SIGNUP" button
    And Verify the "Please enter the same password" is displayed

  Scenario: 3. Verify the Sign up form is successful
    When click on Login button from home page
      And Verify the "Login / Sign up Form" is displayed
      And Click on the "signup" button
      Then Enter the email id
      Then Enter the password as "Test"
      Then Enter the "same" confirm password
      And Click on the "SIGNUP" button
      And verify the login/signup form model is displayed
      And verify the login/signup form model message is displayed
      And click on Login model window "ok" button

  Scenario: 4. Verify the Login is successful
    When click on Login button from home page
    And Verify the "Login / Sign up Form" is displayed
    And Click on the "signup" button
    Then Enter the email id
    Then Enter the password as "Test"
    Then Enter the "same" confirm password
    And Click on the "SIGNUP" button
    And verify the login/signup form model is displayed
    And verify the login/signup form model message is displayed
    And click on Login model window "ok" button
    Then click on Login button in model window navigation
    And Verify the consent message in login page
    When click on Login button in model window bottom
    And verify the login/signup form model is displayed
    And verify the login/signup form model message is displayed
    And click on Login model window "ok" button

  Scenario: 5. Verify the Login field error validation
    When click on Login button from home page
    And Verify the "Login / Sign up Form" is displayed
    When click on Login button in model window bottom
    And Verify the "Please enter a valid email address" is displayed
    And Verify the "Please enter at least 8 characters" is displayed

  Scenario: 6. Verify the WebView page
    When click on Webview button from home page