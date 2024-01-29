package com.automationExercise.steps_defs;

import com.automationExercise.pages.HomePage;
import com.automationExercise.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SubscribedStep_Defs {
    HomePage homePage= new HomePage();
    @When("Scroll down to footer")
    public void scroll_down_to_footer() {
        BrowserUtils.scrollToElement(homePage.getFooterBottom());
    }
    @When("Verify text SUBSCRIPTION")
    public void verify_text_subscription() {
        Assert.assertTrue(homePage.getSubscriptionTextOnFooter().isDisplayed());
    }
    @When("Enter email address in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button() {
        homePage.subscribe();
    }
    @Then("Verify success message {string} is visible on footer")
    public void verify_success_message_is_visible_on_footer(String expectedMessage) {
        String actualMessage= homePage.getSubscribedSuccessMessage().getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        Assert.assertTrue(homePage.getSubscribedSuccessMessage().isDisplayed());
    }
}
