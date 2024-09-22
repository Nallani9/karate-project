Feature: Get OAuth Token
  Background:
    * url oauthBaseUrl
  Scenario: Obtain OAuth Token
    Given path '/oauth/v1'
    And header Content-Type = 'application/x-www-form-urlencoded'
    And form field client_id = clientId
    And form field client_secret = clientSecret
    And form field grant_type = 'client_credentials'
    And form field scope = 'AppIdClaims Trust'
    When method POST
    Then status 200
    * def accessToken = response.access_token