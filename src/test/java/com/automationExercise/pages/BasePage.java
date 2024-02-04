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
    protected static Map<String, String> newUserData = null;
    Faker faker = new Faker();
    public static int currentProductId;
//    static {
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
//
//        newUserData.put("firstName",newUserName);
//        newUserData.put("lastName",newUserLastName);
//        newUserData.put("email",newUserEmail);
//        newUserData.put("company",companyName);
//        newUserData.put("address1",address1);
//        newUserData.put("address2",address2);
//        newUserData.put("country",country);
//        newUserData.put("state",state);
//        newUserData.put("city",cityName);
//        newUserData.put("zipCode",zipCode);
//        newUserData.put("phoneNumber",phoneNumber);
//    }
    public void createNewUserWithFaker(){
            newUserData = new HashMap<>();
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
    public void createDataWithActualUser(String email,String password){
        if (email.equals("erin.green@hotmail.com")&&password.equals("12606")){
            newUserData = new HashMap<>();
            newUserData.put("firstName","Van");
            newUserData.put("lastName","Koch");
            newUserData.put("email","erin.green@hotmail.com");
            newUserData.put("company","Hammes-Collins");
            newUserData.put("address1","766 Shanelle Ridges, East Zacheryhaven, WI 66904-5322");
            newUserData.put("address2","Suite 528 3883 Bailey Highway, Wittingborough, WV 27882");
            newUserData.put("country","United States");
            newUserData.put("state","North Carolina");
            newUserData.put("city","Torphyberg");
            newUserData.put("zipCode","07221");
            newUserData.put("phoneNumber","362-177-4239");
        }
    }
    public void deleteUserData(){
        if (newUserData!=null){
            newUserData = null;
        }
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
