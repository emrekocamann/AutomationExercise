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


    @FindBy(css = "div.signup-form>h2")
    private WebElement newUserSignupText;
    @FindBy(css = "div.login-form>h2")
    private WebElement loginToYourAccountText;
    @FindBy(css = "[data-qa='login-email']")
    private WebElement emailInputBoxOnLoginForm;
    @FindBy(css = "[data-qa='login-password']")
    private WebElement passwordInputBoxOnLoginForm;
    @FindBy(css = "[data-qa='signup-name']")
    private WebElement nameInputBox;
    @FindBy(css = "[data-qa='signup-email']")
    private WebElement emailInputBoxOnSignUpForm;

    @FindBy(css = "[data-qa='login-button']")
    private WebElement loginButton;
    @FindBy(css = "[data-qa='signup-button']")
    private WebElement signUpButton;

    public void fillOutSingUpForm(){
        nameInputBox.sendKeys(newUserName);
        emailInputBoxOnSignUpForm.sendKeys(newUserEmail);
        System.out.println(newUserEmail);
    }
    public void fillOutLoginForm(String email,String password){
        emailInputBoxOnLoginForm.sendKeys(email);
        passwordInputBoxOnLoginForm.sendKeys(password);
    }

}
