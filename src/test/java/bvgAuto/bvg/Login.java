package bvgAuto.bvg;

import bvgAuto.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;


public class Login {

    private final WebDriver browser;
    private final Helper h;

    private final By inputPassword = By.cssSelector( "input.enter_password");

    public Login(WebDriver browser) {
        this.browser = browser;
        this.h = new Helper(browser);

        browser.get(bvgVars.devURL);

        h.findAndFill(inputPassword, bvgVars.password);
    }
}
