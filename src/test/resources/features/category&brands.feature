Feature: View Category Products

  Background:
    Given Launch browser
    And Navigate to url "http://automationexercise.com"


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

  @wip
  Scenario Outline: Test Case 19: View & Cart Brand Products
    Given Click on "Products" button on header
    And Verify that Brands are visible on left side bar
    And On left side bar, click on "<brand>" name
    And Verify that user is navigated to that "<brand page>" and can see "<title>"
    When On left side bar, click on "<other brand>" name
    Then Verify that user is navigated to that "<brand page-2>" and can see "<title-2>"
    Examples:
      | brand       | brand page  | title                        | other brand        | brand page-2       | title-2                             |
      | POLO        | Polo        | BRAND - POLO PRODUCTS        | H&M                | H&M                | BRAND - H&M PRODUCTS                |
      | MADAME      | Madame      | BRAND - MADAME PRODUCTS      | MAST & HARBOUR     | Mast & Harbour     | BRAND - MAST & HARBOUR PRODUCTS     |
      | BABYHUG     | Babyhug     | BRAND - BABYHUG PRODUCTS     | ALLEN SOLLY JUNIOR | Allen Solly Junior | BRAND - ALLEN SOLLY JUNIOR PRODUCTS |
      | KOOKIE KIDS | Kookie Kids | BRAND - KOOKIE KIDS PRODUCTS | BIBA               | Biba               | BRAND - BIBA PRODUCTS               |