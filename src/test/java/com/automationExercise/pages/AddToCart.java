package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AddToCart {
     List<Map<String,String>> listOfProductsAddedToCart = new ArrayList<>();

     /**
      * To verify the products added to the cart, each product's information is added to the listOfProductsAddedToCart
      * when adding it to the cart.
      */
     default void addProductToCart(String id, String name, String price, int quantity) {
          Map<String,String> product= new HashMap<>();
          product.put("id",id);
          product.put("name",name);
          product.put("price",price);
          product.put("quantity",String.valueOf(quantity));
          for (Map<String, String> map : listOfProductsAddedToCart) {
               if (map.get("id").contains(product.get("id"))) {
                    quantity = Integer.parseInt(map.get("quantity")) +quantity;
                    map.put("quantity", String.valueOf(quantity));
                    return;
               }
          }
          listOfProductsAddedToCart.add(product);
     }
     /**
      * When a product is removed from the cart, it is also used to remove it from the listOfProductsAddedToCart list
      */
     default void removeProductToCart(String productId){
          for (Map<String, String> products : listOfProductsAddedToCart) {
               if (products.get("id").equals(productId)){
                    products.remove("id");
               }
          }
     }
     /**
      * After clicking the add to cart button, you can choose which button to click in the popup that appears.
      * @param choice Accepts "View Cart" or "Continue Shopping"
      * */
     default void clickViewCartOrContinueShopping(String choice){
          WebElement element = Driver.get().findElement(By.xpath("//div[@class='modal-content']//*[text()='" + choice + "']"));
          BrowserUtils.waitForVisibility(element);
          BrowserUtils.clickWithJS(element);
     }
}
