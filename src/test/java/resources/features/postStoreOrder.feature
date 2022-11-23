Feature: I want to send a post request with order details, so that I can place a new order in the pets store
  Scenario: Order successfully added
    Given I want to send "{ \"id\": 10, \"petId\": 198772, \"quantity\": 7, \"shipDate\": \"2022-11-22T13:55:10.012Z\", \"status\": \"approved\", \"complete\": true }" as request body
    When I send post request to "https://petstore3.swagger.io/api/v3/store/order"
    Then I get response code 200
    And I get response object with values 10 198772 7 "true"

  Scenario: Sending post request with empty body
    Given I want to send "" as request body
    When I send post request to "https://petstore3.swagger.io/api/v3/store/order"
    Then I get response code 500
    And I get an error message "There was an error processing your request"

  Scenario: Sending post request with empty object as a request body
    Given I want to send "{}" as request body
    When I send post request to "https://petstore3.swagger.io/api/v3/store/order"
    Then I get response code 200
    And I get response object with values 0 0 0 "false"

  Scenario: Order post request with a misprint in the URL
    Given I want to send "{ \"id\": 10, \"petId\": 198772, \"quantity\": 7, \"shipDate\": \"2022-11-22T13:55:10.012Z\", \"status\": \"approved\", \"complete\": true }" as request body
    When I send post request to "https://petstore3.swagger.io/api/v3/store/oder"
    Then I get response code 404
    And I get an error message "HTTP 404 Not Found"