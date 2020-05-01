Feature: Flight reservation feature to check the login, search, booking and confirmation feature and generate report based on that.

  Scenario: home page validation
    Given user is on tourHomePage
    Then image of Aruba is displayed
    And current date is displayed

  Scenario: invalid login validation
    Given user is on tourHomePage
    When user enters userName and invalidPassword
    Then user lands on sign on page

  Scenario: valid login validation
    Given user is on tourHomePage
    When user enters userName and validPassword
    Then user lands searchFlightPage