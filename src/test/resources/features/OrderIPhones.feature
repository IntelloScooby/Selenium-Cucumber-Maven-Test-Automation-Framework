Feature: Validate ordering iPhones from the website

  Scenario: Validate ordering an iPhone by navigating from the top menu bar
    Given the user navigates to home page
    When the user clicks on the "Technology" option from the top menu
    And the user clicks on the "iPhones & Mobile Phones" option from the product category list page
    And the user clicks on the "Apple iPhones" option from the product category list page
    Then the "Apple iPhones" product list page is displayed
    When the user adds the first "2" products to the cart
    And the user navigates to the cart
    Then the same items are displayed in the cart