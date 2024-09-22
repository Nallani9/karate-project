Feature: user metadata api functional tests (get-user)
  Background:
    * url baseUrl
  Scenario: Test Get user happy path
    Given path '/get-user'
    And headers { 'AppId': '123456', 'AppName': 'TestAppe', 'id': 'karate-functional-test', 'REQ-ID': 'karate-functional-test', 'userId': 'login'}
    When method get
    Then status 200
    And match response. user_name contains 'login'
  Scenario: Test Get user for missing Authorization
    * configure headers = null
    Given path '/get-user'
    When method get
    Then status 401
    And match response.errors [0].title == "Missing or invalid security token"
  Scenario: Test Get user for missing AppId Header
    Given path '/get-user'
    And headers { 'AppName': 'TestAppe', 'id':'karate-functional-test', 'REQ-ID': 'karate-functional-test', 'userId': 'login'}
    When method get
    Then status 400
    And match response.errors [0].title == " Header [AppId] not specified"

  Scenario: Test Get user for missing AppName Header
    Given path '/get-user'
    And headers {'AppId':'123456', 'id': 'karate-functional-test', 'REQ-ID': 'karate-functional-test', 'userId': 'login'}
    When method get
    Then status 400
    And match response.errors[0].title == " Header [AppName] not specified"
  Scenario: Test Get user for missing id & REQ-ID Headers
    Given path '/get-user'
    And headers { 'AppId': '123456', 'AppName': 'TestAppe', 'userId': 'login'}
    When method get
    Then status 400
    And match response.errors [0].title == " Header [REQ-ID] not specified"