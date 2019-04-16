@RsiTest
Feature: Teste RSI

   Scenario: Message Validation
    And user wants to get response
    Then user should see "success" message
    And user should see title column with value "delectus aut autem"
