package bvgAuto.bvg;

import bvgAuto.Helper;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import javax.lang.model.element.Element;
import java.awt.*;
import java.time.Duration;
import java.util.List;

import bvgAuto.Helper;


public class MessageField {

    private final WebDriver browser;
    private final Helper h;

    private final By inputName = By.cssSelector("input[type='text']");
    private final By inputEmail = By.cssSelector("input[type='email']");
    private final By inputTextMessage = By.cssSelector("textarea[name='your-message']");
    @FindBy (css = "input[value='Send']")
    private WebElement buttonSend;
    @FindBy (css = "div.wpcf7-response-output.wpcf7-display-none.wpcf7-mail-sent-ok")
    private WebElement succesAlert;
//    @FindBy (css = "span.ajax-loader.is-active")
//    private WebElement spanLoader;



    public MessageField(WebDriver browser) {

        this.browser = browser;
        this.h = new Helper(browser);
    }

    public void fillAllMessageFields() throws InterruptedException, AWTException {

        System.out.println("fillAllMessageFields start");

//        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", inputName);
//        ((JavascriptExecutor) browser).executeScript("window.scrollBy(0,900)");
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

        h.findAndFill(inputName, "Home page, all fields " + Helper.timeStamp());
        h.findAndFill(inputEmail, "test@gmail.com");
        h.findAndFill(inputTextMessage, "Test text message");
        buttonSend.click();
//        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class, ElementNotVisibleException.class).until(browser -> succesAlert).isDisplayed();
        Thread.sleep(5000);
        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(InvalidElementStateException.class).until(browser -> succesAlert).isDisplayed();

        Assert.assertTrue(succesAlert.isEnabled());
        System.out.println(succesAlert);
        System.out.println("fillAllMessageFields complete");

    }
    public void fillRequiredMessageFields() throws InterruptedException {
        System.out.println("fillRequiredMessageFields start");

        h.findAndFill(inputName, "Home page, no message body " + Helper.timeStamp());
        h.findAndFill(inputEmail, "test@gmail.com");
        buttonSend.click();

        Thread.sleep(5000);
        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(InvalidElementStateException.class).until(browser -> succesAlert).isDisplayed();

        Assert.assertTrue(succesAlert.isEnabled());
        System.out.println(succesAlert);
        System.out.println("fillRequiredMessageFields complete");

    }

}
