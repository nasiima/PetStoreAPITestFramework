Feature: As an unregistered user, I want to told I can't log in with unregistered details
  so that I know I have to create an account
  Scenario: User logs in with unregistered details
    Given I am an unregistered user
    When I try to log in
    Then The status code is 400