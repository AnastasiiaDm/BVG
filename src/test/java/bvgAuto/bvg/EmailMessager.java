package bvgAuto.bvg;

import bvgAuto.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class EmailMessager {

    private WebDriver browser;
    private Helper h;

    private final By inputMailerName = By.cssSelector("input#identifierId");
    private final By inputMailerPassword = By.cssSelector( "input.whsOnd");
@FindBy(css = "span.RveJvd")
private WebElement buttonEnterEmail;
    @FindBy(css = "content.CwaK9")
    private WebElement buttonEnterPassword;
    @FindBy(css = "tr.zA")
    private List<WebElement> allMessages;

    public EmailMessager(WebDriver browser) {
        this.browser = browser;
        this.h = new Helper(browser);


    }
    public void mailer(){
        browser.get(bvgVars.mailerURL);
        h.findAndFill(inputMailerName, bvgVars.mailerName);
        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class).until(browser -> buttonEnterEmail).click();

//        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class, TimeoutException.class).until(browser -> inputMailerPassword);
        new FluentWait<>(browser).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class, ElementNotVisibleException.class).until(browser -> inputMailerPassword);

        h.findAndFill(inputMailerPassword, bvgVars.mailerPassword);
        h.findAndFill(inputMailerName, bvgVars.mailerName);

//        buttonEnterPassword.click();

        allMessages.get(0).click();

    }

}
