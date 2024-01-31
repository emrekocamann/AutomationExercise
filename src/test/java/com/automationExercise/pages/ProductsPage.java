package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    static List<Map<String,String>> products= new ArrayList<>();
    @FindBy(css = "div.productinfo.text-center p")
    private List<WebElement> productNames;
    @FindBy(css = "div.productinfo.text-center h2")
    private List<WebElement> productPrices;
    public void hoverAndClickAddToCartWithRowNumber(int rowNumber){
        int index= rowNumber-1;
        WebElement product= productsList.get(index);
        BrowserUtils.hover(product);
        BrowserUtils.clickWithJS( addToCartButtonsOnOverlay.get(index));
        ShoppingCartPage.idOfProductsAddedToCart.add("product-"+rowNumber);
        BrowserUtils.waitFor(1);

        String name = productNames.get(index).getText();
        String price = productPrices.get(index).getText();

        addProductToProductsList("product-"+rowNumber,name,price);

//        Map<String,String> info= new HashMap<>();
//        info.put("id","product-"+rowNumber);
//        info.put("name",name);
//        info.put("price",price);
//        int quantity=1;
//        info.put("quantity",String.valueOf(quantity));
//        for (Map<String, String> map : products) {
//            if (map.get("id").contains(info.get("id"))) {
//                quantity = Integer.parseInt(map.get("quantity")) + 1;
//                map.put("quantity", String.valueOf(quantity));
//                return;
//            }
//        }
//        ProductsPage.products.add(info);
    }
    public void addProductToProductsList(String id,String name,String price){
        Map<String,String> info= new HashMap<>();
        info.put("id",id);
        info.put("name",name);
        info.put("price",price);
        int quantity=1;
        info.put("quantity",String.valueOf(quantity));
        for (Map<String, String> map : products) {
            if (map.get("id").contains(info.get("id"))) {
                quantity = Integer.parseInt(map.get("quantity")) + 1;
                map.put("quantity", String.valueOf(quantity));
                return;
            }
        }
        ProductsPage.products.add(info);
    }
    public void clickViewCartOrContinueShopping(String choice){
        WebElement element = Driver.get().findElement(By.xpath("//div[@class='modal-content']//*[text()='" + choice + "']"));
        BrowserUtils.clickWithJS(element);
    }
}
