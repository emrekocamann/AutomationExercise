package com.automationExercise.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private Driver() {}
    private static WebDriver driver;

    public static WebDriver get(){
        if (driver==null){
            String browser = ConfigurationReader.get("browser");
            switch (browser.trim().toLowerCase()){
                case "chrome"->driver= new ChromeDriver();
                case "chrome-headless"->driver= new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
                case "firefox" -> driver = new FirefoxDriver();
                case "firefox-headless" -> driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless=new"));
                case "ie"-> {
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    driver = new InternetExplorerDriver();
                }
                case "edge"->{
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    driver = new EdgeDriver();
                }
                case "safari"->{
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    driver = new SafariDriver();
                }

            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}