package utils;

import browsers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;


/**
 * Created by doifu_000 on 9/21/16.
 */
public class UITestSetup {

    public static final Logger LOG = Logger.getLogger(UITestSetup.class.getName());
    private static WebDriver DRIVER;

    public static WebDriver getDRIVER() {
        return DRIVER;
    }

    public static void setDRIVER(WebDriver newDriverValue) {
        DRIVER = newDriverValue;
    }

    @BeforeTest
    public void setupTest() {
        DRIVER = WebDriverManager.getDriverInstance();
    }

    @AfterTest
    public void tearDownTest() {
        DRIVER.close();
    }
}
