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
    public final String REPORT_UPDATED_PERIOD_ID = "HZYP";
    public final String CHECK_BOXES_RESIDENT_ID = "H01";
    public final String CHECK_BOXES_NOT_RESIDENT_ID = "H02";
    public final String CHECK_BOXES_OWN_TAXPAYER_ID= "H03";
    public final String CHECK_BOXES_AUTHORIZED_PERSON_ID = "H04";
    public final String CHECK_BOXES_CITIZEN_ID = "H05";
    public final String CHECK_BOXES_PROFESSIONAL_ACTIVITY_ID = "H06";
    public final String BOUTH_NAME_ID= "HNAME";
    public final String PASSPORT_NUMBER_AND_SERIES_ID = "HTIN";
    public final String ZIP_CODE_ID= "HZIP";
    public final String REGION_ID = "HREG";
    public final String AREA_ID = "HRAJ";
    public final String CITY_ID = "HCITY";
    public final String STREET_ID = "HSTREET";
    public final String BUILD_ID = "HBUILD";
    public final String CORPS_ID = "HCORP";
    public final String NUMBER_OF_APARTMENTS_ID = "HAPT";
    public final String TELEPHON_NUMBER_ID =     "HTEL";
    public final String EMAIL_ID =   "HEMAIL";
    public final String NAME_SUPERVISORY_AUTHORITY_ID = "HSTI";
    public final String NAME_AND_LASTNAME_ID = "HBOS";
    public final String DATA_OF_FILING = "HFILL";
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
