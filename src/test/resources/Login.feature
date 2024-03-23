@regression
Feature: demoblaze.com - Login Page

  Scenario: Validate successful Login

    Given I navigate to demoblaze.com website
    And I click on the Log In button
    And I pass "JohnDoe1234" for the username field
    And I pass "JohnDoe1234" for the password field
    When I click on the Login Button
    Then I should see a "Welcome JohnDoe1234" message