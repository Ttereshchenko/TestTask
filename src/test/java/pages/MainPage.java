package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.declarationPage.DeclarationPage;
import utils.WebDriverHelper;

/**
 * Created by doifu_000 on 20.09.2016.
 */
public class MainPage extends AbstractPage {

    private final String URL = "https://cabinet.sfs.gov.ua";

    @FindBy(id = "templ:w1::icon")
    public WebElement fiscalServiceIcon;

    @FindBy(css = "a[id='templ:ptk_l2']")
    public WebElement helpButton;

    @FindBy(xpath = "//a[contains(.,'Декларація про майновий стан')]")
    public WebElement stateDeclarationButton;

    public MainPage(WebDriver driver) {
        super(driver);

    }

    public DeclarationPage navigateToDeclarationPage() {
        stateDeclarationButton.click();
        DeclarationPage declarationPage = new DeclarationPage(driver);
        declarationPage.waitForPage();
        return declarationPage;
    }

    public MainPage navigateTo() {
        LOG.info("Try to navigate on Main page:" + URL);
        driver.get(URL);
        waitForPage();
        return this;
    }

    public void waitForPage() {
        WebDriverHelper.waitForElementVisibility(driver, fiscalServiceIcon, AbstractPage.PAGE_LOADING_TIMEOUT);
    }
}
