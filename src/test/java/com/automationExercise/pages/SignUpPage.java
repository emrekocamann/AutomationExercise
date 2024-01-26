package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class SignUpPage extends BasePage{
    LoginPage loginPage = new LoginPage();

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement enterAccountInfoText;
    @FindBy(id = "id_gender1")
    private WebElement titleMrRadioButton;
    @FindBy(id = "id_gender2")
    private WebElement titleMrsRadioButton;
    @FindBy(id = "name")
    private WebElement nameInputBox;
    @FindBy(id = "email")
    private WebElement emailInputBox;
    @FindBy(id = "password")
    private WebElement passwordInputBox;
    @FindBy(id = "days")
    private WebElement dayDropDownMenu;
    @FindBy(id = "months")
    private WebElement monthDropDownMenu;
    @FindBy(id = "years")
    private WebElement yearDropDownMenu;
    @FindBy(xpath = "//*[text()='Sign up for our newsletter!']")
    private WebElement signUpNewsletterCheckBox;
    @FindBy(xpath = "//*[text()='Receive special offers from our partners!']")
    private WebElement receiveOfferCheckBox;
    @FindBy(id = "first_name")
    private WebElement firstNameInputBox;
    @FindBy(id = "last_name")
    private WebElement lastNameInputBox;
    @FindBy(id = "company")
    private WebElement companyInputBox;
    @FindBy(id = "address1")
    private WebElement addressInputBox;
    @FindBy(id = "address2")
    private WebElement address2InputBox;
    @FindBy(id = "country")
    private WebElement countryDropDownMenu;
    @FindBy(id = "state")
    private WebElement stateInputBox;
    @FindBy(id = "city")
    private WebElement cityInputBox;
    @FindBy(id = "zipcode")
    private WebElement zipcodeInputBox;
    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInputBox;
    @FindBy(xpath = "//button[text()='Create Account']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountCreatedText;
    @FindBy(xpath ="//*[text()='Continue']")
    private WebElement continueButtonOnAccountCreatedPage;
    @FindBy(xpath = "//*[text()='Account Deleted!']")
    private WebElement accountDeletedText;


    public void fillAccountInfoForm(){
        titleMrRadioButton.click();
        if (!verifyNameAndEmail()){
            nameInputBox.sendKeys(LoginPage.newUserName);
            emailInputBox.sendKeys(LoginPage.newUserEmail);
        }
        String password = createPasswordWithFaker();
        passwordInputBox.sendKeys(password);

        BrowserUtils.scrollToElement(passwordInputBox);
        Select select = new Select(dayDropDownMenu);
        select.selectByIndex(15);
        select = new Select(monthDropDownMenu);
        select.selectByVisibleText("December");
        select = new Select(yearDropDownMenu);
        select.selectByValue("2013");
    }
    public void fillAddressInfo() {
        firstNameInputBox.sendKeys(LoginPage.newUserName);
        lastNameInputBox.sendKeys(faker.name().lastName());
        companyInputBox.sendKeys(faker.company().name());
        BrowserUtils.scrollToElement(companyInputBox);
        addressInputBox.sendKeys(faker.address().fullAddress());
        address2InputBox.sendKeys(faker.address().fullAddress());
        Select select = new Select(countryDropDownMenu);
        select.selectByVisibleText("United States");
        stateInputBox.sendKeys(faker.address().state());
        cityInputBox.sendKeys(faker.address().cityName());
        BrowserUtils.scrollToElement(cityInputBox);
        zipcodeInputBox.sendKeys(faker.address().zipCode());
        mobileNumberInputBox.sendKeys(faker.phoneNumber().cellPhone());

    }

    private String createPasswordWithFaker() {
        return faker.internet().password(6,12,true,false,true);
    }
    private boolean verifyNameAndEmail(){
        String nameValue = nameInputBox.getAttribute("value");
        String emailValue = emailInputBox.getAttribute("value");
        return  LoginPage.newUserName.equals(nameValue)&&LoginPage.newUserEmail.equals(emailValue);
    }

    public void selectCheckBoxWithText(String checkboxText){
        Driver.get().findElement(By.xpath("//*[text()='"+checkboxText+"']")).click();
    }
}

