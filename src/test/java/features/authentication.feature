Feature: authentication

  Scenario: Verify success autentication
    Given get call de API "/Account/v1"
    And pass de credential userName "leoQA" and password "Teste@123"
    When call "/Authorized"
    Then return status 200
    And return false response body

  Scenario: Verify user not found
    Given get call de API "/Account/v1"
    And pass de credential userName "leoQ" and password "Teste@123"
    When call "/Authorized"
    Then return status 404
    And return message "User not found!"

  Scenario: Verify return with empty body request
    Given get call de API "/Account/v1"
    And pass de credential userName "" and password ""
    When call "/Authorized"
    Then return status 400
    And return message "UserName and Password required."