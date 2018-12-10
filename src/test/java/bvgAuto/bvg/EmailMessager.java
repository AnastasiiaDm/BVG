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
    @FindBy(css = "span[alt='wordpress@bvgsoftwaregroup.com']")
    private List<WebElement> messages;

    public EmailMessager(WebDriver browser) {
        this.browser = browser;
        this.h = new Helper(browser);
    }

    public void mailerABSoft() throws InterruptedException {
        Thread.sleep(8000);
        browser.get(bvgVars.abSoftURL);
        h.findAndFill(inputABSoftName, bvgVars.bSoftName);
        h.findAndFill(inputABSoftPassword, bvgVars.abSoftPassword);
        buttonLogin.click();
        Thread.sleep(2000);

        boolean isContainsHomeAllFields = messageHomeAllFieldsIsPresent();
        Assert.assertTrue(isContainsHomeAllFields);
        System.out.println("HomeAllFields message exist");

        boolean isContainsHomeRequiredFields = messageHomeRequiredFieldsIsPresent();
        Assert.assertTrue(isContainsHomeRequiredFields);
        System.out.println("HomeRequiredFields message exist");

        boolean isContainsContactUsAllFields = messageContactUsAllFieldsIsPresent();
        Assert.assertTrue(isContainsContactUsAllFields);
        System.out.println("ContactUsAllFields message exist");

        boolean isContainsContactUsRequiredFields = messageContactUsRequiredFieldsIsPresent();
        Assert.assertTrue(isContainsContactUsRequiredFields);
        System.out.println("ContactUsRequiredFields message exist");
    }

    public void setMessageFields(MessageField messageField) {
        this.messageField = messageField;
    }

    private boolean messageHomeAllFieldsIsPresent() {
        for (WebElement item : messages) {
            if (item.getText().equals(messageField.messageHomeAllFields))
                return true;
        }
        System.out.println("messageHomeAllFields not exist");
        return false;
    }
    private boolean messageHomeRequiredFieldsIsPresent() {
        for (WebElement item : messages) {
            if (item.getText().equals(messageField.messageHomeRequiredFields))
                return true;
        }
        System.out.println("messageHomeRequiredFields not exist");
        return false;
    }
    private boolean messageContactUsAllFieldsIsPresent() {
        for (WebElement item : messages) {
            if (item.getText().equals(messageField.messageContactUsAllFields))
                return true;
        }
        System.out.println("messageContactUsAllFields not exist");
        return false;
    }
    private boolean messageContactUsRequiredFieldsIsPresent() {
        for (WebElement item : messages) {
            if (item.getText().equals(messageField.messageContactUsRequiredFields))
                return true;
        }
        System.out.println("messageContactUsRequiredFields not exist");
        return false;
    }
}

