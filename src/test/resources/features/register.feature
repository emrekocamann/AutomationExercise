
Feature: Register new user and delete user
  Background:
    Given Launch browser
    Given Navigate to url "http://automationexercise.com"
    When Verify that home page is visible successfully
@wip1
  Scenario: Test Case:1 Register User
    Given Click on "Signup / Login" button on header
    When Verify "New User Signup!" is visible on the signup form
    And Enter name and email address
    And Click Signup button
    Then Verify that ENTER ACCOUNT INFORMATION is visible
    And Fill details: Title, Name, Email, Password, Date of birth
    And Select checkbox "Sign up for our newsletter!"
    And Select checkbox "Receive special offers from our partners!"
    And  Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And  Click Create Account button
    Then Verify that ACCOUNT CREATED! is visible
    Then Click Continue button
    Then Verify that Logged in as username is visible
    Then Click on "Delete Account" button on header
  #  Then Verify that "ACCOUNT DELETED!" is visible and click Continue button