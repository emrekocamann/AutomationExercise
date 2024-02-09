package com.automationExercise.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static WebElement waitForVisibility(WebElement element) {

        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
     public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }
    public static List<String> getElementsText(List<WebElement> elements){
        List<String> list = new ArrayList<>();
        for (WebElement element : elements) {
            list.add(element.getText());
        }
        return list;
    }
    public static void verifyDownloadedFile(String expectedFileName){
        File folder = new File(System.getProperty("user.dir")+"/src/test/resources\\DownloadFiles");
        File[] files =folder.listFiles();
        boolean isFilePresent=false;
        if (files != null) {
            for (File file : files) {
                if (file.isFile()){
                    String fileName = file.getName();
                    if (fileName.equals(expectedFileName)){
                      isFilePresent =true;
                    }
                }
            }
        }
        Assert.assertTrue(isFilePresent);
    }
}
