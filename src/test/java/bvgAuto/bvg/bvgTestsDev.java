package bvgAuto.bvg;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bvgAuto.WebDriverTestBase;

import java.awt.*;

public class bvgTestsDev extends WebDriverTestBase{
    private Login login;
    private MessageField messageField;
    private EmailMessager emailMessager;

    @BeforeClass(alwaysRun = true)
    public void initPages() {
        login = PageFactory.initElements(browser, Login.class);
        messageField = PageFactory.initElements(browser, MessageField.class);
        emailMessager = PageFactory.initElements(browser, EmailMessager.class);


        System.out.println("Jira Pages Initialized");


    }
    @Test(priority = -1)
    public void login(){
        login.EnterSite();
    }

    @Test(description = "1. Send message from Home page")
    public void sendMessage() throws InterruptedException, AWTException {
//Thread.sleep(3000);
messageField.fillAllMessageFields();
    }
//    @Test(description = "1. Send message from Home page", dependsOnMethods = "sendMessage")
//    public void receiveMessage(){
//        emailMessager.mailer();
//    }


}
