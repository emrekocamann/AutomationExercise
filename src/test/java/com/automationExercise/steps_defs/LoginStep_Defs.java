package com.automationExercise.steps_defs;

import com.automationExercise.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStep_Defs {
    LoginPage loginPage = new LoginPage();
    @Given("Verify {string} is visible on the login form")
    public void verify_is_visible_on_the_login_form(String expectedText) {
        String actualText = loginPage.getLoginToYourAccountText().getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @When("Enter correct {string} address and {string}")
    public void enter_correct_email_address_and_password(String email,String password) {
        loginPage.fillOutLoginForm(email,password);
    }
    @When("Click Login button on Login page")
    public void click_button() {
        loginPage.getLoginButton().click();
    }
    @When("Verify that Logged in as {string} is visible")
    public void verifyThatLoggedInAsIsVisible(String userName) {
        loginPage.verifyThatLoggedInAsUsernameIsVisible(userName);
    }
    @Then("Verify that {string} is visible")
    public void verify_that_is_visible(String string) {

    }



}
