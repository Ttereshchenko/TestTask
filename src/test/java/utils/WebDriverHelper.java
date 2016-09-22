package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by doifu_000 on 9/21/16.
 */
public class WebDriverHelper{
    private WebDriverHelper() {}

    public static void waitForElementVisibility(final WebDriver webDriver, final WebElement webElement, final long timeOutSeconds) {
        new WebDriverWait(webDriver, timeOutSeconds).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForURL(final WebDriver webDriver, final String url, final long timeOutSeconds) {
        new WebDriverWait(webDriver, timeOutSeconds).until(ExpectedConditions.urlToBe(url));
    }
    public static void waitForURLContain(final WebDriver webDriver, final String url, final long timeOutSeconds) {
        new WebDriverWait(webDriver, timeOutSeconds).until(ExpectedConditions.urlContains(url));
    }

    public static void waitNextAction(final WebDriver webDriver, final long timeOutSeconds) {
        webDriver.manage().timeouts().implicitlyWait(timeOutSeconds, SECONDS);
    }
}
