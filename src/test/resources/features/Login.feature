Feature: Validate login feature for the website

  Scenario: Validate user is unable to login with invalid login details
    Given the home page is displayed
    When the user tries to login with invalid credentials from the home page
    Then the user is unable to login

  @AfterScenarioLogoff @SmokeTest
  Scenario: Validate user is able to login successfully from the Home page
    Given the user navigates to home page
    When the user tries to login with valid credentials from the home page
    Then the user is able to login successfully