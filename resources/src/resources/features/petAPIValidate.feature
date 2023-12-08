@verifypet
Feature: Login test

  Scenario: 1. Verify the post method is returning 400
    Given Post Method: Add a pet "Rabbit" and body id is ""
    And Verify the status code as 400 and response body as expected

  Scenario: 2. Verify the post method is returning 500
    Given Post Method: Add a pet "Rabbit" and body id is "c"
    And Verify the status code as 500 and response body as expected

  Scenario: 3. Verify the post method is returning 200
    Given Post Method: Add a pet "Rabbit" and body id is "0"
    And Verify the status code as 200 and response body as expected

  Scenario: 4. Verify the GET method is returning 200 for existing record
    Given Post Method: Add a pet "ElephentTest" and body id is "9988776655"
    And Verify the status code as 200 and response body as expected
    When Verify the GET method for ID "9988776655"
    And Verify the status code as 200 and response body as expected

  Scenario: 5. Verify the GET method is returning 404 for the record not found
    When Verify the GET method for ID "001243"
    And Verify the status code as 404 and response body as expected

  Scenario: 6. Verify the GET method is returning 404 for the invalid input
    When Verify the GET method for ID "xx"
    And Verify the status code as 404 and response body as expected

  Scenario: 7. Verify the put method is returning 400
    Given Put method:add a pet "Lion" and body id is ""
    And Verify the status code as 400 and response body as expected

  Scenario: 8. Verify the put method is returning 500
    Given Put method:add a pet "Lion" and body id is "c"
    And Verify the status code as 500 and response body as expected

  Scenario: 9. Verify the put method is returning 200
    Given Put method:add a pet "Lion" and body id is "0"
    And Verify the status code as 200 and response body as expected

  Scenario: 10. Verify the GET method is returning 200 for existing record
    Given Put method:add a pet "LionCatTest" and body id is "4433221100"
    And Verify the status code as 200 and response body as expected
    When Verify the GET method for ID "4433221100"
    And Verify the status code as 200 and response body as expected