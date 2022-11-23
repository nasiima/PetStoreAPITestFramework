Feature: I want to get a map of status codes to quantities
  Scenario: Getting a map of status codes to quantities (with local server)
    When I send get request to "http://localhost:8080/api/v3/store/inventory"
    Then I get response code 200
    And I get a map of status codes to quantities

    Scenario: Sending a get inventory request with a misprint
      When I send get request to "https://petstore3.swagger.io/api/v3/store/invenory"
      Then I get response code 404
      And I get an error message "HTTP 404 Not Found"