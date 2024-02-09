package com.automationExercise.steps_defs;

import com.automationExercise.pages.HomePage;
import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    @When("Click on arrow at bottom right side to move upward")
    public void click_on_arrow_at_bottom_right_side_to_move_upward() {
        homePage.getScrollUpButton().click();
    }
    @Then("Verify that page is scrolled up and {string} text is visible on screen")
    public void verify_that_page_is_scrolled_up_and_text_is_visible_on_screen(String expectedText) {
        List<WebElement> elements = Driver.get().findElements(By.xpath("//h2[text()='" + expectedText + "']"));
        elements.forEach(element -> Assert.assertTrue(BrowserUtils.waitForVisibility(element).isDisplayed()));
    }

    @And("Scroll up page to top")
    public void scrollUpPageToTop() {
        BrowserUtils.scrollToElement(homePage.getSlider());
    }
}
