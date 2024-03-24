package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactPage;

public class ContactSteps {
    private ContactPage contactPage;
    public ContactSteps(){
        this.contactPage = new ContactPage();
    }
    @When("I click on Contact on navigation bar")
    public void i_click_on_contact_on_navigation_bar() {
       this.contactPage.clickOnContactButton();
    }

    @Then("I should be presented with the contact pop-up")
    public void i_should_be_presented_with_the_contact_pop_up() throws InterruptedException{
      this.contactPage.contactPopUpForm();
    }
}
