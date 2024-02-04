package com.automationExercise.steps_defs;

import com.automationExercise.pages.BasePage;
import com.automationExercise.pages.HomePage;
import com.automationExercise.pages.LoginPage;
import com.automationExercise.pages.SignUpPage;
import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;


public class RegisterStep_Defs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();
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
    @When("Verify {string} is visible on the signup form")
    public void verify_is_visible(String expectedText) {
        String actualText = loginPage.getNewUserSignupText().getText();
        Assert.assertEquals(expectedText,actualText);

    }
    @When("Enter name and email address")
    public void enter_name_and_email_address() {
        loginPage.fillOutSingUpForm();
    }
    @When("Click Signup button")
    public void click_signup_button() {
        loginPage.getSignUpButton().click();
    }
    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verify_that_enter_account_information_is_visible() {
       String expectedText = "ENTER ACCOUNT INFORMATION";
        String actualText = signUpPage.getEnterAccountInfoText().getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        signUpPage.fillAccountInfoForm();
    }
    @Then("Select checkbox {string}")
    public void select_checkbox(String checkBoxText) {
        signUpPage.selectCheckBoxWithText(checkBoxText);
    }
    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number(){
        signUpPage.fillAddressInfo();
    }
    @Then("Click Create Account button")
    public void click() {
        signUpPage.getCreateAccountButton().click();
    }
    @Then("Verify that ACCOUNT CREATED! is visible")
    public void verify_that_account_created_is_visible() {
        String expectedText = "ACCOUNT CREATED!";
        String actualText = signUpPage.getAccountCreatedText().getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Then("Click Continue button")
    public void click_continue_button() {
        signUpPage.getContinueButtonOnAccountCreatedPage().click();
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        Assert.assertTrue(loginPage.verifyThatLoggedInAsUsernameIsVisible());
    }
    @Then("Verify that {string} is visible and click Continue button")
    public void verify_that_is_visible_and_click_button(String expectedText) {
        String actualText = signUpPage.getAccountDeletedText().getText();
        Assert.assertEquals(expectedText,actualText);
        click_continue_button();
        signUpPage.deleteUserData();
    }


    @Given("Enter name and already {string} address")
    public void enterNameAndAlreadyAddress(String email) {
        loginPage.fillOutSingUpForm(email);
    }

    @Then("Verify error {string} is visible on signup form")
    public void verifyErrorEmailAddressAlreadyExistIsVisibleOnSignupForm(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getSignupErrorMessage().getText();
        Assert.assertTrue(loginPage.getSignupErrorMessage().isDisplayed());
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }
    @When("Fill all details in Signup and create account")
    public void fill_all_details_in_signup_and_create_account() {
        loginPage.fillOutSingUpForm();
        loginPage.getSignUpButton().click();
        signUpPage.fillFullForm();
    }
}
