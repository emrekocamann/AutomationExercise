package com.automationExercise.pages;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    public static final String newUserName;
    public static  final String newUserEmail;
    static {
        Faker faker = new Faker();
        newUserName = faker.name().firstName();
        newUserEmail = faker.internet().emailAddress();
    }


    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement newUserSignupText;

    @FindBy(css = "[data-qa='signup-name']")
    private WebElement nameInputBox;
    @FindBy(css = "[data-qa='signup-email']")
    private WebElement emailInputBoxOnSignUpForm;

    @FindBy(css = "[data-qa='signup-button']")
    private WebElement signUpButton;

    public void fillOutSingUpForm(){
        nameInputBox.sendKeys(newUserName);
        emailInputBoxOnSignUpForm.sendKeys(newUserEmail);
    }

}
