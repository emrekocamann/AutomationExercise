package com.automationExercise.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private Driver() {}
    private static WebDriver driver;
    private static final String downloadLocation = System.getProperty("user.dir")+"\\src\\test\\resources\\DownloadFiles";
    public static WebDriver get(){

        if (driver==null){
            String browser = ConfigurationReader.get("browser");
            final Path firefoxAddBlockerPath = Paths.get("src/test/resources/extensions/ublock_origin-1.55.0.xpi");
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
        options.setExperimentalOption("prefs", prefs);      //for disable save address
        options.addArguments("--start-maximized");      //full screen
        options.addExtensions(new File("src/test/resources/extensions/UBlock_Origin_For_Chrome.crx")); //add blocker

        return options;
    }
}