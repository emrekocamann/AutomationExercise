package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import com.github.javafaker.Faker;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    protected static Map<String, String> newUserData = new HashMap<>();

    Faker faker = new Faker();
//    public static final String newUserName;
//    public static final String newUserLastName;
//    public static  final String newUserEmail;
//    public static final String companyName;
//    public static final String address1;
//    public static final String address2;
//    public static final String country;
//    public static final String state;
//    public static final String cityName;
//    public static final String zipCode;
//    public static final String phoneNumber;
    public static int currentProductNum;
//    public static Map<String,String> createNewUserDataWithFaker(){
//        Faker faker = new Faker();
//        String newUserName= faker.name().firstName();
//        String newUserEmail=newUserName.toLowerCase()+faker.internet().emailAddress();
//        String newUserLastName=faker.name().lastName();
//        String companyName = faker.company().name();
//        String address1=faker.address().fullAddress();
//        String address2=faker.address().fullAddress();
//        String country="United States";
//        String state=faker.address().state();
//        String cityName=faker.address().cityName();
//        String zipCode=faker.address().zipCode();
//        String phoneNumber=faker.phoneNumber().cellPhone();
//        Map<String,String> userInfo= new HashMap<>();
//        userInfo.put("firstName",newUserName);
//        userInfo.put("lastName",newUserLastName);
//        userInfo.put("email",newUserEmail);
//        userInfo.put("company",companyName);
//        userInfo.put("address1",address1);
//        userInfo.put("address2",address2);
//        userInfo.put("country",country);
//        userInfo.put("state",state);
//        userInfo.put("city",cityName);
//        userInfo.put("zipCode",zipCode);
//        userInfo.put("phoneNumber",phoneNumber);
//
//        return userInfo;
//    }

    static {
    //    Faker faker = new Faker();
  //      newUserName = faker.name().firstName();
   //     newUserEmail = newUserName.toLowerCase()+faker.internet().emailAddress();
 //       newUserLastName = faker.name().lastName();
//        companyName = faker.company().name();
//        address1=faker.address().fullAddress();
//        address2=faker.address().fullAddress();
//        country="United States";
//        state=faker.address().state();
//        cityName=faker.address().cityName();
//        zipCode=faker.address().zipCode();
//        phoneNumber=faker.phoneNumber().cellPhone();
        Faker faker = new Faker();
        String newUserName= faker.name().firstName();
        String newUserEmail=newUserName.toLowerCase()+faker.internet().emailAddress();
        String newUserLastName=faker.name().lastName();
        String companyName = faker.company().name();
        String address1=faker.address().fullAddress();
        String address2=faker.address().fullAddress();
        String country="United States";
        String state=faker.address().state();
        String cityName=faker.address().cityName();
        String zipCode=faker.address().zipCode();
        String phoneNumber=faker.phoneNumber().cellPhone();

        newUserData.put("firstName",newUserName);
        newUserData.put("lastName",newUserLastName);
        newUserData.put("email",newUserEmail);
        newUserData.put("company",companyName);
        newUserData.put("address1",address1);
        newUserData.put("address2",address2);
        newUserData.put("country",country);
        newUserData.put("state",state);
        newUserData.put("city",cityName);
        newUserData.put("zipCode",zipCode);
        newUserData.put("phoneNumber",phoneNumber);
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
    @FindBy(css = "div.modal-content")
    protected WebElement addedPopUp;

    public void navigateToMenu(String menuName){
        String locator= "//div[@class='col-sm-8']//a[contains(.,'"+menuName+"')]";
        WebElement menu= Driver.get().findElement(By.xpath(locator));
        BrowserUtils.clickWithJS(menu);
    }
    public boolean verifyThatLoggedInAsUsernameIsVisible(){
         return Driver.get().findElement(
                 By.xpath("//div[@class='col-sm-8']//li//*[.=' Logged in as "
                          +newUserData.get("firstName")+"']"))
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
