Feature: Blaze Demo

  Scenario: Purchase Fight
    When I go to "https://blazedemo.com/"
    And I click "Find Flights"
    And I click "Choose This Flight"
    And I click "Purchase Flight"
    Then I should be shown "Thank you for your purchase today!"