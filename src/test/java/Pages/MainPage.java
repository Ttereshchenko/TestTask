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
public class MainPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'Головна')]")
    public WebElement mainText;
    @FindBy(xpath = "//span[contains(text(),'Декларація про майновий стан']")
    public WebElement buttonText;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public DeclarationPage getDeclarationPage(WebDriver driver) {
        buttonText.click(); // maybe here mistake! need check
        return new DeclarationPage(driver);
    }

    public void waitForPage() {
        init();
        (new WebDriverWait(driver, TimeToWait))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.valueOf(mainText))));

    }
}
