Feature: As a registered use, I would like to log in so that I can use the pet store website
  Scenario: Logging in with correct information
    Given I am a registered user
    When I log in
    Then The response contains "Logged in user session"