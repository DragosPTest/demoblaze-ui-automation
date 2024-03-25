package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactPage;

public class ContactSteps {
    private ContactPage contactPage;

    public ContactSteps() {
        this.contactPage = new ContactPage();
    }

    @When("I click on Contact on navigation bar")
    public void i_click_on_contact_on_navigation_bar() {
        this.contactPage.clickOnContactButton();
    }

    @Then("I should be presented with the contact pop-up")
    public void i_should_be_presented_with_the_contact_pop_up() throws InterruptedException {
        this.contactPage.contactPopUpForm();
    }

    @And("I pass a Contact Email")
    public void iPassAContactEmail() throws InterruptedException {
        this.contactPage.recipientEmail();
    }

    @And("I pass a Contact Name")
    public void iPassAContactName() {
        this.contactPage.recipientName();
    }

    @And("I pass a Message")
    public void iPassAMessage() {
        this.contactPage.messageText();
    }

    @When("I click on the Send message button")
    public void iClickOnTheSendMessageButton() {
        this.contactPage.sendMessageButtonClick();
    }

    @Then("I should see a pop-up containing the following message {string}")
    public void iShouldSeeAPopUpContainingTheFollowingMessage(String message) throws InterruptedException {
        this.contactPage.successfullySendingTheMessage(message);
    }
}
