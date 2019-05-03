Feature: Validate login feature for the website

  Scenario: Validate user is able to login successfully from the Home page
    Given the home page is displayed
    When the user tries to login with valid credentials from the home page
    Then the user is able to login successfully

  Scenario: Validate user is able to login successfully from the mini login dropdown
    Given the home page is displayed
    And the user clicks on the login menu option
    And the mini login dropdown is displayed
    When the user tries to login with valid credentials from the mini login dropdown
    Then the user is able to login successfully