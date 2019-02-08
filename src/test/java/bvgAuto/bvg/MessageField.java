package bvgAuto.bvg;

import bvgAuto.Helper;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import java.awt.*;
import java.time.Duration;

public class MessageField {

    private final WebDriver browser;
    private final Helper h;

    @FindBy (css = "input[type='text']")
    private WebElement inputName;
    @FindBy (css = "input[type='email']")
    private WebElement inputEmail;
    @FindBy (css = "textarea[name='your-message']")
    private WebElement inputTextMessage;
    @FindBy (css = "input[value='Send']")
    private WebElement buttonSend;
    @FindBy (css = "div.wpcf7-response-output.wpcf7-display-none.wpcf7-mail-sent-ok")
    private WebElement succesAlert;
    @FindBy (css = "li#menu-item-10311")
    private WebElement menuButtonContactUs;
    public String messageHomeAllFields;
    public String messageHomeRequiredFields;
    public String messageContactUsAllFields;
    public String messageContactUsRequiredFields;

    public MessageField(WebDriver browser) {

        this.browser = browser;
        this.h = new Helper(browser);
    }

    public void homeAllFields() throws InterruptedException, AWTException {

        Robot robot = new Robot();
        robot.mouseMove(200, 200);
        robot.mouseWheel(1);
        Thread.sleep(1500);
        robot.mouseWheel(1);
        Thread.sleep(1500);
        robot.mouseWheel(1);
        Thread.sleep(1500);
        robot.mouseWheel(1);
        Thread.sleep(1500);

        String timeHomeAllFields = Helper.timeStamp();
        h.fill(inputName, "Home page, all fields " + timeHomeAllFields);
        h.fill(inputEmail, "test@gmail.com");
        h.fill(inputTextMessage, "Test text message");
        buttonSend.click();
//
        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class).until(browser -> succesAlert).isDisplayed();

        Assert.assertTrue(succesAlert.isEnabled());

        messageHomeAllFields = "Home page, all fields " + timeHomeAllFields;
        System.out.println(messageHomeAllFields);
    }
    
//    public void homeRequiredFields() {
//        String timeHomeRequiredFields  = Helper.timeStamp();
//
//        h.fill(inputName, "Home page, no message body " + timeHomeRequiredFields);
//        h.fill(inputEmail, "test@gmail.com");
//        buttonSend.click();
//
//        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
//                .ignoring(InvalidElementStateException.class, NoSuchElementException.class).until(browser -> succesAlert).isDisplayed();
//
//        Assert.assertTrue(succesAlert.isEnabled());
//
//        messageHomeRequiredFields = "Home page, no message body "  + timeHomeRequiredFields;
//        System.out.println(messageHomeRequiredFields);
//    }

    public void contactUsAllFields() throws InterruptedException {
        menuButtonContactUs.click();
        Thread.sleep(2000);

        String timeContactUsAllFields  = Helper.timeStamp();

        h.fill(inputName, "Contact Us page, all fields "  + timeContactUsAllFields);
        h.fill(inputEmail, "test@gmail.com");
        h.fill(inputTextMessage, "Test text message");
        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
                .ignoring(ElementNotVisibleException.class).until(browser -> buttonSend).click();

        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
                .ignoring(InvalidElementStateException.class, NoSuchElementException.class).until(browser -> succesAlert).isDisplayed();

        Assert.assertTrue(succesAlert.isEnabled());

        messageContactUsAllFields = "Contact Us page, all fields "  + timeContactUsAllFields;
        System.out.println(messageContactUsAllFields);
    }

//    public void contactUsRequiredFields(){
//        String currentTime  = Helper.timeStamp();
//
//        h.fill(inputName, "Contact Us page, no message body " + currentTime);
//        h.fill(inputEmail, "test@gmail.com");
//        buttonSend.click();
//
//        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
//                .ignoring(InvalidElementStateException.class, NoSuchElementException.class).until(browser -> succesAlert).isDisplayed();
//
//        Assert.assertTrue(succesAlert.isEnabled());
//
//        messageContactUsRequiredFields = "Contact Us page, no message body " + currentTime;
//        System.out.println(messageContactUsRequiredFields);
//    }
}
