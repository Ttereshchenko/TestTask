1)Download project from gitHub - https://github.com/Ttereshchenko/TestTask 

2)For choosing test driver what you need , please change property (BROWSER) in the file - “project.property" (https://github.com/Ttereshchenko/TestTask/blob/master/project.properties) .  
Expected values are:firefox or chrome. 
Please, be sure that you have expected version of browser regarding to the webdriver version and to the selenium version (2.53.0).
Futhermore, check that correct path was set for chromeWebdriver in the WebDriverManager.class - https://github.com/Ttereshchenko/TestTask/blob/master/src/test/java/browsers/WebDriverManager.java 
Most chrome drivers are present in the resources folder (https://github.com/Ttereshchenko/TestTask/tree/master/src/test/resources) (Supports Chrome v52-54).

3)All tests classes are present in tests folder - https://github.com/Ttereshchenko/TestTask/tree/master/src/test/java/tests

4)To run all tests from the tests folder, make right click on testng.xml -> and click Run (https://github.com/Ttereshchenko/TestTask/blob/master/testng.xml)

Automated test cases (3 TC):
[TestMainPage.class]
     * Test Case 1: 
     * - Navigate on main page
     * - Check that help button is present

[TestDeclarationForm]
     * Test Case 1:
     * - Navigate on main page
     * - Go to Declaration page
     * - Try to fill or required fields (texts and checkboxes fields) with correct values (which may be filled)
     * - Check that values were populated correctly and are present.

     * Test Case 2:
     * - Navigate on main page
     * - Go to Declaration page
     * - Try to fill 'Звітний (податковий) період, що уточнюється:' by incorrect value
     * - Check that warning message appear

