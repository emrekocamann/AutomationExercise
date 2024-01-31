package com.automationExercise.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.Map;
import static com.automationExercise.pages.ProductsPage.products;

@Getter
public class ProductDetailsPage extends BasePage{

    @FindBy(css = "div.product-information h2")
    private WebElement productName;
    @FindBy(xpath = "//div[@class='product-information']/p[contains(text(),'Category')]")
    private WebElement productCategory;
    @FindBy(css = "div.product-information>span>span")
    private WebElement productPrice;
    @FindBy(xpath = "//div[@class='product-information']/p[contains(.,'Availability')]")
    private WebElement productAvailability;
    @FindBy(xpath = "//div[@class='product-information']/p[contains(.,'Condition')]")
    private  WebElement productCondition;
    @FindBy(xpath = "//div[@class='product-information']/p[contains(.,'Brand')]")
    private  WebElement productBrand;
    @FindBy(id = "quantity")
    private WebElement quantityInputBox;
    @FindBy(css = "button[type='button']")
    private WebElement addToCartButton;

    public void addProductToProductsList(String id,String name,String price,String quantity){
        Map<String,String> info= new HashMap<>();
        info.put("id",id);
        info.put("name",name);
        info.put("price",price);
        info.put("quantity",quantity);
        for (Map<String, String> map : products) {
            if (map.get("id").contains(info.get("id"))) {
                quantity = String.valueOf(Integer.parseInt(map.get("quantity")) + Integer.parseInt(quantity));
                map.put("quantity", quantity);
                return;
            }
        }
        products.add(info);
    }

}
