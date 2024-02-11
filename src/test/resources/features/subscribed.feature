Feature: Subscribed

  Background:
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully

  Scenario: Test Case 10: Verify Subscription in home page
    When  Scroll down to footer
    And Verify text SUBSCRIPTION
    And Enter email address in input and click arrow button
    Then Verify success message "You have been successfully subscribed!" is visible on footer


  Scenario: Test Case 11: Verify Subscription in Cart page
    And Click on "Cart" button on header
    When Scroll down to footer
    And Enter email address in input and click arrow button
    Then Verify success message "You have been successfully subscribed!" is visible on footer

  Scenario: Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    When  Scroll down to footer
    And Verify text SUBSCRIPTION
    And Click on arrow at bottom right side to move upward
    Then Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen


  Scenario: Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
    When  Scroll down to footer
    And Verify text SUBSCRIPTION
    And Scroll up page to top
    Then Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen