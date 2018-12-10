package bvgAuto.bvg;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bvgAuto.WebDriverTestBase;

import java.awt.*;

public class bvgTests extends WebDriverTestBase{
    private Login login;
    private MessageField messageField;
    private EmailMessager emailMessager;

    @BeforeClass(alwaysRun = true)
    public void initPages() {
        login = PageFactory.initElements(browser, Login.class);
        messageField = PageFactory.initElements(browser, MessageField.class);
        emailMessager = PageFactory.initElements(browser, EmailMessager.class);
        emailMessager.setMessageFields(messageField);

        System.out.println("Jira Pages Initialized");
    }
    @Test(priority = -1,  groups = { "LoginDev"})
    public void login(){
        login.enterDev();
    }

    @Test(priority = -1, description = "EnterProd", groups = {"EnterProd"})
    public void enterProd(){
        login.enterProd();
    }

    @Test(description = "1. Send message from Home page", groups = { "Login", "FeedbackForm"})
    public void homeAllFields() throws InterruptedException,  AWTException {
        messageField.homeAllFields();
    }

    @Test(description = "2. Send message from Home page, Required fields", dependsOnMethods = "homeAllFields", groups = { "Login", "FeedbackForm"})
    public void homeRequiredFields()  {
        messageField.homeRequiredFields();
    }

    @Test(description = "3. Send message from Home page, Required fields", dependsOnMethods = "homeRequiredFields", groups = { "Login", "FeedbackForm"})
    public void contactUsAllFields() throws InterruptedException {
        messageField.contactUsAllFields();
    }
    @Test(description = "4. Send message from Home page, Required fields", dependsOnMethods = "contactUsAllFields", groups = { "Login", "FeedbackForm"})
    public void contactUsRequiredFields() {
        messageField.contactUsRequiredFields();
    }

    @Test(description = "5. Mail AB Soft", dependsOnMethods = "contactUsRequiredFields", groups = { "Login", "FeedbackForm"})
    public void receiveMessage() throws InterruptedException {
        emailMessager.mailerABSoft();
    }


}
