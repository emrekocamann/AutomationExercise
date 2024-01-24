package com.automationExercise.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class HomePage extends BasePage{
    @FindBy(id = "slider")
    private WebElement slider;
}
