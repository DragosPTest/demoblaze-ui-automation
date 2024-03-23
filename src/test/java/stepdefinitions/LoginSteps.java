package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;


public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @Before
    public void setup() {

    }

    @Given("I navigate to demoblaze.com website")
    public void i_navigate_to_demoblaze_com() {
        this.loginPage.navigateToDemoBlazeWebsite();

    }

    @And("I click on the LogIn button")
    public void iClickOnTheLogInButton() throws InterruptedException {
        this.loginPage.clickOnLoginButtonMainPage();
    }


    @And("I pass a username {word}")
    public void i_pass_a_correct_username_for_the_login(String correctUserName) throws InterruptedException {
        this.loginPage.inputCorrectUserName(correctUserName);
    }

    @And("I pass an incorrect username {word}")
    public void i_pass_an_incorrect_username_for_the_login(String incorrectUserName) throws InterruptedException {
        Thread.sleep(2000);
        this.loginPage.inputIncorrectUserName(incorrectUserName);
    }

    @And("I pass an empty username ")
    public void i_pass_an_empty_username() throws InterruptedException {
        this.loginPage.emptyUserName();
    }

    @And("I pass a password {word}")
    public void i_pass_a_correct_password_for_the_login(String correctPassword) {
        this.loginPage.inputCorrectPassword(correctPassword);
    }

    @And("I pass an incorrect password {word}")
    public void i_pass_an_incorrect_password_for_the_login(String incorrectPasssword) {
        this.loginPage.inputIncorrectPassword(incorrectPasssword);
    }

    @And("I pass a password ")
    public void i_pass_an_empty_password() {
        this.loginPage.emptyPassword();
    }

    @When("I click on the Login button")
    public void iClickOnTheLoginButton() {
        this.loginPage.clickOnLoginButton();
    }

    @Then("I should see the following validation message {}")
    public void i_should_a_successful_validation_message(String message) throws InterruptedException {
        this.loginPage.loginMessage(message);
    }


    @And("I pass a username ")
    public void i_pass_a_username() throws InterruptedException {
        this.loginPage.emptyUserName();
    }



}
