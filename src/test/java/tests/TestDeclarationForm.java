package tests;

import org.testng.annotations.Test;
import pages.declaration_page.DeclarationForm;
import pages.declaration_page.DeclarationPage;
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
        // input data
        Map<String, String> requiredTextFields = new HashMap();
        requiredTextFields.put(declarationForm.REPORT_PERIOD_ID, "2014");
        requiredTextFields.put(declarationForm.REPORT_UPDATED_PERIOD_ID, "2015");
        requiredTextFields.put(declarationForm.CHECK_BOXES_RESIDENT_ID, "");
        requiredTextFields.put(declarationForm.CHECK_BOXES_NOT_RESIDENT_ID, "select");
        requiredTextFields.put(declarationForm.CHECK_BOXES_OWN_TAXPAYER_ID, "");
        requiredTextFields.put(declarationForm.CHECK_BOXES_AUTHORIZED_PERSON_ID, "select");
        requiredTextFields.put(declarationForm.CHECK_BOXES_CITIZEN_ID, "");
        requiredTextFields.put(declarationForm.CHECK_BOXES_PROFESSIONAL_ACTIVITY_ID, "select");
        requiredTextFields.put(declarationForm.BOUTH_NAME_ID, "John Alister");
        requiredTextFields.put(declarationForm.PASSPORT_NUMBER_AND_SERIES_ID, "GT262686");
        requiredTextFields.put(declarationForm.ZIP_CODE_ID, "0910");
        requiredTextFields.put(declarationForm.REGION_ID, "Kyiv Region");
        requiredTextFields.put(declarationForm.AREA_ID, "Gold Town");
        requiredTextFields.put(declarationForm.CITY_ID, "Kyiv");
        requiredTextFields.put(declarationForm.STREET_ID, "Gold");
        requiredTextFields.put(declarationForm.BUILD_ID, "23");
        requiredTextFields.put(declarationForm.CORPS_ID, "312");
        requiredTextFields.put(declarationForm.NUMBER_OF_APARTMENTS_ID, "777");
        requiredTextFields.put(declarationForm.TELEPHON_NUMBER_ID, "+8 800 535 342");
        requiredTextFields.put(declarationForm.EMAIL_ID, "Kyiv@gmail.com");
        // bug - can not be populated
        //requiredTextFields.put(declarationForm.NAME_SUPERVISORY_AUTHORITY_ID, "Unated Nationals");
        requiredTextFields.put(declarationForm.NAME_AND_LASTNAME_ID, "John Aister");
        requiredTextFields.put(declarationForm.DATA_OF_FILING,"22022016");

        LOG.info("Try to sent text values in the form");
        for (Map.Entry<String, String> element : requiredTextFields.entrySet()) {
            LOG.info("Try to populate:" + element.getKey());
            declarationForm.populateValue(element.getKey(), element.getValue());
        }
        LOG.info("111");

    }
}
