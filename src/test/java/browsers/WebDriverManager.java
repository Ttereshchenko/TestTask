package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ProjectProperties;

/**
 * Created by doifu_000 on 9/21/16.
 */
public class WebDriverManager {
    public enum Browsers{
        FIREFOX("firefox"),
        CHROME("chrome");

        private String name;

        Browsers(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Browsers getBrowser (String name) {
            for( Browsers browser : Browsers.values()) {
                if(browser.getName().equalsIgnoreCase(name))
                    return browser;
            }
            // Default browser if string input is incorrect
            return FIREFOX;
        }
    }


    public static WebDriver getDriverInstance(){
        WebDriver DRIVER = null;

        switch (ProjectProperties.BROWSER) {
            case FIREFOX:
                DRIVER = new FirefoxDriver();
                break;
            case CHROME:
                DRIVER = new ChromeDriver();
                break;
            default:
                DRIVER = new FirefoxDriver();
                break;
        }

        return DRIVER;
    }

}
