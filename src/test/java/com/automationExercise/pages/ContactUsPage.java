package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class ContactUsPage extends BasePage {
    @FindBy(xpath = "//h2[.='Get In Touch']")
    private WebElement getInTouchTExt;
    @FindBy(name = "name")
    private WebElement nameInputBox;
    @FindBy(name = "email")
    private WebElement emailInputBox;
    @FindBy(name = "subject")
    private WebElement subjectInputBox;
    @FindBy(name = "message")
    private WebElement messageInputBox;
    @FindBy(name = "upload_file")
    private WebElement uploadFile;
    @FindBy(name = "submit")
    private WebElement SubmitButton;
    @FindBy(css = "div.contact-form>div.status")
    private WebElement successMessage;
    @FindBy(css = "div[id='form-section']>a")
    private WebElement homeButton;

    public void fillOutContactUsForm(){
        nameInputBox.sendKeys(newUserData.get("firstName"));
        emailInputBox.sendKeys(newUserData.get("email"));
        String subject = faker.ancient().hero();
        subjectInputBox.sendKeys(subject);
        String message = faker.lorem().paragraph();
        messageInputBox.sendKeys(message);
    }
    public void uploadFile(){
        String projectPath= System.getProperty("user.dir");
        String filePath = "src/test/resources/fileUpload/sunset.jpg";
        String fullPath = projectPath+"/"+filePath;
        uploadFile.sendKeys(fullPath);
    }
    public void acceptAlert(){
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }
}
