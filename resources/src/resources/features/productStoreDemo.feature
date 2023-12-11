@producttest
Feature: Product Store

  Background:
    Given navigate to the page

  Scenario: 1. Verify the user is able to signup
    When click on signup button
    And Verify the "Sign up" model window is displayed
    And Verify the "user name" label is displayed
    Then provide username as "testuser_"
    And Verify the "password" label is displayed
    Then provide password as "pass$"
    And click on signup button in model window

  Scenario: 2. Verify the existing user message is displayed in signup
    When click on signup button
    And Verify the "Sign up" model window is displayed
    Then provide username as "test"
    Then provide password as "test"
    And click on signup button in model window
    Then verify the alert message "This user already exist." is displayed

  Scenario: 3. Verify the non register user cannot login
    When click on the login button from menu item
    Then Enter user name as "nousercreated" in login window
    Then Enter the password as "Test123#" in login window
    Then click Login button
    Then verify the alert message "User does not exist." is displayed

  Scenario: 4. Verify the user enters incorrect password in login screen
    When click on the login button from menu item
    Then Enter user name as "test" in login window
    Then Enter the password as "Test123#" in login window
    Then click Login button
    Then verify the alert message "Wrong password." is displayed

  Scenario: 5. Verify the user is able to login and add item and remove then logout
    When click on the login button from menu item
      Then Enter user name as "test.demo@yopmail.com" in login window
      Then Enter the password as "Test123#" in login window
      Then click Login button
      And Then select "Laptops" from the category item
      And Then add "Sony vaio i7" to the cart from the category item
      And click on "Add to cart" button
      And click ok from alert window
      And click on "Cart" button
      And Verify the "Title" is displayed in cart for "Sony vaio i7"
      And Delete any item from the cart if exist
      And click on "Logout" button