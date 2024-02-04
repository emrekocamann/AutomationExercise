package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

@Getter
public class ShoppingCartPage extends BasePage{

    static Set<String> idOfProductsAddedToCart = new HashSet<>();
    @FindBy(xpath = "//li[text()='Shopping Cart']")
    private WebElement shoppingCartBreadcrumbText;
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private  WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> listOfProductsInTheCart;
    @FindBy(xpath = "//tbody/tr/td[@class='cart_description']/h4/a")
    private List<WebElement> listOfProductNamesInTheCart;
    @FindBy(xpath = "//tbody/tr/td[@class='cart_price']/p")
    private List<WebElement>  listOfProductPricesInTheCart;
    @FindBy(xpath = "//tbody/tr/td[@class='cart_quantity']/button")
    private List<WebElement>  listOfProductQuantitiesInTheCart;

    @FindBy(xpath = "//tbody/tr/td[@class='cart_total']/p")
    private List<WebElement> listOfProductTotalPricesInTheCart;


    public boolean verifyProductsAreAddedToCart(){
        return verifyProductId();
    }
    public boolean verifyProductId(){
        for (int i = 0; i < AddToCart.listOfProductsAddedToCart.size() ; i++) {
            idOfProductsAddedToCart.remove((AddToCart.listOfProductsAddedToCart.get(i).get("id")));
        }
        return idOfProductsAddedToCart.isEmpty();
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
    public boolean verifyProductTotalPrices(){
        for (int i = 0; i < listOfProductQuantitiesInTheCart.size(); i++) {
          int quantity=  Integer.parseInt(listOfProductQuantitiesInTheCart.get(i).getText());
          int price = Integer.parseInt(listOfProductPricesInTheCart.get(i).getText().substring(4));
          String totalPrice ="Rs. "+ quantity*price;
            if (!listOfProductTotalPricesInTheCart.get(i).getText().equals(totalPrice))
                return false;
        }
        return true;
    }
}
