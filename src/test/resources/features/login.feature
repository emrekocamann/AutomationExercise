Feature: Positive and Negative Login Test

  Background:
    Given Launch browser
    Given Navigate to url "http://automationexercise.com"
    When Verify that home page is visible successfully
    Given Click on "Signup / Login" button on header
    Given Verify 'Login to your account' is visible on the login form


  Scenario Outline:Test Case 2: Login User with correct email and password
    When Enter correct "<email>" address and "<password>"
    When Click Login button on Login page
    When Verify that Logged in as "<username>" is visible
  #  And  Click on "Delete Account" button on header
   # Then Verify that 'ACCOUNT DELETED!' is visible and click Continue button

    Examples:
      | email                             | password | username |
      | erin.green@hotmail.com            | 12606   | Van      |
      | Randelladrianna.johnson@gmail.com | @&2bV5&  | Randell  |
  #    | Nerystan.strosin@hotmail.com      | w6VxR^7A | Nery     |
  #    | Clementkristofer.prosacco@yahoo.com | Yn6XFbH5198 | Clement  |


  Scenario Outline:Test Case 3: Login User with incorrect email and password
    Given Enter incorrect "<email>" address and "<password>"
    When Click Login button on Login page
    Then Verify error 'Your email or password is incorrect!' is visible on login form
    Examples:
      | email                      | password |
      | erin.green@hotmail.com     | 126062    |
      | adrianna.johnson@gmail.com | @&2bV5&  |
 #     | stan.strosin@hotmail.com   | w6VxR^7A |
 #     | kristofer.prosacco@yahoo.com | Yn6XFbH5198 |