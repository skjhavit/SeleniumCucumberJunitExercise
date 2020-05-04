Feature: Flight reservation feature to check serach & select flight functionality is working correctly.

  Scenario: departing from options on search page validation.
    Given user is signed in and lands on searchPage
    Then field DepartingFrom has options New York and London available.

  Scenario: Signed in user is able to perform search
    Given user is signed in and lands on searchPage
    When user enter from , to and serviceClass
    Then user sees SelectFlight page

  Scenario: The orders of flight is sorted based on price
    Given user is signed in and lands on searchPage
    When user enter from , to and serviceClass
    Then user sees flights displayed are shorted based on price
    And header sections are centrally alligned
    And Background color is Blue
    And user selects flight having second highest price

  Scenario: Customer books the flight after verifying all the details
    Given user is signed in and lands on searchPage
    When user enter from , to and serviceClass
    And user selects flight having second highest price
    Then details of review page is same as select flight page
    And total price is correct sum of all the prices
    And after verifying all the details customer books the flight

  Scenario: After booking flight customer verifies details on confirmation page and notes down the confirmation number
    Given user is signed in and lands on searchPage
    When user enter from , to and serviceClass
    And user selects flight having second highest price
    And after verifying all the details customer books the flight
    Then customer verifies details of confirmation page is same as review page
    And customer prints confirmation number
    And customer signs off
