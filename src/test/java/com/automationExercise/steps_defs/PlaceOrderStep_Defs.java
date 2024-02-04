package com.automationExercise.steps_defs;

import com.automationExercise.pages.CheckoutPage;
import com.automationExercise.pages.HomePage;
import com.automationExercise.pages.ShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PlaceOrderStep_Defs {
    HomePage homePage = new HomePage();
    ShoppingCartPage cartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    @Given("Add products to cart")
    public void add_products_to_cart() {
        homePage.hoverAndClickAddToCartWithRowNumber(3);
        homePage.clickViewCartOrContinueShopping("Continue Shopping");
        homePage.hoverAndClickAddToCartWithRowNumber(4);
        homePage.clickViewCartOrContinueShopping("Continue Shopping");
        homePage.hoverAndClickAddToCartWithRowNumber(5);
        homePage.clickViewCartOrContinueShopping("Continue Shopping");
    }
    @Given("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        Assert.assertTrue(cartPage.getShoppingCartBreadcrumbText().isDisplayed());
    }
    @Given("Click Proceed To Checkout button")
    public void click_proceed_to_checkout_button() {
       cartPage.getProceedToCheckoutButton().click();
    }
    @Then("Verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {
        Assert.assertTrue(checkoutPage.verifyAddressDetails());
        Assert.assertTrue(checkoutPage.reviewYourOrder());
    }
    @Then("Enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click() {
        checkoutPage.typeCommentInTExtArea();
        checkoutPage.getPlaceOrderButton().click();
    }
    @Then("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {

    }
    @Then("Click {string} button")
    public void click_button(String string) {

    }
    @Then("Verify success message {string}")
    public void verify_success_message(String string) {

    }
}
