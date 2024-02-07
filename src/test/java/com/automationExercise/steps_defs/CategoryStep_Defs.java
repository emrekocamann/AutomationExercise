package com.automationExercise.steps_defs;

import com.automationExercise.pages.HomePage;
import com.automationExercise.pages.LeftSideBar;
import com.automationExercise.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CategoryStep_Defs {
    LeftSideBar leftSideBar = new LeftSideBar();
    ProductsPage productsPage = new ProductsPage();
    @Given("Verify that categories are visible on left side bar")
    public void verify_that_categories_are_visible_on_left_side_bar() {
        Assert.assertTrue(leftSideBar.getCategoryPanel().isDisplayed());
    }
    @When("On left side bar, Click on {string} category")
    public void click_on_category(String categoryName) {
        leftSideBar.clickCategory(categoryName);
    }
    @When("Click on {string} link under main {string}")
    public void click_on_link_under_main_category(String subCategoryName,String categoryName) {
        leftSideBar.clickSubCategory(subCategoryName,categoryName);
    }
    @Then("Verify that category page is displayed and confirm text {string}")
    public void verify_that_category_page_is_displayed_and_confirm_text(String title) {
        Assert.assertTrue(productsPage.verifyPageTitle(title));
    }

    @And("On left side bar, Click on {string} category on new page")
    public void onLeftSideBarClickOnCategory(String categoryName) {
        leftSideBar.clickCategory(categoryName);
    }

    @And("Click on  {string} link of {string} category on new page")
    public void onLeftSideBarClickOnLinkOfCategory(String subCategoryName,String categoryName) {
        leftSideBar.clickSubCategory(subCategoryName,categoryName);
    }
}
