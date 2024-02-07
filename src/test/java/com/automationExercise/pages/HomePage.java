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
    @FindBy(id= "accordian")
    private WebElement categoryPanel;
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
   //     ShoppingCartPage.idOfProductsAddedToCart.add("product-"+rowNumber);
        BrowserUtils.waitFor(1);

        String name = productNames.get(index).getText();
        String price = productPrices.get(index).getText();
        int quantity=1;
        addProductToCart("product-"+rowNumber,name,price,quantity);
    }
    public void clickCategory(String categoryName){
        BrowserUtils.scrollToElement(categoryPanel);
        Driver.get().findElement(By.xpath("//a[contains(.,'"+categoryFormatter(categoryName)+"')]")).click();
        BrowserUtils.waitFor(2);
    }
    public void clickSubCategory(String categoryName){
        categoryName = categoryFormatter(categoryName)+" ";
        WebElement dressUnderWomen = Driver.get().findElement(By.xpath("(//div[@class='panel-body']//a[text()='Dress '])[1]"));
        WebElement dressUnderKids = Driver.get().findElement(By.xpath("(//div[@class='panel-body']//a[text()='Dress '])[2]"));
        if (categoryName.equals("Dress ")){
            if (Driver.get().findElement(By.cssSelector("div[id='Women']")).isDisplayed()){
                BrowserUtils.waitForVisibility(dressUnderWomen);
                BrowserUtils.clickWithJS(dressUnderWomen);
              //  dressUnderWomen.click();
            }
            else if (Driver.get().findElement(By.cssSelector("div[id='Kids']")).isDisplayed()) {
                BrowserUtils.waitForVisibility(dressUnderKids);
                BrowserUtils.clickWithJS(dressUnderKids);
         //       dressUnderKids.click();
            }
        }else{
            WebElement element = Driver.get().findElement(By.xpath("//div[@class='panel-body']//a[text()='" + categoryName + "']"));
            BrowserUtils.clickWithJS(element);
        }
        if (Driver.get().getCurrentUrl().contains("#google_vignette")){
            Driver.get().navigate().refresh();
            clickSubCategory(categoryName);
        }
    }

    public void clickSubCategory2(String subCategoryName, String categoryName){
        List<WebElement> elements;
        switch (categoryName){
            case "WOMEN" ->{
                 elements = Driver.get().findElements(By.xpath("//div[@id='Women']//li/a"));
                 switch (subCategoryName) {
                    case "DRESS" -> BrowserUtils.clickWithJS(elements.get(0));
                    case "TOPS" -> BrowserUtils.clickWithJS(elements.get(1));
                    case "SAREE" -> BrowserUtils.clickWithJS(elements.get(2));
                }
            }
            case "MEN" ->{ elements = Driver.get().findElements(By.xpath("//div[@id='Men']//li/a"));
                switch (subCategoryName) {
                    case "TSHIRTS" -> BrowserUtils.clickWithJS(elements.get(0));
                    case "JEANS" -> BrowserUtils.clickWithJS(elements.get(1));
                }
            }
            case "KIDS" ->{elements = Driver.get().findElements(By.xpath("//div[@id='Kids']//li/a"));
                switch (subCategoryName) {
                    case "DRESS" -> BrowserUtils.clickWithJS(elements.get(0));
                    case "TOPS & SHIRTS" -> BrowserUtils.clickWithJS(elements.get(1));
                }
            }
        }
        BrowserUtils.waitFor(1);
        if (Driver.get().getCurrentUrl().contains("#google_vignette")){
            Driver.get().navigate().refresh();
            clickSubCategory2(subCategoryName,categoryName);
        }
    }
    private String categoryFormatter(String categoryName){
        StringBuilder newCategoryName = new StringBuilder();
        newCategoryName.append(Character.toUpperCase(categoryName.charAt(0)));
        for (int i = 1; i < categoryName.length(); i++) {
            if (categoryName.charAt(i-1)==' '){
                newCategoryName.append(Character.toUpperCase(categoryName.charAt(i)));
            }else {
                newCategoryName.append(Character.toLowerCase(categoryName.charAt(i)));
            }
        }
        return newCategoryName.toString();
    }

}
