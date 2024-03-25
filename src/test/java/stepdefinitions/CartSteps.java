package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;


public class CartSteps {
    private CartPage cartPage;

    public CartSteps() {
        this.cartPage = new CartPage();
    }

    @And("I click on phone")
    public void i_click_on_phone() {
        this.cartPage.clickOnPhoneProduct();
    }

    @And("I click on monitor")
    public void i_click_on_monitor() {
        this.cartPage.clickOnMonitorProduct();
    }

    @And("I click on laptop")
    public void i_click_on_laptop() {
        this.cartPage.clickOnLaptopProduct();
    }

    @When("I click on Add to cart button")
    public void i_click_on_add_to_cart_button() {
        this.cartPage.clickOnAddToCartButton();
    }

    @Then("I should see a successful validation pop-up Product added")
    public void i_should_see_a_successful_validation_pop_up_product_added() {
        this.cartPage.productAddedToCart();

    }


}
