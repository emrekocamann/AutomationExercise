Feature: Add to Cart / Remove Products From Cart

    Background:
      Given Launch browser
      And Navigate to url "http://automationexercise.com"
      And Verify that home page is visible successfully
   @wip
    Scenario: Test Case 12: Add Products in Cart
      And Click on "Products" button on header
      When Hover over product 1 and click Add to cart
      And  Click "Continue Shopping" button on PopUp
      And Hover over product 2 and click Add to cart
      And Click "View Cart" button on PopUp
      Then Verify that products are added to Cart
      Then Verify their prices, quantity and total price

    Scenario: Test Case 13: Verify Product quantity in Cart
      When Click View Product for "Premium Polo T-Shirts" on home page
      And User is landed to product detail page
      And Increase quantity to 4
      And Click Add to cart button on product details page
      And Click 'View Cart' button on PopUp
      Then Verify that product is displayed in cart page with exact quantity

    Scenario: Test Case 17: Remove Products From Cart
      Given Add products to cart
      And Click on "Cart" button on header
      And  Verify that cart page is displayed
      When Click X button corresponding to particular product
      Then Verify that product is removed from the cart

    Scenario: Test Case 20: Search Products and Verify Cart After Login
      Given Click on "Products" button on header
      And Verify that "ALL PRODUCTS" title is visible
      And  Enter "Saree" in search input and click search button
      And Verify that "SEARCHED PRODUCTS" title is visible
      When Verify all the products related to search are visible
      And Add those products to cart
      And Click on "Cart" button on header
      And Verify that products are added to Cart
      And Click on "Signup / Login" button on header
      And Enter correct "erin.green@hotmail.com" address and "1260612606"
      And Click on "Cart" button on header
      Then Verify that those products are visible in cart after login as well

    Scenario: Test Case 22: Add to cart from Recommended items
      Given Scroll down to footer
      And Verify 'RECOMMENDED ITEMS' are visible
      When Click on Add To Cart on any recommended product
      And Click 'View Cart' button on PopUp
      Then Verify that products are added to Cart