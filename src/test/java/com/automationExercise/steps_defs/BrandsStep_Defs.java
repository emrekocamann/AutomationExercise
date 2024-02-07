package com.automationExercise.steps_defs;

import com.automationExercise.pages.HomePage;
import com.automationExercise.pages.LeftSideBar;
import com.automationExercise.pages.ProductsPage;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;

public class BrandsStep_Defs {
    LeftSideBar leftSideBar = new LeftSideBar();
    ProductsPage productsPage = new ProductsPage();
    @Given("Verify that Brands are visible on left side bar")
    public void verify_that_brands_are_visible_on_left_side_bar() {
        Assert.assertTrue(leftSideBar.getBrandsPanel().isDisplayed());
    }
    @Given("On left side bar, click on {string} name")
    public void on_left_side_bar_click_on_name(String brand) {
        leftSideBar.clickBrand(brand);
    }

    @Then("Verify that user is navigated to that {string} and can see {string}")
    public void verify_that_user_is_navigated_to_that_and_can_see(String endPoint, String title) {
        Assert.assertTrue(productsPage.verifyPageTitle(title));
        endPoint= endPoint.trim().replace(" ","%20");
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(endPoint));
    }

}
