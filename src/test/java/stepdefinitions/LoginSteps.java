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
    
    @And("I click on the Log In button")
    public void iClickOnTheLogInButton() throws InterruptedException{
        this.loginPage.clickOnLoginButtonMainPage();
    }

    @And("I pass {string} for the username field")
    public void iAddAnExistingUsername(String existingUser) throws InterruptedException{
        this.loginPage.inputUserName(existingUser);
    }

    @And("I pass {string} for the password field")
    public void iAddAnExistingPassword(String existingPassword) {
        this.loginPage.inputPassword(existingPassword);
    }

    @When("I click on the Login Button")
    public void iClickOnTheLoginButton()
    {
        this.loginPage.clickOnLoginButton();
    }

    @Then("I should see a {string} message")
    public void iShouldSeeAWelcomeMessageContainingMyName(String welcomeMessageLogin)throws InterruptedException {
        this.loginPage.successfullyLoggedIn(welcomeMessageLogin);
    }
}
