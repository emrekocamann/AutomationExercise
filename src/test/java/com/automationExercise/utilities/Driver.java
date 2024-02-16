package com.automationExercise.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private Driver() {}
    private static WebDriver driver;
    private static final String downloadLocation = System.getProperty("user.dir")+"\\src\\test\\resources\\DownloadFiles";
    public static WebDriver get(){

        if (driver==null){
            String browser = ConfigurationReader.get("browser");
            switch (browser.trim().toLowerCase()){
                case "chrome"-> driver= new ChromeDriver(chromeOptions());
                case "chrome-headless"->driver= new ChromeDriver(chromeOptions().addArguments("--headless=new"));
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
    private static ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("download.default_directory", downloadLocation);          //for download files to the project
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);      //for disable save address
        options.addArguments("--start-maximized");      //full screen
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation")); //chrome is being controlled by automated test software
        options.addExtensions(new File("src/test/resources/extensions/UBlock_Origin_For_Chrome.crx")); //add blocker

        return options;
    }
}