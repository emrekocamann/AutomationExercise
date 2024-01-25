Feature: Login Test
  Background:
    Given Launch browser
    Given Navigate to url "http://automationexercise.com"
    When Verify that home page is visible successfully
    Given Click on "Signup / Login" button on header
    Given Verify 'Login to your account' is visible

  Scenario:Test Case 2: Login User with correct email and password
    When Enter correct email address and password
    When Click 'login' button
    When Verify that Logged in as username is visible
    And Click 'Delete Account' button
    Then Verify that 'ACCOUNT DELETED!' is visible

    Scenario:Test Case 3: Login User with incorrect email and password
      Given Enter incorrect email address and password
      When Click 'login' button
      Then Verify error 'Your email or password is incorrect!' is visible