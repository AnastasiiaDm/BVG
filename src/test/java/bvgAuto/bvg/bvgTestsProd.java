package bvgAuto.bvg;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
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
    public void homeAllFields() throws InterruptedException,  AWTException {
        browser.get(bvgVars.prodURL);
        messageField.homeAllFields();
    }

    @Test(description = "2. Send message from Home page, Required fields", dependsOnMethods = "homeAllFields")
    public void homeRequiredFields()  {
        messageField.homeRequiredFields();
    }

    @Test(description = "3. Send message from Home page, Required fields", dependsOnMethods = "homeRequiredFields")
    public void contactUsAllFields() throws InterruptedException {
        messageField.contactUsAllFields();
    }
    @Test(description = "4. Send message from Home page, Required fields", dependsOnMethods = "contactUsAllFields")
    public void contactUsRequiredFields() {
        messageField.contactUsRequiredFields();
    }
    @AfterTest(description = "5. Mail AB Soft")
    public void receiveMessage() throws InterruptedException {
        emailMessager.mailerABSoft();
    }
}
