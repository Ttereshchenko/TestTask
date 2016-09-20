package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by doifu_000 on 20.09.2016.
 */
public abstract class AbstractPage implements PageInterface {

    protected final static int TimeToWait = 5;
    WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver=driver;
    }

    protected void init(){
        PageFactory.initElements(driver,this);
    }

}
