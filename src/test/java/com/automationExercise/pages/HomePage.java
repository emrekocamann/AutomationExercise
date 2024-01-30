package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import lombok.Getter;
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
}
