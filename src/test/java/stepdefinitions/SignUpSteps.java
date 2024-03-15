package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;

public class SignUpSteps {

    private SignUpPage signUpPage;

    public SignUpSteps() {
        this.signUpPage = new SignUpPage();
    }


    @Before
    public void setup() {

    }


    @Given("I navigate to demoblaze.com")
    public void i_navigate_to_demoblaze_com() {
        this.signUpPage.NavigateToDemoBlazeWebsite();

    }

    @And("I click on the Sign Up button")
    public void iClickOnTheSignUpButton() throws InterruptedException{
        this.signUpPage.SignUpButtonMainPageClick();
    }

    @And("I pass an unique UserName")
    public void i_pass_an_unique_user_name() throws InterruptedException{
        this.signUpPage.InputUserName();

    }
    @And("I pass an UserName that was already used for registration")
    public void iPassAnUserNameThatWasAlreadyUsedForRegistration() throws InterruptedException {
        this.signUpPage.UserNameAlreadyUsed();
    }

    @And("I pass an unique Password")
    public void i_pass_an_unique_password() {
        this.signUpPage.InputPassword();
    }

    @And("I pass a Password that was already used for registration")
    public void iPassAPasswordThatWasAlreadyUsedForRegistration() {
        this.signUpPage.previouslyUsedPassword();
    }

    @When("I click on the SignUp button")
    public void i_click_on_the_sign_up_button() {
        this.signUpPage.ClickOnTheSignUpButton();
    }

    @Then("I should see a successful validation pop-up for the sign up")
    public void i_should_see_a_successful_validation_pop_up_for_the_sign_up() throws InterruptedException{
        this.signUpPage.SignUpMessage();
    }


    @Then("I should see an unsuccessful validation failure pop for the sign up")
    public void iShouldSeeAnUnsuccessfulValidationFailurePopForTheSignUp() throws InterruptedException{
        this.signUpPage.SignUpMessage();

    }
}