package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class HomePage extends BasePage{
    @FindBy(id = "slider")
    private WebElement slider;
    @FindBy(css = "div.features_items div.col-sm-4 div.choose")
    private List<WebElement> viewProductsButtons;
    public void clickViewProductsWithProductsIndex(int index){
        BrowserUtils.scrollToElement(viewProductsButtons.get(index));
        viewProductsButtons.get(index).click();
        currentProductNum = index+1;
    }
    public void clickViewProductWithName(String productName){
        WebElement addToCartButton = Driver.get().findElement(By.xpath("" +
                "((//p[text()='" + productName + "'])[1]/ancestor::div[@class='product-image-wrapper']//a)[2]"));

        currentProductNum=Integer.parseInt(addToCartButton.getAttribute("data-product-id"));
        Driver.get().findElement(By.xpath(
                "(//p[text()='"+productName+"'])[1]/ancestor::div[@class='product-image-wrapper']//*[text()='View Product']"))
                .click();
    }
}
