package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by doifu_000 on 20.09.2016.
 */
public class StartPage extends AbstractPage {

    @FindBy(xpath = "//xhtml:input[@id='searchSubmit']")
    public WebElement searchButton;

    private String url = "https://cabinet.sfs.gov.ua/";

    public StartPage(WebDriver driver){
        super(driver);
    }

    public void waitForPage(){  //WebElement explicitWait=
        init();
        (new WebDriverWait(driver,TimeToWait))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.valueOf(searchButton))));
    }

    public MainPage getStartPage(WebDriver driver){
        driver.get(url);
        return new MainPage(driver);
    }


}
