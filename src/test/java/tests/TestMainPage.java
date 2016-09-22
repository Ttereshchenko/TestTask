package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.UITestSetup;

/**
 * Created by doifu_000 on 9/21/16.
 */
public class TestMainPage extends UITestSetup {
    @Test
    public void test000_CheckLoginToAcountPresent() {
        MainPage mainPage = new MainPage(getDRIVER());
        mainPage = mainPage.navigateTo();
        Assert.assertTrue("Button 'Допомога' is not present!", mainPage.helpButton.isDisplayed());

    }
}
