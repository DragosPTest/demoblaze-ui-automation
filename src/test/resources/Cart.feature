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