package com.automationExercise.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

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
                case "firefox" -> {
                    FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions());
                    firefoxDriver.installExtension(firefoxAddBlockerPath);
                    driver = firefoxDriver;
                }
                case "firefox-headless" -> {
                    FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions().addArguments("--headless=new"));
                    firefoxDriver.installExtension(firefoxAddBlockerPath);
                    driver = firefoxDriver;
                }
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
    private static FirefoxOptions firefoxOptions(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList",2); //Use for the default download directory the last folder specified for a download
        profile.setPreference("browser.download.dir", downloadLocation); //Set the last directory used for saving a file from the "What should (browser) do with this file?" dialog.
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain"); //list of MIME types to save to disk without asking what to use to open the file
        profile.setPreference("pdfjs.disabled", true);  // disable the built-in PDF viewer
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.addArguments("--start-maximized");      //full screen
        return options;
    }
}