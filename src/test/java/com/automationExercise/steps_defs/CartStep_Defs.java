package com.automationExercise.steps_defs;

import com.automationExercise.pages.HomePage;
import com.automationExercise.pages.ProductDetailsPage;
import com.automationExercise.pages.ShoppingCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class CartStep_Defs {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    HomePage homePage = new HomePage();
    ProductDetailsPage detailsPage = new ProductDetailsPage();
    SoftAssertions softAssertions = new SoftAssertions();
    @Then("Verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() {
        boolean name = shoppingCartPage.verifyProductNamesOrPrices(shoppingCartPage.getListOfProductNamesInTheCart(), "name");
        boolean price = shoppingCartPage.verifyProductNamesOrPrices(shoppingCartPage.getListOfProductPricesInTheCart(), "price");
        boolean id = shoppingCartPage.verifyProductId();
        boolean quantity=shoppingCartPage.verifyQuantity();
        boolean totalPrice = shoppingCartPage.verifyProductTotalPrices();

        softAssertions.assertThat(name).isTrue();
        softAssertions.assertThat(price).isTrue();
        softAssertions.assertThat(id).isTrue();
        softAssertions.assertThat(quantity).isTrue();
        softAssertions.assertThat(totalPrice).isTrue();

        softAssertions.assertAll();
    }
    @When("Click View Product for {string} on home page")
    public void click_view_product_for_on_home_page(String productName) {
        homePage.clickViewProductWithName(productName);
    }
    @When("Increase quantity to {int}")
    public void increase_quantity_to(int quantity) {
       detailsPage.increaseQuantityTo(quantity);
    }
    @When("Click Add to cart button on product details page")
    public void click_add_to_cart_button_on_product_details_page() {
        detailsPage.clickAddToCartButtonAndAddProductToCart();
    }
    @Then("Verify that product is displayed in cart page with exact quantity")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
        shoppingCartPage.verifyQuantity();
    }
}
