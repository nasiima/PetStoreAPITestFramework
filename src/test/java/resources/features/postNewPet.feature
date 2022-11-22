Feature: As a store owner of the Pet Website I want to be able to add new pets
  Scenario: sending post request
    Given I am on the addPet Page and I added a new Pet
    When I search for Pets id
    Then The response contains pets id