package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.*;

@Getter
public class ShoppingCartPage extends BasePage implements AddToCart{

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
    @FindBy(xpath = "//tbody/tr/td[@class='cart_delete']/a")
    private List<WebElement> xButtons;


    public boolean verifyProductsAreAddedToCart(){
        return verifyProductId();
    }
    /**Verifies the IDs of the products added to the cart*/
    public boolean verifyProductId(){
        loop1:
        for (WebElement element : listOfProductsInTheCart) {
            String id1 = element.getAttribute("id");
            for (Map<String, String> map : listOfProductsAddedToCart) {
                String id2 = map.get("id");
                if (id1.equals(id2)) {
                    continue loop1;
                }
            }
            return false;
        }
       return true;
    }

    /**Verifies the names and prices of products added to the cart
     * @param elements product in cart
     * @param info "name" or "price"
     * */
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
    public void removeProductFromCartWithProductId(String productId){
        Driver.get().findElement(By.xpath("//tbody/tr[@id='"+productId+"']/td[@class='cart_delete']/a")).click();
        removeProductToCart(productId);
    }
    /**removes the product from the cart and listOfProductsAddedToCart with productId*/
    public boolean verifyRemoveFromCart(String productId){
        return  listOfProductsInTheCart.stream().anyMatch(
                element -> !element.getAttribute("id").contains(productId));
    }
    public boolean verifyAllInfoInCart(){
        return verifyProductNamesOrPrices(getListOfProductNamesInTheCart(), "name")
                && verifyProductNamesOrPrices(getListOfProductPricesInTheCart(), "price")
                && verifyProductId()
                &&verifyQuantity()
                &&verifyProductTotalPrices();
    }
}
