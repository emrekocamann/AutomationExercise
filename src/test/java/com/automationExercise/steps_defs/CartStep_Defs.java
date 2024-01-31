package com.automationExercise.steps_defs;

import com.automationExercise.pages.ShoppingCartPage;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

public class CartStep_Defs {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
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
}
