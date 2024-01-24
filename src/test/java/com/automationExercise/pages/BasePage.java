package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[@class='col-sm-8']//li//*[contains(.,'Home')]")
    protected WebElement homeButton;

    public void navigateToMenu(String menuName){
        String locator= "//div[@class='col-sm-8']//a[contains(.,'"+menuName+"')]";
        WebElement menu= Driver.get().findElement(By.xpath(locator));
        menu.click();
    }
}
