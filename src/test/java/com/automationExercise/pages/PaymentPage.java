package com.automationExercise.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class PaymentPage extends BasePage{

    @FindBy(name = "name_on_card")
    private WebElement nameOnCartInputBox;
    @FindBy(name = "card_number")
    private WebElement cardNumberInputBox;
    @FindBy(name = "cvc")
    private WebElement cvcInputBox;
    @FindBy(name = "expiry_month")
    private WebElement expiryMonthInputBox;
    @FindBy(name = "expiry_year")
    private WebElement expiryYearInputBox;
    @FindBy(id = "submit")
    private WebElement payAndConfirmOrderButton;
    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    private WebElement successMessage;


    public void fillOutPaymentInfo() {
        String name = newUserData.get("firstName")+" "+newUserData.get("lastName");
        String cardNumber = faker.business().creditCardNumber();
        nameOnCartInputBox.sendKeys(name);
        cardNumberInputBox.sendKeys(cardNumber);
        String cvc = String.valueOf(faker.random().nextInt(100,999));
        cvcInputBox.sendKeys(cvc);
        String month= String.valueOf(faker.random().nextInt(1,12));
        expiryMonthInputBox.sendKeys(month);
        String year = String.valueOf(faker.random().nextInt(2024,2050));
        expiryYearInputBox.sendKeys(year);
    }
}
