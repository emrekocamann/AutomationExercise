package com.automationExercise.steps_defs;

import com.automationExercise.pages.BasePage;
import com.automationExercise.pages.ProductDetailsPage;
import com.automationExercise.pages.ProductsPage;
import com.automationExercise.pages.ShoppingCartPage;
import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

public class ProductsStep_Defs {
    ProductsPage productsPage = new ProductsPage();
    ProductDetailsPage detailsPage = new ProductDetailsPage();
    SoftAssertions softAssertions = new SoftAssertions();
    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        softAssertions.assertThat(productsPage.getAllProductsText().isDisplayed()).isTrue();
        softAssertions.assertThat(productsPage.getAllProducts().isDisplayed()).isTrue();
        softAssertions.assertAll();
    }
    @Then("The products list is visible")
    public void the_products_list_is_visible() {
        Assert.assertTrue(productsPage.getProductsList().size()>0);
    }
    @Then("Click on View Product of first product")
    public void click_on_of_first_product() {
        productsPage.clickViewProductsWithProductsIndex(0);
    }
    @Then("User is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        String actualUrl = Driver.get().getCurrentUrl();
        String expectedEndPoint= "product_details/"+ BasePage.currentProductId;
        Assert.assertTrue(actualUrl.contains(expectedEndPoint));
    }
    @Then("Verify that detail is visible: product name, category, price, availability, condition, brand")
    public void verify_that_detail_is_visible_product_name_category_price_availability_condition_brand() {
        softAssertions.assertThat(detailsPage.getProductName().isDisplayed()).isTrue();
        softAssertions.assertThat(detailsPage.getProductCategory().isDisplayed()).isTrue();
        softAssertions.assertThat(detailsPage.getProductPrice().isDisplayed()).isTrue();
        softAssertions.assertThat(detailsPage.getProductAvailability().isDisplayed()).isTrue();
        softAssertions.assertThat(detailsPage.getProductCondition().isDisplayed()).isTrue();
        softAssertions.assertThat(detailsPage.getProductBrand().isDisplayed()).isTrue();
        softAssertions.assertAll();
    }
    @Then("Enter {string} in search input and click search button")
    public void enter_in_search_input_and_click_search_button(String productName) {
        productsPage.searchProducts(productName);
    }
    @Then("Verify SEARCHED PRODUCTS is visible")
    public void verify_searched_products_is_visible() {
        Assert.assertTrue(productsPage.getSearchedProductsText().isDisplayed());
    }
    @Then("Verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
      Assert.assertTrue(productsPage.verifyAllTheProductsRelatedToSearchAreVisible());
    }
    @When("Hover over product {int} and click Add to cart")
    public void hover_over_product_and_click_add_to_cart(int productNumber) {
        productsPage.hoverAndClickAddToCartWithRowNumber(productNumber);
    }
    @When("Click {string} button on PopUp")
    public void click_button_on_pop_up(String text) {
        BrowserUtils.waitForVisibility(productsPage.getAddedPopUp());
        productsPage.clickViewCartOrContinueShopping(text);
    }

    @Then("Verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.verifyProductsAreAddedToCart());
    }
}
