@login
Feature: Login test

  Background:
    Given navigate to the page

  Scenario: 1. Verify the store registration page
    When click on signup button
    And Verify the "Sign up" model window is displayed
    And Verify the "user name" label is displayed
    Then provide username as "testuser_"
    And Verify the "password" label is displayed
    Then provide password as "pass$"
