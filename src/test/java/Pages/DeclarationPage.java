package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by doifu_000 on 20.09.2016.
 */
public class DeclarationPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'Декларація про майновий стан')]")
    public WebElement expectedText;

    public DeclarationPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPage(){
        init();
        (new WebDriverWait(driver,TimeToWait))
                .until(ExpectedConditions.textToBe(By.xpath(String.valueOf(expectedText)),"Декларація про майновий стан"));
        Assert.assertEquals("Декларація про майновий стан",expectedText);
    }//need to remake this method!

}
