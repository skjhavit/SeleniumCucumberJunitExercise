Feature: Flight reservation feature to check serach & select flight functionality is working correctly.

  Scenario: departing from on search page validation.
    Given user is signed in and lands on searchPage
    Then field DepartingFrom has options New York and London available.

  Scenario: Signed in user is able to perform search
    Given user is signed in and lands on searchPage
    When user enter from , to and serviceClass
    Then user sees SelectFlight page
