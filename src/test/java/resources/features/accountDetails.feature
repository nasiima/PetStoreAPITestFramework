Feature: As a registered user I would like to view my account details
  Scenario: As a logged in user I would like to view my account details
    Given I am an already registered user
    When I view my account details
    Then The details contain the correct information