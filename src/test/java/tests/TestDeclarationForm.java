package tests;

import org.testng.annotations.Test;
import pages.declarationPage.DeclarationForm;
import pages.declarationPage.DeclarationPage;
import pages.MainPage;
import utils.UITestSetup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doifu_000  on 9/22/16.
 */
public class TestDeclarationForm extends UITestSetup {

    @Test
    public void test000_fillRequiredFields() {

        MainPage mainPage = new MainPage(getDRIVER());
        mainPage = mainPage.navigateTo();
        DeclarationPage declarationPage = mainPage.navigateToDeclarationPage();
        DeclarationForm declarationForm = declarationPage.switchToForm();

        declarationForm.populateValue(declarationForm.REPORT_PERIOD_ID, "2012");

        // input data
        Map<String, String> requiredTextFields = new HashMap();
        requiredTextFields.put(declarationForm.REPORT_PERIOD_ID, "2014");
        //
        LOG.info("Try to sent text values in the form");
        for (Map.Entry<String, String> element : requiredTextFields.entrySet()) {
            LOG.info("Try to populate:" + element.getKey());
            declarationForm.populateValue(element.getKey(), element.getValue());
        }
        LOG.info("111");

    }
}
