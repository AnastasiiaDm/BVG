package bvgAuto.bvg;

import bvgAuto.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

    private WebDriver browser;
    private Helper h;

    @FindBy(css = "input.enter_password" )
    private WebElement inputPassword;

    public Login(WebDriver browser) {
        this.browser = browser;
        this.h = new Helper(browser);
    }

    public void enterDev() {
        browser.get(bvgVars.devURL);
        h.fill(inputPassword, bvgVars.password).submit();
        System.out.println("EnterSite success");
    }

    public void enterProd() {
        browser.get(bvgVars.prodURL);


    }
}
