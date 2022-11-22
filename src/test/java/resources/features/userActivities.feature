Feature: I want to send a post request with order details, so that I can place a new order in the pets store
  Background:
    Given I am a logged in user

    Scenario: Logged in user logging out
      When I send a get request to "https://petstore3.swagger.io/api/v3/user/logout"
      Then I should receive the message "User logged out"

    Scenario: Logged in user updating account details
      When I send a put request to "https://petstore3.swagger.io/api/v3/user/cheesus"
      Then I should get the response code 200

    Scenario: Logged in user viewing updated account details
      When I send a get request to "https://petstore3.swagger.io/api/v3/user/cheesus"
      Then I should see my updated account details






