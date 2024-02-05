Feature: Add to Cart / Remove Products From Cart

    Background:
      Given Launch browser
      And Navigate to url "http://automationexercise.com"
      And Verify that home page is visible successfully

    Scenario: Test Case 12: Add Products in Cart
      Given Launch browser
      And Navigate to url "http://automationexercise.com"
      And Verify that home page is visible successfully
      And Click on "Products" button on header
      When Hover over product 1 and click Add to cart
      And  Click "Continue Shopping" button on PopUp
      And Hover over product 2 and click Add to cart
      And Click "View Cart" button on PopUp
      Then Verify both products are added to Cart
      Then Verify their prices, quantity and total price

    Scenario: Test Case 13: Verify Product quantity in Cart
      When Click View Product for "Premium Polo T-Shirts" on home page
      And User is landed to product detail page
      And Increase quantity to 4
      And Click Add to cart button on product details page
      And Click 'View Cart' button on PopUp
      Then Verify that product is displayed in cart page with exact quantity
    @wip
    Scenario: Test Case 17: Remove Products From Cart
      Given Add products to cart
      And Click on "Cart" button on header
      And  Verify that cart page is displayed
      When Click X button corresponding to particular product
      Then Verify that product is removed from the cart