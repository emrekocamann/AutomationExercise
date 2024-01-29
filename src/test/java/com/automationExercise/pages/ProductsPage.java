package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ProductsPage extends BasePage{
    private int currentProductNum;
    @FindBy(xpath = "//h2[text()='All Products']")
    private WebElement allProductsText;
    @FindBy(css = "div.features_items")
    private WebElement allProducts;
    @FindBy(css = "div.features_items div.col-sm-4")
    private List<WebElement> productsList;
    @FindBy(css = "div.features_items div.col-sm-4 div.choose")
    private List<WebElement> viewProductsButtons;
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
    public void clickViewProductsWithProductsIndex(int index){
        BrowserUtils.scrollDown(300);
        viewProductsButtons.get(index).click();
        currentProductNum = index+1;
    }
}
