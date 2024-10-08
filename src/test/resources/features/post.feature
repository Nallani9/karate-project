Feature: users api functional tests (get-users-list)

  Background:
    * url baseUrl + '/get-users-list'

  Scenario: Test Get users list happy path
    And headers {'AppId': '123456', 'AppName': 'TestApp', 'id': 'karate-functional-test', 'REQ-ID': 'karate-functional-test'}
    And request {'users': ['userId1']}
    When method post
    Then status 200
    And match response.users[0] == 'userId1'
    And match response.users[0] contains 'user'

  Scenario: Test Get user list for missing authorization header
    * configure headers = null
    And request {'users': ['userId1', 'userId2']}
    When method post
    Then status 400
    #And match response.errors[0].title == "Missing or invalid security token"

  Scenario: Test Get user list for missing AppId Header
    And request {'users': ['userId1', 'userId2']}
    And headers { 'AppName': 'TestApp', 'id': 'karate-functional-test', 'REQ-ID': 'karate-functional-test'}
    When method post
    Then status 400
    #And match response.errors[0].title == " Header [AppId] not specified"

  Scenario: Test Get user list for missing AppName Header
    And headers { 'AppId': '123456', 'id': 'karate-functional-test', 'REQ-ID': 'karate-functional-test'}
    And request {'users': ['userId1', 'userId2']}
    When method post
    Then status 400
    #And match response.errors[0].title == " Header [AppName] not specified"

  Scenario: Test Get user list for missing id & REQ-ID Headers
    And headers {'AppId': '123456', 'AppName': 'TestApp'}
    And request {'users': ['userId1', 'userId2']}
    When method post
    Then status 400
    #And match response.errors[0].title == " Header [REQ-ID] not specified"

  Scenario: Test Get user list for missing input body
    And headers {'AppId': '123456', 'AppName': 'TestApp', 'id': 'karate-functional-test', 'REQ-ID': 'karate-functional-test' }
    When method post
    Then status 415
    #And match response.errors[0].title == " Body [inputRequest] not specified"

  Scenario: Test Get user list for empty input userId's
    And headers {'AppId': '123456', 'AppName': 'TestApp', 'id': 'karate-functional-test', 'REQ-ID': 'karate-functional-test' }
    And request {'users': []}
    When method post
    Then status 200
    And match response.errors [0].title == null