
Feature: Place Order
  Background:
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully

  Scenario: Test Case 14: Place Order: Register while Checkout
    Given Add products to cart
    And Click on "Cart" button on header
    And  Verify that cart page is displayed
    And Click Proceed To Checkout button
    And Click "Register / Login" button on PopUp
    When Fill all details in Signup and create account
    And Verify that ACCOUNT CREATED! is visible
    And Click Continue button
    And Verify that Logged in as username is visible
    And Click on "Cart" button on header
    Then Click Proceed To Checkout button
    And Verify Address Details and Review Your Order
    And Enter description in comment text area and click Place Order
    And Enter payment details: Name on Card, Card Number, CVC, Expiration date
    And Click Pay and Confirm Order button
    And Verify success message "Congratulations! Your order has been confirmed!" after payment
    And Click on "Delete Account" button on header
    And Verify that "ACCOUNT DELETED!" is visible and click Continue button

  Scenario: Test Case 15: Place Order: Register before Checkout
    Given Click on "Signup / Login" button on header
    And Fill all details in Signup and create account
    And Verify that ACCOUNT CREATED! is visible
    And Click Continue button
    And Verify that Logged in as username is visible
    When Add products to cart
    And Click on "Cart" button on header
    And Verify that cart page is displayed
    Then Click Proceed To Checkout button
    And Verify Address Details and Review Your Order
    And Enter description in comment text area and click Place Order
    And Enter payment details: Name on Card, Card Number, CVC, Expiration date
    And Click Pay and Confirm Order button
    And Verify success message "Congratulations! Your order has been confirmed!" after payment
    And Click on "Delete Account" button on header
    And Verify that "ACCOUNT DELETED!" is visible and click Continue button

  Scenario: Test Case 16: Place Order: Login before Checkout
    Given Click on "Signup / Login" button on header
    And Fill "erin.green@hotmail.com", "12606" and click Login button
    And Verify that Logged in as username is visible
    When Add products to cart
    And Click on "Cart" button on header
    And Verify that cart page is displayed
    Then Click Proceed To Checkout button
    And Verify Address Details and Review Your Order
    And Enter description in comment text area and click Place Order
    And Enter payment details: Name on Card, Card Number, CVC, Expiration date
    And Click Pay and Confirm Order button
    And Verify success message "Congratulations! Your order has been confirmed!" after payment
  #  And Click on "Delete Account" button on header
  #  And Verify that "ACCOUNT DELETED!" is visible and click Continue button

  Scenario: Test Case 23: Verify address details in checkout page
    Given Click on "Signup / Login" button on header
    And Fill all details in Signup and create account
    And Verify that ACCOUNT CREATED! is visible
    And Click Continue button
    And Verify that Logged in as username is visible
    When Add products to cart
    And Click on "Cart" button on header
    And Verify that cart page is displayed
    Then Click Proceed To Checkout button
    And Verify that the delivery address is same address filled at the time registration of account
    And Verify that the billing address is same address filled at the time registration of account
    And Click on "Delete Account" button on header
    And Verify that "ACCOUNT DELETED!" is visible and click Continue button
  @wip
  Scenario: Test Case 24: Download Invoice after purchase order
    Given Add products to cart
    And Click on "Cart" button on header
    And  Verify that cart page is displayed
    And Click Proceed To Checkout button
    And Click "Register / Login" button on PopUp
    And Fill all details in Signup and create account
    And Verify that ACCOUNT CREATED! is visible
    And Click Continue button
    And Verify that Logged in as username is visible
    And Click on "Cart" button on header
    And Click Proceed To Checkout button
    And Verify Address Details and Review Your Order
    When Enter description in comment text area and click Place Order
    And Enter payment details: Name on Card, Card Number, CVC, Expiration date
    And Click Pay and Confirm Order button
    And Verify success message "Congratulations! Your order has been confirmed!" after payment
    Then Click 'Download Invoice' button
    And Verify invoice is downloaded successfully.
    And Click Continue button
    And Click on "Delete Account" button on header
    And Verify that "ACCOUNT DELETED!" is visible and click Continue button


