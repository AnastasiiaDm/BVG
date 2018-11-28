package bvgAuto.bvg;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bvgAuto.WebDriverTestBase;

public class bvgTests extends WebDriverTestBase{
    private Login login;

    @BeforeClass(alwaysRun = true)
    public void initPages() {
        login = PageFactory.initElements(browser, Login.class);
        System.out.println("Jira Pages Initialized");
    }

}
