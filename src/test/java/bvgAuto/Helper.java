package bvgAuto;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
    private WebDriver browser;

    public Helper(WebDriver currentBrowser) {
        browser = currentBrowser;
    }

    public WebElement fill(WebElement selector, String value){
        selector.sendKeys(value);
        return selector;
    }

    public static String timeStamp() {
        return new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date());
    }

}
