@ms.word
@file.modify
Feature: File modification

  Scenario: Create and modify file
    Given I start MS Word application
    When I create new document
    And I type "Some random text"
    And I save document with name "origin.docx"
    When I close current document
    And I open document with name "origin.docx"
    Then document contains "Some random text"
    When I type "updated "
    Then document contains "Updated Some random text"
    And I save document
    And I close MS Word application
