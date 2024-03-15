@regression
Feature: demoblaze.com - SignUp Page

  Background:
    Given I navigate to demoblaze.com
    And I click on the Sign Up button

  Scenario: Verify successful sign up
    And I pass an unique UserName
    And I pass an unique Password
    When I click on the SignUp button
    Then I should see a successful validation pop-up for the sign up

  Scenario: Verify unsuccessful sign up - Using the same data
    And I pass an UserName that was already used for registration
    And I pass a Password that was already used for registration
    When I click on the SignUp button
    Then I should see an unsuccessful validation failure pop for the sign up