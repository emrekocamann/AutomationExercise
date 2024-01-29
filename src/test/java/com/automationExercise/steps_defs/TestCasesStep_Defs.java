package com.automationExercise.steps_defs;

import com.automationExercise.pages.TestCasesPage;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

public class TestCasesStep_Defs {
    TestCasesPage testCasesPage = new TestCasesPage();
    SoftAssertions softAssertions = new SoftAssertions();
    @Then("Verify user is navigated to test cases page successfully")
    public void verify_user_is_navigated_to_test_cases_page_successfully() {
        String actualButtonStyle = testCasesPage.getTestCasesButton().getAttribute("style");
        String expectedButtonStyle = "color: orange;";
        softAssertions.assertThat(actualButtonStyle).isEqualTo(expectedButtonStyle);
        softAssertions.assertThat(testCasesPage.getTestCasesText().isDisplayed()).isTrue();
        softAssertions.assertThat(testCasesPage.getAllTestCases().size()==testCasesPage.getNumOfTestCases()).isTrue();
        softAssertions.assertAll();
    }
}
