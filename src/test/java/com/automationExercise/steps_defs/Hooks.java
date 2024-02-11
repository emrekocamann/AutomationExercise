package com.automationExercise.steps_defs;

import com.automationExercise.pages.AddToCart;
import com.automationExercise.pages.BasePage;
import com.automationExercise.pages.HomePage;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class Hooks {
    @Before
    public void setUp() throws IOException {
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        File folder = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\DownloadFiles");
        FileUtils.cleanDirectory(folder);
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        AddToCart.listOfProductsAddedToCart.clear();
        Driver.closeDriver();
    }
}
