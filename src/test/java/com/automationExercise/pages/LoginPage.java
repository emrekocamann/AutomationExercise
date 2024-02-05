package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

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
    @FindBy(css = "div.login-form p")
    private WebElement loginErrorMessage;
    @FindBy(css = "div.signup-form p")
    private WebElement signupErrorMessage;

    public void fillOutSingUpForm(){
        createNewUserWithFaker();
        nameInputBox.sendKeys(newUserData.get("firstName"));
        emailInputBoxOnSignUpForm.sendKeys(newUserData.get("email"));
    }
    public void fillOutSingUpForm(String email){
        createNewUserWithFaker();
        nameInputBox.sendKeys(newUserData.get("firstName"));
        emailInputBoxOnSignUpForm.sendKeys(email);
    }
    public void fillOutLoginForm(String email,String password){
        emailInputBoxOnLoginForm.sendKeys(email);
        passwordInputBoxOnLoginForm.sendKeys(password);
        createDataWithActualUser(email,password);
    }
    public boolean verifyThatUserIsNavigatedToLoginPage() {
        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = Driver.get().getCurrentUrl();
        return expectedUrl.equals(actualUrl) && loginToYourAccountText.isDisplayed() && newUserSignupText.isDisplayed();
    }

}
