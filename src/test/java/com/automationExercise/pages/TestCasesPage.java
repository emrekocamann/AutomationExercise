package com.automationExercise.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class TestCasesPage extends BasePage{
    private final int numOfTestCases = 26;
    @FindBy(xpath = "//div[@class='col-sm-8']//li//*[contains(.,'Test Cases')]")
    private WebElement testCasesButton;

    @FindBy(xpath = "//b[text()='Test Cases']")
    private WebElement testCasesText;

    @FindBy(xpath = "//div[@class='panel-heading']//*[contains(text(),'Test Case')]")
    private List<WebElement> allTestCases;
}
