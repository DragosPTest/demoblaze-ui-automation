  @contact
  Feature: demoblaze.com - Contact Page

    Background:
      Given I navigate to demoblaze.com
      When I click on Contact on navigation bar

    Scenario: Validate successful navigation to Contact Page
      Then I should be presented with the contact pop-up

      Scenario: Validate successful message submission to Contact Page
        And I pass a Contact Email
        And I pass a Contact Name
        And I pass a Message
        When I click on the Send message button
        Then I should see a pop-up containing the following message "Thanks for the message!!"