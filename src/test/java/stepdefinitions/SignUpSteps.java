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
        this.signUpPage.navigateToDemoBlazeWebsite();

    }

    @And("I click on the Sign Up button")
    public void iClickOnTheSignUpButton() throws InterruptedException {
        this.signUpPage.signUpButtonMainPageClick();
    }

    @And("I pass an unique UserName")
    public void i_pass_an_unique_user_name() throws InterruptedException {
        this.signUpPage.inputUserName();

    }

    @And("I pass an UserName that was already used for registration")
    public void iPassAnUserNameThatWasAlreadyUsedForRegistration() throws InterruptedException {
        this.signUpPage.userNameAlreadyUsed();
    }

    @And("the UserName field is left blank")
    public void theUserNameFieldIsLeftBlank() throws InterruptedException{
       this.signUpPage.emptyUserName();
    }

    @And("I pass an unique Password")
    public void i_pass_an_unique_password() {
        this.signUpPage.inputPassword();
    }

    @And("I pass a Password that was already used for registration")
    public void iPassAPasswordThatWasAlreadyUsedForRegistration() {
        this.signUpPage.previouslyUsedPassword();
    }

    @And("the Password field is left blank")
    public void thePasswordFieldIsLeftBlank() {
      this.signUpPage.emptyPassword();
    }

    @When("I click on the SignUp button")
    public void i_click_on_the_sign_up_button() {
        this.signUpPage.clickOnTheSignUpButton();
    }

    @Then("I should see a successful validation pop-up for the sign up")
    public void i_should_see_a_successful_validation_pop_up_for_the_sign_up() throws InterruptedException {
        this.signUpPage.signUpMessage();
    }


    @Then("I should see an unsuccessful validation failure pop-up for the sign up")
    public void iShouldSeeAnUnsuccessfulValidationFailurePopForTheSignUp() throws InterruptedException {
        this.signUpPage.signUpMessage();

    }

}