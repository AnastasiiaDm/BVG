package bvgAuto.bvg;

import bvgAuto.Helper;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmailMessager {

    private WebDriver browser;
    private Helper h;
    private MessageField messageField;

    @FindBy(css = "input.user")
    private WebElement inputABSoftName;
    @FindBy(css = "input.pwd")
    private WebElement inputABSoftPassword;
    @FindBy(css = "input#login")
    private WebElement buttonLogin;
    @FindBy(css = "span[alt='wordpress@bvgsoftwaregroup.com']")
    private List<WebElement> messages;

    public EmailMessager(WebDriver browser) {
        this.browser = browser;
        this.h = new Helper(browser);
    }

    public void mailerABSoft() throws InterruptedException {
        Thread.sleep(8000);
        browser.get(bvgVars.abSoftURL);
        h.fill(inputABSoftName, bvgVars.bSoftName);
        h.fill(inputABSoftPassword, bvgVars.abSoftPassword);
        buttonLogin.click();
        Thread.sleep(2000);

        boolean isContainsHomeAllFields = sentMessage(messageField.messageHomeRequiredFields);
        Assert.assertTrue(isContainsHomeAllFields);
        System.out.println("HomeAllFields message exist");

        boolean isContainsHomeRequiredFields = sentMessage(messageField.messageHomeRequiredFields);
        Assert.assertTrue(isContainsHomeRequiredFields);
        System.out.println("HomeRequiredFields message exist");

        boolean isContainsContactUsAllFields = sentMessage(messageField.messageContactUsAllFields);
        Assert.assertTrue(isContainsContactUsAllFields);
        System.out.println("ContactUsAllFields message exist");

        boolean isContainsContactUsRequiredFields = sentMessage(messageField.messageContactUsRequiredFields);
        Assert.assertTrue(isContainsContactUsRequiredFields);
        System.out.println("ContactUsRequiredFields message exist");
    }

    public void setMessageFields(MessageField messageField) {
        this.messageField = messageField;
    }

    private boolean sentMessage (String value) {
        for (WebElement item : messages) {
            if (item.getText().equals(value))
                return true;
        }
        System.out.println("value not exist " + value);
        return false;
    }
}

