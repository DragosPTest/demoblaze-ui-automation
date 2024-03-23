@login
Feature: demoblaze.com - Login Page

  Background:
    Given I navigate to demoblaze.com website
    And I click on the LogIn button

  Scenario Outline: Validate Successful & Unsuccessful Login
    And I pass a username <username>
    And I pass a password <password>
    When I click on the Login button
    Then I should see the following validation message <loginValidationMessage>
    Examples:
      | username     | password     | loginValidationMessage                 |
      | JohnDoe1234  | JohnDoe1234  | Welcome JohnDoe1234                    |
      | JohnDoe1234  | JohnDoe12345 | Wrong password.                        |
      | JohnDoe12345 | JohnDoe1234  | User does not exist.                   |
      |              |              | Please fill out Username and Password  |