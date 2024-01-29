package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import com.github.javafaker.Faker;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    Faker faker = new Faker();
    public static final String newUserName;
    public static  final String newUserEmail;
    static {
        Faker faker = new Faker();
        newUserName = faker.name().firstName();
        newUserEmail = newUserName.toLowerCase()+faker.internet().emailAddress();
    }
    @FindBy(xpath = "//div[@class='col-sm-8']//li//*[contains(.,'Home')]")
    protected WebElement homeButton;
    @FindBy(xpath = "//h2[text()='Subscription']")
    protected WebElement subscriptionTextOnFooter;
    @FindBy(id = "susbscribe_email")
    protected WebElement subscribe_emailInputBox;
    @FindBy(id = "subscribe")
    protected WebElement subscribeArrowButton;
    @FindBy(css = "div.footer-bottom")
    protected WebElement footerBottom;
    @FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
    protected WebElement subscribedSuccessMessage;

    public void navigateToMenu(String menuName){
        String locator= "//div[@class='col-sm-8']//a[contains(.,'"+menuName+"')]";
        WebElement menu= Driver.get().findElement(By.xpath(locator));
        BrowserUtils.clickWithJS(menu);
    }
    public boolean verifyThatLoggedInAsUsernameIsVisible(){
         return Driver.get().findElement(
                 By.xpath("//div[@class='col-sm-8']//li//*[.=' Logged in as "
                          +LoginPage.newUserName+"']"))
                 .isDisplayed();
    }
    public boolean verifyThatLoggedInAsUsernameIsVisible(String userName){
        return Driver.get().findElement(
                        By.xpath("//div[@class='col-sm-8']//li//*[.=' Logged in as "
                                +userName+"']"))
                .isDisplayed();
    }
    public void subscribe(){
        subscribe_emailInputBox.sendKeys(faker.internet().emailAddress());
        subscribeArrowButton.click();
    }
}
