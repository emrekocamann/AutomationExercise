package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ProductsPage extends BasePage{

    private String searchedProduct;

    @FindBy(xpath = "//h2[text()='All Products']")
    private WebElement allProductsText;
    @FindBy(css = "div.features_items")
    private WebElement allProducts;
    @FindBy(css = "div.features_items div.col-sm-4")
    private List<WebElement> productsList;
    @FindBy(css = "div.features_items div.col-sm-4 div.choose")
    private List<WebElement> viewProductsButtons;
    @FindBy(xpath = "//div[@class='product-overlay']//a[text()='Add to cart']")
    private List<WebElement> addToCartButtonsOnOverlay;
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

    @FindBy(id = "search_product")
    private WebElement searchBox;
    @FindBy(id = "submit_search")
    private  WebElement searchButton;
    @FindBy(xpath = "//h2[text()='Searched Products']")
    private  WebElement searchedProductsText;
    @FindBy(xpath = "//div[@class='single-products']/div/p")
    private List<WebElement> searchedProductsNames;
    public void clickViewProductsWithProductsIndex(int index){
        BrowserUtils.scrollToElement(viewProductsButtons.get(index));
        viewProductsButtons.get(index).click();
        currentProductNum = index+1;
    }

    public void searchProducts(String productName) {
        searchedProduct= productName;
        searchBox.sendKeys(productName);
        searchButton.click();
    }
    public boolean verifyAllTheProductsRelatedToSearchAreVisible(){
          return searchedProductsNames.stream()
                        .anyMatch(element -> element.getText().toLowerCase().contains(searchedProduct));
    }
    public void hoverAndClickAddToCartWithRowNumber(int rowNumber){
        int index= rowNumber-1;
        WebElement product= productsList.get(index);
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(product).perform();
        addToCartButtonsOnOverlay.get(index).click();
        ShoppingCartPage.idOfProductsAddedToCart.add("product-"+rowNumber);
        BrowserUtils.waitFor(1);
    }
    public void clickViewCartOrContinueShopping(String choice){
        Driver.get().findElement(By.xpath("//div[@class='modal-content']//*[text()='"+choice+"']")).click();
    }
}
