package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ProductsPage extends BasePage implements AddToCart {
    private String searchedProduct;
    @FindBy(xpath = "//h2[text()='All Products']")
    private WebElement allProductsText;
    @FindBy(css = "h2.title.text-center")
    private WebElement pageTitle;
    @FindBy(css = "div.features_items")
    private WebElement allProducts;
    @FindBy(css = "div.features_items div.col-sm-4")
    private List<WebElement> productsList;
    @FindBy(css = "div.features_items div.col-sm-4 div.choose")
    private List<WebElement> viewProductsButtons;
    @FindBy(xpath = "//div[@class='product-overlay']//a[text()='Add to cart']")
    private List<WebElement> addToCartButtonsOnOverlay;


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
        currentProductId = index+1;
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

    @FindBy(css = "div.productinfo.text-center p")
    private List<WebElement> productNames;
    @FindBy(css = "div.productinfo.text-center h2")
    private List<WebElement> productPrices;
    public void hoverAndClickAddToCartWithRowNumber(int rowNumber){
        int index= rowNumber-1;
        BrowserUtils.hover(productsList.get(index));
        BrowserUtils.clickWithJS( addToCartButtonsOnOverlay.get(index));
       // ShoppingCartPage.idOfProductsAddedToCart.add("product-"+rowNumber);
        BrowserUtils.waitFor(1);

        String name = productNames.get(index).getText();
        String price = productPrices.get(index).getText();
        int quantity=1;
        addProductToCart("product-"+rowNumber,name,price,quantity);
    }

    public boolean verifyPageTitle(String expectedTitle){
        return pageTitle.getText().equalsIgnoreCase(expectedTitle);
    }


}
