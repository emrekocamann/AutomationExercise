Feature: Register

  Background:
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully
    And Click on "Signup / Login" button on header
    And Verify "New User Signup!" is visible on the signup form

  Scenario: Positive Register Test - Test Case:1 Register User
    When Enter name and email address
    When Click Signup button
    When Verify that ENTER ACCOUNT INFORMATION is visible
    When Fill details: Title, Name, Email, Password, Date of birth
    And Select checkbox "Sign up for our newsletter!"
    And Select checkbox "Receive special offers from our partners!"
    And  Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And  Click Create Account button
    Then Verify that ACCOUNT CREATED! is visible
    And Click Continue button
    Then Verify that Logged in as username is visible
    And Click on "Delete Account" button on header
    Then Verify that "ACCOUNT DELETED!" is visible and click Continue button


  Scenario Outline: Negative Register Test - Test Case 5: Register User with existing email
    Given Enter name and already "<registered email>" address
    When Click Signup button
    Then Verify error 'Email Address already exist!' is visible on signup form

    Examples:
      | registered email                  |
      | erin.green@hotmail.com            |
  #    | Randelladrianna.johnson@gmail.com |
