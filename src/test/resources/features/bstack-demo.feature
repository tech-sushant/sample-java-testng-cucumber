Feature: BrowserStack Demo Shopping Cart
  As a user of the BrowserStack demo website
  I want to add products to my cart
  So that I can proceed with my purchase

  Scenario: Add product to cart
    Given I am on the BrowserStack demo website
    When I add a product to the cart
    Then I should see the product in the cart
