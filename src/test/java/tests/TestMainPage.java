package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.UITestSetup;

/**
 * Created by doifu_000 on 9/21/16.
 */
public class TestMainPage extends UITestSetup {
    /**
     * Test Case 1:
     * - Navigate on main page
     * - Check that help button is present
     */
    @Test
    public void test000_CheckLoginToAcountPresent() {
        MainPage mainPage = new MainPage(getDRIVER());
        mainPage = mainPage.navigateTo();
        Assert.assertTrue(mainPage.helpButton.isDisplayed(), "Button 'Допомога' is not present!");
    }
}
