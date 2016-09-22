package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

/**
 * Created by doifu_000 on 20.09.2016.
 */
public abstract class AbstractPage implements PageInterface {
    public static final Logger LOG = Logger.getLogger(AbstractPage.class.getName());

    public static final long PAGE_LOADING_TIMEOUT = 10;
    public static final long TIMEOUT = 2;
    public static final long ELEMENT_APPEAR_TIMEOUT = 5;
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        init();
    }

    protected void init() {
        PageFactory.initElements(driver, this);
    }

}
