Feature: Validating Place API's

  Scenario: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload
    When User calls "post" with post http request
    Then API call got success with status code 200
    And "status" in response body is "OK"
    Then Place details are checked
    Then Place is updated

    Scenario: Updating added payload

     # Given Add updating payload
      #Then