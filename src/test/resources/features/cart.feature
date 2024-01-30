Feature: Add to Cart
  @wip
    Scenario: Test Case 12: Add Products in Cart
      Given Launch browser
      And Navigate to url "http://automationexercise.com"
      And Verify that home page is visible successfully
      And Click on "Products" button on header
      When Hover over product 6 and click Add to cart
      And  Click "Continue Shopping" button on PopUp
      And Hover over product 7 and click Add to cart
      And Click "View Cart" button on PopUp
      Then Verify both products are added to Cart
      Then Verify their prices, quantity and total price

  Scenario: Test Case 13: Verify Product quantity in Cart
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully
    When Click 'View Product' for any product on home page
    And Verify product detail is opened
    And Increase quantity to 4
    And Click 'Add to cart' button on product details page
    And Click 'View Cart' button on PopUp
    Then Verify that product is displayed in cart page with exact quantity