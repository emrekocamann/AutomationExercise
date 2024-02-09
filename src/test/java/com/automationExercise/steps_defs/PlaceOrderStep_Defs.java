package com.automationExercise.steps_defs;

import com.automationExercise.pages.*;
import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderStep_Defs {
    HomePage homePage = new HomePage();
    ShoppingCartPage cartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    PaymentPage paymentPage = new PaymentPage();
    LoginPage loginPage = new LoginPage();
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
        paymentPage.fillOutPaymentInfo();
    }
    @Then("Click Pay and Confirm Order button")
    public void click_button() {
            paymentPage.getPayAndConfirmOrderButton().click();
    }
    @Then("Verify success message {string} after payment")
    public void verify_success_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,paymentPage.getSuccessMessage().getText().trim());
    }
    @Given("Fill {string}, {string} and click Login button")
    public void fill_and_click_login_button(String email, String password) {
        loginPage.fillOutLoginForm(email,password);
        loginPage.getLoginButton().click();
    }
    @Then("Verify that the delivery address is same address filled at the time registration of account")
    public void verify_that_the_delivery_address_is_same_address_filled_at_the_time_registration_of_account() {
        Assert.assertTrue(checkoutPage.verifyAddressDetails());
    }
    @Then("Verify that the billing address is same address filled at the time registration of account")
    public void verify_that_the_billing_address_is_same_address_filled_at_the_time_registration_of_account() {
        Assert.assertTrue(checkoutPage.verifyBillingAddressDetails());
    }
    @Then("Click {string} button")
    public void click_button_and_verify_invoice_is_downloaded_successfully(String text) {
        Driver.get().findElement(By.xpath("//a[text()='"+text+"']")).click();
        BrowserUtils.waitFor(5);
    }
    @Then("Verify invoice is downloaded successfully.")
    public void verify_invoice_is_downloaded_successfully() {
        BrowserUtils.verifyDownloadedFile("invoice.txt");
    }

}
