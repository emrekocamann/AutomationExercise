package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@Getter
public class CheckoutPage extends BasePage{
    @FindBy(css = "ul#address_delivery li")
    private List<WebElement> addressDetails;
    @FindBy(css = "ul#address_invoice li")
    private List<WebElement> billingAddressDetails;
    @FindBy(xpath = "//tbody/tr/td[@class='cart_description']/h4/a")
    private List<WebElement> listOfProductNamesInTheCart;
    @FindBy(xpath = "//tbody/tr/td[@class='cart_price']/p")
    private List<WebElement>  listOfProductPricesInTheCart;
    @FindBy(xpath = "//tbody/tr/td[@class='cart_quantity']/button")
    private List<WebElement>  listOfProductQuantitiesInTheCart;
    @FindBy(xpath = "//tbody/tr/td[@class='cart_total']/p")
    private List<WebElement> listOfProductTotalPricesInTheCart;
    @FindBy(xpath = "//b[text()='Total Amount']/../../following-sibling::td/p")
    private WebElement totalAmount;

    @FindBy(name = "message")
    private WebElement  commentTextArea;
    @FindBy(xpath = "//a[text()='Place Order']")
    private WebElement placeOrderButton;

    public void typeCommentInTextArea(){
        commentTextArea.sendKeys(faker.lorem().sentence());
    }

    public boolean verifyAddressDetails(){
       String expectedFullNane= "Mr. "+ newUserData.get("firstName")+" "+newUserData.get("lastName");
       String expectedCompany= newUserData.get("company");
       String expectedAddress1 =newUserData.get("address1");
       String expectedAddress2 =newUserData.get("address2");
       String expectedCityStatePostCode =newUserData.get("city")+" "+newUserData.get("state")+" "+newUserData.get("zipCode");
       String expectedCountry=newUserData.get("country");
       String expectedPhoneNumber=newUserData.get("phoneNumber");

        return expectedFullNane.equals(addressDetails.get(1).getText())
               && expectedCompany.equals(addressDetails.get(2).getText())
               && expectedAddress1.equals(addressDetails.get(3).getText())
               && expectedAddress2.equals(addressDetails.get(4).getText())
               && expectedCityStatePostCode.equals(addressDetails.get(5).getText())
               && expectedCountry.equals(addressDetails.get(6).getText())
               && expectedPhoneNumber.equals(addressDetails.get(7).getText());
    }
    public boolean verifyBillingAddressDetails(){
        String expectedFullNane= "Mr. "+ newUserData.get("firstName")+" "+newUserData.get("lastName");
        String expectedCompany= newUserData.get("company");
        String expectedAddress1 =newUserData.get("address1");
        String expectedAddress2 =newUserData.get("address2");
        String expectedCityStatePostCode =newUserData.get("city")+" "+newUserData.get("state")+" "+newUserData.get("zipCode");
        String expectedCountry=newUserData.get("country");
        String expectedPhoneNumber=newUserData.get("phoneNumber");

        return expectedFullNane.equals(billingAddressDetails.get(1).getText())
                && expectedCompany.equals(billingAddressDetails.get(2).getText())
                && expectedAddress1.equals(billingAddressDetails.get(3).getText())
                && expectedAddress2.equals(billingAddressDetails.get(4).getText())
                && expectedCityStatePostCode.equals(billingAddressDetails.get(5).getText())
                && expectedCountry.equals(billingAddressDetails.get(6).getText())
                && expectedPhoneNumber.equals(billingAddressDetails.get(7).getText());
    }
    public boolean reviewYourOrder(){
        BrowserUtils.scrollToElement(listOfProductNamesInTheCart.get(0));
       return verifyProductNamesOrPrices(listOfProductNamesInTheCart,"name")
               && verifyProductNamesOrPrices(listOfProductPricesInTheCart,"price")
               && verifyQuantity()
               && verifyTotalPrices();
    }

    public boolean verifyProductNamesOrPrices(List<WebElement> elements, String info){
        for (int i = 0; i < elements.size(); i++) {
           if (!AddToCart.listOfProductsAddedToCart.get(i).get(info).equals(BrowserUtils.getElementsText(elements).get(i)))
                return false;
        }
        return  true;
    }

    public boolean verifyQuantity(){
        for (int i = 0; i < AddToCart.listOfProductsAddedToCart.size(); i++) {
             if (!listOfProductQuantitiesInTheCart.get(i).getText().equals(AddToCart.listOfProductsAddedToCart.get(i).get("quantity")))
                return false;
        }
        return true;
    }
    public boolean verifyTotalPrices(){
        int price=0;
        String totalPrice ="Rs. "+ price;
        for (WebElement element : listOfProductTotalPricesInTheCart) {
            price += Integer.parseInt(element.getText().substring(4));
            totalPrice = "Rs. " + price;
        }
        return totalAmount.getText().equals(totalPrice);
    }
}
