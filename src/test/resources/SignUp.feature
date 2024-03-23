@signup
Feature: demoblaze.com - SignUp Page

  Background:
    Given I navigate to demoblaze.com
    And I click on the Sign Up button

  Scenario: Validate successful Sign-Up with unique details for the UserName and Password
    And I pass an unique UserName
    And I pass an unique Password
    When I click on the SignUp button
    Then I should see a successful validation pop-up for the sign up

  Scenario: Validate unsuccessful Sign-Up when attempting to register with already existing UserName and Password
    And I pass an UserName that was already used for registration
    And I pass a Password that was already used for registration
    When I click on the SignUp button
    Then I should see an unsuccessful validation failure pop-up for the sign up

    Scenario: Validate unsuccessful Sign-Up when both UserName and Password fields are left blank
      And the UserName field is left blank
      And the Password field is left blank
      When I click on the SignUp button
      Then I should see an unsuccessful validation failure pop-up for the sign up