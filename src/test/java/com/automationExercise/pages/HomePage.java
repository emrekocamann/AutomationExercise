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

    public void clickViewProductsWithProductsIndex(int index){
        BrowserUtils.scrollToElement(viewProductsButtons.get(index));
        viewProductsButtons.get(index).click();
        currentProductId = index+1;
    }
    public void clickViewProductWithName(String productName){
        WebElement addToCartButton = Driver.get().findElement(By.xpath("" +
                "((//p[text()='" + productName + "'])[1]/ancestor::div[@class='product-image-wrapper']//a)[2]"));

        currentProductId =Integer.parseInt(addToCartButton.getAttribute("data-product-id"));
        Driver.get().findElement(By.xpath(
                "(//p[text()='"+productName+"'])[1]/ancestor::div[@class='product-image-wrapper']//*[text()='View Product']"))
                .click();
    }
    public void hoverAndClickAddToCartWithRowNumber(int rowNumber){
        int index= rowNumber-1;
        BrowserUtils.hover(productsList.get(index));
        BrowserUtils.clickWithJS( addToCartButtonsOnOverlay.get(index));
        BrowserUtils.waitFor(1);

        String name = productNames.get(index).getText();
        String price = productPrices.get(index).getText();
        int quantity=1;
        addProductToCart("product-"+rowNumber,name,price,quantity);
    }
}
