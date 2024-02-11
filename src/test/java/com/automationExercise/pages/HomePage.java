package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class HomePage extends BasePage implements AddToCart {
    @FindBy(id = "slider")
    private WebElement slider;
    @FindBy(css = "div.features_items div.col-sm-4 div.choose")
    private List<WebElement> viewProductsButtons;
    @FindBy(css = "div.features_items div.col-sm-4")
    private List<WebElement> productsList;
    @FindBy(css = "div.productinfo.text-center p")
    private List<WebElement> productNames;
    @FindBy(css = "div.productinfo.text-center h2")
    private List<WebElement> productPrices;
    @FindBy(xpath = "//div[@class='product-overlay']//a[text()='Add to cart']")
    private List<WebElement> addToCartButtonsOnOverlay;
    @FindBy(css = ".recommended_items > h2")
    private WebElement recommendedItemsText;
    @FindBy(css = "div#recommended-item-carousel p")
    private List <WebElement> recommendedItemsNames;
    @FindBy(css = "div#recommended-item-carousel h2")
    private List <WebElement> recommendedItemsPrices;
    @FindBy(xpath = "//div[@id='recommended-item-carousel']//a[text()='Add to cart']")
    private List <WebElement> addToCartButtonsOnRecommendedItems;
    @FindBy(id = "scrollUp")
    private WebElement scrollUpButton;

    public void clickViewProductWithName(String productName){
        WebElement addToCartButton = Driver.get().findElement(By.xpath("" +
                "((//p[text()='" + productName + "'])[1]/ancestor::div[@class='product-image-wrapper']//a)[2]"));
        currentProductId =Integer.parseInt(addToCartButton.getAttribute("data-product-id"));
        BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath(
                      "(//p[text()='"+productName+"'])[1]/" +
                              "ancestor::div[@class='product-image-wrapper']//*[text()='View Product']")));
    }
    public void hoverAndClickAddToCartWithRowNumber(int rowNumber){
        int index= rowNumber-1;
        BrowserUtils.hover(productsList.get(index));
        BrowserUtils.clickWithJS( addToCartButtonsOnOverlay.get(index));
        BrowserUtils.waitFor(1);

        String name = productNames.get(index).getText();
        String price = productPrices.get(index).getText();
        int quantity=1;
        String id = addToCartButtonsOnOverlay.get(index).getAttribute("data-product-id");
        addProductToCart("product-"+id,name,price,quantity);
    }
    public void clickAddToCartOnRecommendedItemsWithRowNumber(int rowNumber){
        int index= rowNumber-1;
        BrowserUtils.clickWithJS(addToCartButtonsOnRecommendedItems.get(index));
        String name = recommendedItemsNames.get(index).getText();
        String price = recommendedItemsPrices.get(index).getText();
        String id = addToCartButtonsOnRecommendedItems.get(index).getAttribute("data-product-id");
        addProductToCart("product-"+id,name,price,1);
    }
}
