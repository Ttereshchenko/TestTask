package pages.declaration_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.WebDriverHelper;

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

    @FindBy(xpath = "//span[contains(text(),'Декларація про майновий стан')]")
    public WebElement title;

    //
    @FindBy(css = "iframe[id='templ:r1:0:iffarmeData::f']")
    public WebElement iframe;


    public DeclarationPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPage() {
        WebDriverHelper.waitNextAction(driver, PAGE_LOADING_TIMEOUT);
        title.isDisplayed();
    }

    public DeclarationForm switchToForm() {
        WebDriverHelper.waitNextAction(driver, ELEMENT_APPEAR_TIMEOUT);
        driver = driver.switchTo().frame(iframe);
        DeclarationForm declarationForm = new DeclarationForm(driver);
        declarationForm.waitForPage();
        return declarationForm;
    }

}