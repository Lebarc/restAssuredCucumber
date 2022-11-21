Feature: books

  Scenario: Verify successful book list get
    Given get call de API "/BookStore/v1"
    When call "get" "/Books"
    Then return status 200
    And return correct json schema