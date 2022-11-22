Feature: As a registered use, I would like to log in so that I can use the pet store website
  Scenario: Logging in with correct information
    Given I am a registered user
    When I log in
    Then The response contains "Logged in user session"
  Scenario: As a logged in user I would like to view my account details
    Given I am logged in
    When I view my account details
    Then The details contain the correct information