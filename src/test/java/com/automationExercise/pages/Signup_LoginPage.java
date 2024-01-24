package com.automationExercise.pages;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class Signup_LoginPage extends BasePage {
    Faker faker = new Faker();

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement newUserSignupText;

    @FindBy(css = "[data-qa='signup-name']")
    private WebElement nameInputBox;
    @FindBy(css = "[data-qa='signup-email']")
    private WebElement emailInputBoxOnSignUpForm;

    @FindBy(css = "[data-qa='signup-button']")
    private WebElement signUpButton;

    public void fillOutSingUpForm(){
        nameInputBox.sendKeys(createFakeUserName());
        emailInputBoxOnSignUpForm.sendKeys(createFakeEmail());
    }

    private String createFakeUserName(){

        return faker.name().firstName();
    }
    private String createFakeEmail(){
        return faker.internet().emailAddress();
    }

}
