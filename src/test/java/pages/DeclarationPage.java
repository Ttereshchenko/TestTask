package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by doifu_000 on 20.09.2016.
 */
public class DeclarationPage extends AbstractPage {


/*
    @FindBy(xpath = "//span[contains(text(),'Декларація про майновий стан')]")
    public WebElement expectedText;
    @FindBy(xpath = "//*[@id='HZY']")
    public WebElement stepTwo;
    @FindBy(xpath = "//*[@id='HZYP']")
    public WebElement StepTwoUpDated;
    @FindBy (xpath = "//*[@id='HNAME']")
    WebElement stepThree;
    @FindBy (xpath = "//*[@id='HTIN']")
    WebElement stepThree2;
    @FindBy (xpath = "//*[@id='HREG']")
    WebElement stepFour1;
    @FindBy (xpath = "//*[@id='HRAJ']")
    WebElement stepFour2;
    @FindBy (xpath = "")
    WebElement

*/






    public DeclarationPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPage() {
        init();
        (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.textToBe(By.xpath(String.valueOf(expectedText)), "Декларація про майновий стан"));
        Assert.assertEquals("Декларація про майновий стан", expectedText);
    }//need to remake this method!

}
