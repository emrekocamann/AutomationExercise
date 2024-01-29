Feature: Contact Us

  Scenario: Test Case 6: Contact Us Form
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully
    And Click on "Contact us" button on header
    When  Verify GET IN TOUCH is visible
    When Enter name, email, subject and message
    And Upload file
    And Click Submit button
    And Click OK button
    Then Verify success message "Success! Your details have been submitted successfully." is visible
    Then  Click Home button
    Then Verify that home page is visible successfully