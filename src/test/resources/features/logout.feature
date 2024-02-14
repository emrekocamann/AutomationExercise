Feature: Logout User
  @wip
  Scenario Outline: Test Case 4: Login and Logout
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully
    And Click on "Signup / Login" button on header
    And Verify 'Login to your account' is visible on the login form
    And Enter correct "<email>" address and "<password>"
    And Click Login button on Login page
    And Verify that Logged in as "<username>" is visible
    When Click on "Logout" button on header
    Then Verify that user is navigated to login page
    Examples:
      | email                             | password | username |
      | erin.green@hotmail.com            | 12606    | Van      |
      | Randelladrianna.johnson@gmail.com | @&2bV5&  | Randell  |