Feature: Products

  Background:
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully
    When Click on "Products" button on header
    Then Verify that "ALL PRODUCTS" title is visible

  Scenario: Test Case 8: Verify All Products and product detail page
    And  The products list is visible
    And Click on View Product of first product
    And User is landed to product detail page
    Then  Verify that detail is visible: product name, category, price, availability, condition, brand


  Scenario: Test Case 9: Search Product
    And  Enter "jeans" in search input and click search button
    And Verify that "SEARCHED PRODUCTS" title is visible
    Then Verify all the products related to search are visible

  Scenario: Test Case 21: Add review on product
    Given Click on View Product of first product
    And Verify "Write Your Review" is visible
    When Enter name, email and review and Click Submit button
    Then Verify success message "Thank you for your review." after review
