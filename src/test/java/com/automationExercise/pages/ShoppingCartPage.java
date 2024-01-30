package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class ShoppingCartPage extends BasePage{

    static Set<String> idOfProductsAddedToCart = new HashSet<>();
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> listOfProductsInTheCart;

    public boolean verifyProductsAreAddedToCart(){
        System.out.println("idOfProductsAddedToCart = " + idOfProductsAddedToCart);
        boolean result = false;
        for (WebElement element : listOfProductsInTheCart) {
            String productId = element.getAttribute("id");
            System.out.println("productId = " + productId);
            result= idOfProductsAddedToCart.contains(productId);
           if (!result)
               return false;
        }
        return result;


//        for (int i = 0; i < listOfProductsInTheCart.size(); i++) {
//         String productId = listOfProductsInTheCart.get(i).getAttribute("id");
//            for (int j = 0; j < idOfProductsAddedToCart.size(); j++) {
//               if (productId.equals("product-"+idOfProductsAddedToCart.get(j))) {
//                   break;
//               }
//            }
//        }
//        return false;

    }
}
