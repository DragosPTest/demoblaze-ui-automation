@cart
Feature: demoblaze.com - Cart

  Background:
    Given I navigate to demoblaze.com

  Scenario Outline: Validate adding all types of products to cart
    And I click on <product>
    When I click on Add to cart button
    Then I should see a successful validation pop-up <message>
    Examples:
      | product | message       |
      | phone   | Product added |
      | monitor | Product added |
      | laptop  | Product added |


  Scenario: Validate the total price paid - Single Product
    And I click on a product
    And I add the product to cart
    And the product is successfully added to the cart
    When I click on Cart on navigation bar
    Then I should see that the total price is equal with the product price


  Scenario: Validate the total price paid - Multiple Products
    And I click on the first product
    And I add the product to cart
    Then the product is successfully added to the cart
    And I click on Home on navigation bar
    And I click on the second product
    And I add the product to cart
    Then the product is successfully added to the cart
    And I click on Home on navigation bar
    And I click on the third product
    When I add the product to cart
    Then the product is successfully added to the cart
    When I click on Cart on navigation bar
    Then I should see that the total price is the sum of the prices of the first, second, and third products


