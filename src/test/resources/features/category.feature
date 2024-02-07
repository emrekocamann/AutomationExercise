Feature: View Category Products

  Background:
    Given Launch browser
    And Navigate to url "http://automationexercise.com"

  @wip
  Scenario Outline: Test Case 18: View Category Products
    Given Verify that categories are visible on left side bar
    When On left side bar, Click on "<category>" category
    And Click on "<sub-category>" link under main "<category>"
    Then Verify that category page is displayed and confirm text "<title>"
    And On left side bar, Click on "<category-2>" category on new page
    And Click on  "<sub-category-2>" link of "<category-2>" category on new page
    Then Verify that category page is displayed and confirm text "<title-2>"

    Examples:
      | category | sub-category  | title                         | category-2 | sub-category-2 | title-2                       |
      | WOMEN    | DRESS         | WOMEN - DRESS PRODUCTS        | MEN        | TSHIRTS        | MEN - TSHIRTS PRODUCTS        |
      | WOMEN    | TOPS          | WOMEN - TOPS PRODUCTS         | KIDS       | TOPS & SHIRTS  | KIDS - TOPS & SHIRTS PRODUCTS |
      | WOMEN    | SAREE         | WOMEN - SAREE PRODUCTS        | MEN        | JEANS          | MEN - JEANS PRODUCTS          |
      | MEN      | TSHIRTS       | MEN - TSHIRTS PRODUCTS        | WOMEN      | TOPS           | WOMEN - TOPS PRODUCTS         |
      | MEN      | JEANS         | MEN - JEANS PRODUCTS          | KIDS       | DRESS          | KIDS - DRESS PRODUCTS         |
      | KIDS     | DRESS         | KIDS - DRESS PRODUCTS         | WOMEN      | DRESS          | WOMEN - DRESS PRODUCTS        |
      | KIDS     | TOPS & SHIRTS | KIDS - TOPS & SHIRTS PRODUCTS | WOMEN      | SAREE          | WOMEN - SAREE PRODUCTS        |