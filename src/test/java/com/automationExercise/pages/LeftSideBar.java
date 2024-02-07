package com.automationExercise.pages;

import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class LeftSideBar extends BasePage {
    @FindBy(id = "accordian")
    private WebElement categoryPanel;
    @FindBy(className = "brands_products")
    private WebElement brandsPanel;

    public void clickCategory(String categoryName) {
        BrowserUtils.scrollToElement(categoryPanel);
        Driver.get().findElement(By.xpath("//a[contains(.,'" + categoryFormatter(categoryName) + "')]")).click();
        BrowserUtils.waitFor(2);
    }

    public void clickSubCategory(String subCategoryName, String categoryName) {
        List<WebElement> elements;
        switch (categoryName) {
            case "WOMEN" -> {
                elements = Driver.get().findElements(By.xpath("//div[@id='Women']//li/a"));
                switch (subCategoryName) {
                    case "DRESS" -> BrowserUtils.clickWithJS(elements.get(0));
                    case "TOPS" -> BrowserUtils.clickWithJS(elements.get(1));
                    case "SAREE" -> BrowserUtils.clickWithJS(elements.get(2));
                }
            }
            case "MEN" -> {
                elements = Driver.get().findElements(By.xpath("//div[@id='Men']//li/a"));
                switch (subCategoryName) {
                    case "TSHIRTS" -> BrowserUtils.clickWithJS(elements.get(0));
                    case "JEANS" -> BrowserUtils.clickWithJS(elements.get(1));
                }
            }
            case "KIDS" -> {
                elements = Driver.get().findElements(By.xpath("//div[@id='Kids']//li/a"));
                switch (subCategoryName) {
                    case "DRESS" -> BrowserUtils.clickWithJS(elements.get(0));
                    case "TOPS & SHIRTS" -> BrowserUtils.clickWithJS(elements.get(1));
                }
            }
        }
        BrowserUtils.waitFor(1);
        if (Driver.get().getCurrentUrl().contains("#google_vignette")) {
            Driver.get().navigate().refresh();
            clickSubCategory(subCategoryName, categoryName);
        }
    }

    private String categoryFormatter(String categoryName) {
        StringBuilder newCategoryName = new StringBuilder();
        newCategoryName.append(Character.toUpperCase(categoryName.charAt(0)));
        for (int i = 1; i < categoryName.length(); i++) {
            if (categoryName.charAt(i - 1) == ' ') {
                newCategoryName.append(Character.toUpperCase(categoryName.charAt(i)));
            } else {
                newCategoryName.append(Character.toLowerCase(categoryName.charAt(i)));
            }
        }
        return newCategoryName.toString();
    }

    public void clickBrand(String brand) {
        if (brand.equals("H&M")) {
            Driver.get().findElement(By.xpath("//a[text()='H&M']")).click();
        } else {
            brand = categoryFormatter(brand);
            WebElement element = Driver.get().findElement(By.xpath("//a[text()='" + brand + "']"));
            element.click();
        }
    }

}
