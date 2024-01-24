package com.automationExercise.steps_defs;

import com.automationExercise.pages.HomePage;
import com.automationExercise.pages.Signup_LoginPage;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;


public class RegisterStep_Defs {

    HomePage homePage = new HomePage();
    Signup_LoginPage signupLoginPage = new Signup_LoginPage();
    SoftAssertions softAssertions = new SoftAssertions();
    @Given("Launch browser")
    public void launch_browser() {
        Driver.get();
    }
    @Given("Navigate to url {string}")
    public void navigate_to_url(String url) {
        Driver.get().get(url);
    }
    @When("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        String actualButtonStyle = homePage.getHomeButton().getAttribute("style");
        String expectedButtonStyle = "color: orange;";
        softAssertions.assertThat(actualButtonStyle).isEqualTo(expectedButtonStyle);
        softAssertions.assertThat(homePage.getSlider().isDisplayed()).isTrue();
        softAssertions.assertAll();
    }
    @Given("Click on {string} button on header")
    public void click_on_button_on_header(String menuName) {
        homePage.navigateToMenu(menuName);
    }
    @When("Verify {string} is visible")
    public void verify_is_visible(String expectedText) {
        String actualText = signupLoginPage.getNewUserSignupText().getText();
        Assert.assertEquals(expectedText,actualText);

    }
    @When("Enter name and email address")
    public void enter_name_and_email_address() {
        signupLoginPage.fillOutSingUpForm();
    }
    @When("Click Signup button")
    public void click_button() {
        signupLoginPage.getSignUpButton().click();
    }
    @Then("Verify that {string} is visible")
    public void verify_that_is_visible(String expectedText) {

    }
    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {

    }
    @Then("Select checkbox {string}")
    public void select_checkbox(String string) {

    }
    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {

    }
    @Then("Click {string}")
    public void click(String string) {

    }

    @Then("Verify that {string} is visible and click {string} button")
    public void verify_that_is_visible_and_click_button(String string, String string2) {

    }
}
