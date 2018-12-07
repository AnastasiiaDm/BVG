package bvgAuto.bvg;

import bvgAuto.Helper;
import bvgAuto.bvg.MessageField;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class EmailMessager {

    private WebDriver browser;
    private Helper h;
    private MessageField messageField;

    private final By inputMailerName = By.cssSelector("input#identifierId");
    private final By inputMailerPassword = By.cssSelector("input.whsOnd");
    private final By inputABSoftName = By.cssSelector("input.user");
    private final By inputABSoftPassword = By.cssSelector("input.pwd");


    @FindBy(css = "span.RveJvd")
    private WebElement buttonEnterEmail;
    @FindBy(css = "content.CwaK9")
    private WebElement buttonEnterPassword;
    @FindBy(css = "tr.zA")
    private List<WebElement> allMessages;
    @FindBy(css = "input#login")
    private WebElement buttonLogin;

    //    @FindBy(css = "div.sorted_by_received")
    @FindBy(css = "span[alt='wordpress@bvgsoftwaregroup.com']")
    private List<WebElement> messages;
//    private WebElement messages;


    public EmailMessager(WebDriver browser) {
        this.browser = browser;
        this.h = new Helper(browser);
    }

    public void mailerGmail() {
        browser.get(bvgVars.gmailURL);
        h.findAndFill(inputMailerName, bvgVars.gmailName);
        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class).until(browser -> buttonEnterEmail).click();

//        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class, TimeoutException.class).until(browser -> inputMailerPassword);
        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class, ElementNotVisibleException.class).until(browser -> inputMailerPassword);

        h.findAndFill(inputMailerPassword, bvgVars.gmailPassword);
        h.findAndFill(inputMailerName, bvgVars.gmailName);

//        buttonEnterPassword.click();

        allMessages.get(0).click();
    }

    public void mailerABSoft() throws InterruptedException {
        Thread.sleep(8000);
        browser.get(bvgVars.abSoftURL);
        h.findAndFill(inputABSoftName, bvgVars.bSoftName);
        h.findAndFill(inputABSoftPassword, bvgVars.abSoftPassword);
        buttonLogin.click();

        boolean isContainsHomeAllFields = false;
        for (WebElement item:messages) {
            if(item.getText().equals(messageField.messageHomeAllFields))
                isContainsHomeAllFields = true;
        }
        Assert.assertTrue(isContainsHomeAllFields);
        System.out.println("HomeAllFields message send successfully");

        boolean isContainsHomeRequiredFields = false;
        for (WebElement item:messages) {
            if(item.getText().equals(messageField.messageHomeAllFields))
                isContainsHomeRequiredFields = true;
        }
        Assert.assertTrue(isContainsHomeRequiredFields);
        System.out.println("HomeRequiredFields message send successfully");

        boolean isContainsContactUsAllFields = false;
        for (WebElement item:messages) {
            if(item.getText().equals(messageField.messageHomeAllFields))
                isContainsContactUsAllFields = true;
        }
        Assert.assertTrue(isContainsContactUsAllFields);
        System.out.println("ContactUsAllFields message send successfully");

        boolean isContainsContactUsRequiredFields = false;
        for (WebElement item:messages) {
            if(item.getText().equals(messageField.messageHomeAllFields))
                isContainsContactUsRequiredFields = true;
//            System.out.println(item.getText());
        }
        Assert.assertTrue(isContainsContactUsRequiredFields);
        System.out.println("ContactUsRequiredFields message send successfully");
    }

    public void setMessageFields(MessageField messageField) {
        this.messageField = messageField;
    }
}
