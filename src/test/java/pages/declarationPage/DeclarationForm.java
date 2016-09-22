package pages.declarationPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.WebDriverHelper;

/**
 * Created by slava on 9/22/16.
 */
public class DeclarationForm extends AbstractPage {

    public final String REPORT_PERIOD_ID = "HZY";
    @FindBy(xpath = "//table[contains(@class,'tmplInnerTbl')]//*[contains(text(), 'ПОДАТКОВА ДЕКЛАРАЦІЯ ПРО МАЙНОВИЙ СТАН І ДОХОДИ')]")
    public WebElement title;




    String xpathPattern = "//*[@id='%s']";
    String idInputPrefix = "0_";

    DeclarationForm(WebDriver driver) {
        super(driver);
    }

    public void waitForPage() {
        WebDriverHelper.waitForElementVisibility(driver, title, AbstractPage.PAGE_LOADING_TIMEOUT);
    }

    public void populateValue(String id, String text) {
        String xpath = String.format(xpathPattern, REPORT_PERIOD_ID);
        WebElement element = WebDriverHelper.findElementByXpath(driver, xpath, AbstractPage.ELEMENT_APPEAR_TIMEOUT);
        element.click();
        xpath = String.format(xpathPattern, idInputPrefix + REPORT_PERIOD_ID);
        element = WebDriverHelper.findElementByXpath(driver, xpath, AbstractPage.ELEMENT_APPEAR_TIMEOUT);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }
}
