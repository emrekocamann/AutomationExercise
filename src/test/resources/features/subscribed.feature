Feature: Subscribed
  @wip
  Scenario: Test Case 10: Verify Subscription in home page
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully
    When  Scroll down to footer
    And Verify text SUBSCRIPTION
    And Enter email address in input and click arrow button
    Then Verify success message "You have been successfully subscribed!" is visible on footer