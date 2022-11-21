Feature: I want to send a post request with order details, so that I can place a new order in the pets store
  Scenario: Order successfully added
    When I send post request to "https://petstore3.swagger.io/api/v3/store/order"
    And I send Order object as request body
    Then I get response code 200
    And I get Order object as response body

  Scenario: Sending post request with empty body
    When I send post request to "https://petstore3.swagger.io/api/v3/store/order"
    And I send empty request body
    Then I get response code 500
    And I get an error message "There was an error processing your request"

  Scenario: Sending post request with empty object as a request body
    When I send post request to "https://petstore3.swagger.io/api/v3/store/order"
    And I send empty Order object as a request body
    Then I get response code 200
    And I get Order object with default values