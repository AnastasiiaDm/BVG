package bvgAuto.bvg;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bvgAuto.WebDriverTestBase;

import java.awt.*;

public class bvgTestsProd extends WebDriverTestBase{
    private MessageField messageField;
    private EmailMessager emailMessager;

    @BeforeClass(alwaysRun = true)
    public void initPages() {
        messageField = PageFactory.initElements(browser, MessageField.class);
        emailMessager = PageFactory.initElements(browser, EmailMessager.class);

        System.out.println("Jira Pages Initialized");
    }


    @Test(description = "1. Send message from Home page")
    public void sendMessageAllFields() throws InterruptedException, AWTException {
        browser.get(bvgVars.prodURL);

        messageField.fillAllMessageFields();
    }

    @Test(description = "2. Send message from Home page, Required fields", dependsOnMethods = "sendMessageAllFields")
    public void sendMessageRequiredFields() throws InterruptedException {
        messageField.fillRequiredMessageFields();
    }

//    @Test(description = "3. Send message from Home page, all fields", dependsOnMethods = "sendMessageRequiredFields")
//    public void receiveMessage(){
//        emailMessager.mailer();
//    }



}
