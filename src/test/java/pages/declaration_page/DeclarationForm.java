package pages.declaration_page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.WebDriverHelper;

/**
 * Created by doifu on 9/22/16.
 */
public class DeclarationForm extends AbstractPage {
    private final String idInputPrefix = "0_";

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


    DeclarationForm(WebDriver driver) {
        super(driver);
    }

    public enum InputType {
        TEXT("text"),
        CHECKBOX("checkbox");

        private String name;

        InputType(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public static InputType getInputType(String name) {
            for (InputType type : InputType.values()) {
                if (type.getName().equalsIgnoreCase(name))
                    return type;
            }
            throw new RuntimeException("Can not find a type!");
        }
    }

    public void waitForPage() {
        WebDriverHelper.waitForElementVisibility(driver, title, AbstractPage.PAGE_LOADING_TIMEOUT);
    }

    @SuppressWarnings("Since15")
    public void populateValue(String id, String value) {
        InputType type = getInputType(id);
        WebElement element = WebDriverHelper.findElementByID(driver, idInputPrefix + id, AbstractPage.ELEMENT_APPEAR_TIMEOUT);
        switch (type) {
            case TEXT: {
                element.clear();
                element.sendKeys(value);
                element.sendKeys(Keys.ENTER);
                break;
            }
            case CHECKBOX: {
                boolean isSelected = element.isSelected();
                // expected value = not selected (empty) , but checkbox is selected
                if(value.isEmpty()&&isSelected) {
                    element.click();
                }
                // expected value = selected ( not empty) , but checkbox is not selected
                else if((!value.isEmpty()&&!isSelected)) {
                    element.click();
                }
                // need to change focus for processing checkbox value
                changeFocus();
                break;
            }
            default: {
                throw new RuntimeException("Can not parse type of input!");
            }
        }
    }

    /**
     * Get input field type
     * @param id
     * @return InputType
     */
    public InputType getInputType (String id) {
        WebElement element = WebDriverHelper.findElementByID(driver, id, AbstractPage.ELEMENT_APPEAR_TIMEOUT);
        element.click();
        element = WebDriverHelper.findElementByID(driver, idInputPrefix + id, AbstractPage.ELEMENT_APPEAR_TIMEOUT);
        String type = element.getAttribute("type");
        LOG.info("Type attribute:" + type);
        return InputType.getInputType(type);
    }

    /**
     * Change focus on 'Звітний (податковий) період:' input field
     */
    public void changeFocus() {
        WebElement elementForFocus = WebDriverHelper.findElementByID(driver, REPORT_PERIOD_ID, AbstractPage.ELEMENT_APPEAR_TIMEOUT);
        elementForFocus.click();
        elementForFocus = WebDriverHelper.findElementByID(driver, idInputPrefix + REPORT_PERIOD_ID, AbstractPage.ELEMENT_APPEAR_TIMEOUT);
        elementForFocus.sendKeys(Keys.ENTER);
    }
}
