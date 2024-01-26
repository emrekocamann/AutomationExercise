Feature: Login Test

  Background:
    Given Launch browser
    Given Navigate to url "http://automationexercise.com"
    When Verify that home page is visible successfully
    Given Click on "Signup / Login" button on header
    Given Verify 'Login to your account' is visible on the login form

  @wip
  Scenario Outline:Test Case 2: Login User with correct email and password
    When Enter correct "<email>" address and "<password>"
    When Click Login button on Login page
    When Verify that Logged in as "<username>" is visible
  #  And  Click on "Delete Account" button on header
   # Then Verify that 'ACCOUNT DELETED!' is visible

    Examples:
      | email                  | password | username |
      | erin.green@hotmail.com | 12606    | Van      |

  Scenario:Test Case 3: Login User with incorrect email and password
    Given Enter incorrect email address and password
    When Click 'login' button
    Then Verify error 'Your email or password is incorrect!' is visible