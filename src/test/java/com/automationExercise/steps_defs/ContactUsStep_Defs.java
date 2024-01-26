package com.automationExercise.steps_defs;

import com.automationExercise.pages.ContactUsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ContactUsStep_Defs {
    ContactUsPage contactUsPage = new ContactUsPage();
    @When("Verify GET IN TOUCH is visible")
    public void verify_get_in_touch_is_visible() {
        Assert.assertTrue(contactUsPage.getGetInTouchTExt().isDisplayed());
    }
    @When("Enter name, email, subject and message")
    public void enter_name_email_subject_and_message() {
        contactUsPage.fillOutContactUsForm();
    }
    @When("Upload file")
    public void upload_file() {
        contactUsPage.uploadFile();
    }
    @When("Click Submit button")
    public void click_submit_button() {
        contactUsPage.getSubmitButton().click();
    }
    @When("Click OK button")
    public void click_ok_button() {
       contactUsPage.acceptAlert();
    }
    @Then("Verify success message {string} is visible")
    public void verify_success_message_is_visible(String expectedSuccessMessage) {
        String actualSuccessMessage = contactUsPage.getSuccessMessage().getText();
        Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);
    }
    @Then("Click Home button")
    public void click_button_and_verify_that_landed_to_home_page_successfully() {
        contactUsPage.getHomeButton().click();
    }

}
