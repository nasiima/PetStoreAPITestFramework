Feature: I want to delete my account

  Scenario: Logged in user deleting account
    Given I am a logged in user
    When I send a delete request to "https://petstore3.swagger.io/api/v3/user/mor94n"
    Then I get response code 200


#  Scenario: Account does not exist
#    Given My accound does not exist/has been deleted
#    When I send a delete request to "https://petstore3.swagger.io/api/v3/user/mor94n"
#    Then I get response code 200