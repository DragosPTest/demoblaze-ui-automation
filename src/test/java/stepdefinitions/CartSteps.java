package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

    @And("I click on a product")
    public void iClickOnAProduct() {
        this.cartPage.clickOnMonitorProduct();
    }

    @When("I add the product to cart")
    public void iAddTheProductToCart() {
        this.cartPage.clickOnAddToCartButton();
    }

    @And("I click on the first product")
    public void iClickOnTheFirstProduct() {
        this.cartPage.clickOnPhoneProduct();
    }

    @And("I click on the second product")
    public void iClickOnTheSecondProduct() {
        this.cartPage.clickOnMonitorProduct();

    }

    @And("I click on Home on navigation bar")
    public void iClickOnHomeOnNavigationBar() {
        this.cartPage.clickOnHomeButtonMaiPage();
    }

    @And("I click on delete button")
    public void iClickOnDeleteButton() {
        this.cartPage.clickOnDeleteButton();

    }




    @When("I click on Add to cart button")
    public void i_click_on_add_to_cart_button() {
        this.cartPage.clickOnAddToCartButton();
    }

    @When("I click on Cart on navigation bar")
    public void iClickOnCartOnNavigationBar() {
        this.cartPage.clickOnCartButtonMainPage();
    }

    @Then("I should see a successful validation pop-up Product added")
    public void i_should_see_a_successful_validation_pop_up_product_added() {
        this.cartPage.productAddedToCart();

    }

    @Then("I should see that the total price is equal with the product price")
    public void iShouldSeeThatTheTotalPriceIsEqualWithTheProductPrice() {
        this.cartPage.totalPrice();
    }

    @Then("the product is successfully added to the cart")
    public void theProductIsSuccessfullyAddedToTheCart() {
        this.cartPage.productAddedToCart();
    }


    @Then("I should see that the total price is the sum of the prices of the first, second, and third products")
    public void iShouldSeeThatTheTotalPriceIsTheSumOfThePricesOfTheFirstSecondAndThirdProducts() {
        this.cartPage.getThePriceOfProducts();
        this.cartPage.sumOfProducts();

    }

    @Then("I should see that the product was successfully removed from the cart")
    public void iShouldSeeThatTheProductWasSuccessfullyRemovedFromTheCart() {
        this.cartPage.totalPrice();
    }

    @Then("I should see that the total price represents the difference between the prices of the two products.")
    public void iShouldSeeThatTheTotalPriceRepresentsTheDifferenceBetweenThePricesOfTheTwoProducts() {
       this.cartPage.totalPriceSubtraction();
    }
    @And("I check the prices")
    public void iCheckThePrices() {
        this.cartPage.getThePriceOfProducts();
    }


    @And("I check the prices again")
    public void iCheckThePricesAgain() {
        this.cartPage.getThePriceOfProducts();
    }
}
