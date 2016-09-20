package Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by doifu_000 on 20.09.2016.
 */
public class MozillaFirefox  {

    public static final WebDriver webDriver= getDriver();

    public static WebDriver getDriver(){
        return new FirefoxDriver();
    }
}
