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

        boolean isContainsHomeAllFields = false;
        boolean isContainsHomeRequiredFields = false;
        boolean isContainsContactUsAllFields = false;
        boolean isContainsContactUsRequiredFields = false;

        int cont = 0;
        while (!(isContainsHomeAllFields && isContainsHomeRequiredFields && isContainsContactUsAllFields && isContainsContactUsRequiredFields)) {


            if (!isContainsHomeAllFields)
                isContainsHomeAllFields = sentMessage(messageField.messageHomeRequiredFields);

            if (!isContainsHomeRequiredFields)
                isContainsHomeRequiredFields = sentMessage(messageField.messageHomeRequiredFields);

            if (!isContainsContactUsAllFields)
                isContainsContactUsAllFields = sentMessage(messageField.messageContactUsAllFields);

            if (!isContainsContactUsRequiredFields)
                isContainsContactUsRequiredFields = sentMessage(messageField.messageContactUsRequiredFields);

            System.out.println("Time of test:  " + Helper.timeStamp());
            System.out.println("isContainsHomeAllFields " + isContainsHomeAllFields);
            System.out.println("isContainsHomeRequiredFields " + isContainsHomeRequiredFields);
            System.out.println("isContainsContactUsAllFields " + isContainsContactUsAllFields);
            System.out.println("isContainsContactUsRequiredFields " + isContainsContactUsRequiredFields);
            Thread.sleep( 60*1000);

            cont++;
            if (cont==2){
                Assert.assertFalse(false);
                System.out.println("Test failed");
                return;
            }

        }

        Assert.assertTrue(true);

//        Assert.assertTrue(isContainsHomeAllFields);
//        System.out.println("HomeAllFields message exist");


//        Assert.assertTrue(isContainsHomeRequiredFields);
//        System.out.println("HomeRequiredFields message exist");


//        Assert.assertTrue(isContainsContactUsAllFields);
//        System.out.println("ContactUsAllFields message exist");


//        Assert.assertTrue(isContainsContactUsRequiredFields);
//        System.out.println("ContactUsRequiredFields message exist");
    }

    public void setMessageFields(MessageField messageField) {
        this.messageField = messageField;
    }

    //    private boolean sentMessage (String value) {
//        for (WebElement item : messages) {
//            if (item.getText().equals(value))
//                return true;
//        }
//        System.out.println("value not exist " + value);
//        return false;
//    }
    private boolean sentMessage(String value) {
        for (WebElement item : messages) {
            if (item.getText().equals(value))
                return true;
        }
        System.out.println("value not exist " + value);
        return false;
    }


}

