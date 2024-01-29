Feature: Products
  @wip
  Scenario: Test Case 8: Verify All Products and product detail page
    Given Launch browser
    And Navigate to url "http://automationexercise.com"
    And Verify that home page is visible successfully
    When Click on "Products" button on header
    Then  Verify user is navigated to ALL PRODUCTS page successfully
    And  The products list is visible
    And Click on View Product of first product
    And User is landed to product detail page
    Then  Verify that detail is visible: product name, category, price, availability, condition, brand