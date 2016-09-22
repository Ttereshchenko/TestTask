package utils;

import browsers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


/**
 * Created by doifu_000 on 9/21/16.
 */
public class UITestSetup {

    private static WebDriver DRIVER;

    public static void setDRIVER(WebDriver  newDriverValue) {
        DRIVER = newDriverValue;
    }

    public static WebDriver getDRIVER() {
        return DRIVER;
    }

    @BeforeTest
    public void setupTest() {
        DRIVER = WebDriverManager.getDriverInstance();
    }
    @AfterTest
    public void tearDownTest() {
        DRIVER.close(); }
}
