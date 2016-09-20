package Browsers;

import org.openqa.selenium.WebDriver;

/**
 * Created by doifu_000 on 20.09.2016.
 */
public class GoogleChrome {

    public static final WebDriver webDriver= getDriver();

    public static WebDriver getDriver(){
        return (WebDriver) new GoogleChrome();
    }

}
