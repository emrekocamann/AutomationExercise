package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductDetailsPage extends BasePage implements AddToCart {

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


    public void clickAddToCartButtonAndAddProductToCart(){
        String price = productPrice.getText();
        String currentUrl = Driver.get().getCurrentUrl();
        String id = currentUrl.substring(currentUrl.lastIndexOf("/")+1);
        String name = productName.getText();
        int quantity = Integer.parseInt(quantityInputBox.getAttribute("value"));
        addProductToCart(id,name,price,quantity);

        addToCartButton.click();
    }

    public void increaseQuantityTo(int quantity) {
        quantityInputBox.clear();
        quantityInputBox.sendKeys(String.valueOf(quantity));
    }


}
