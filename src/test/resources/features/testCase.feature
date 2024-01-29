Feature: Test Cases Page
  @wip
  Scenario: Test Case 7: Verify Test Cases Page
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully
    When Click on "Test Cases" button on header
    Then Verify user is navigated to test cases page successfully
