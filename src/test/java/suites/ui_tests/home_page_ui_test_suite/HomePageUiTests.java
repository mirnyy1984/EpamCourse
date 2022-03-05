package suites.ui_tests.home_page_ui_test_suite;

import annotations.TestType;
import org.testng.annotations.Test;
import suites.ui_tests.UiTest;

public class HomePageUiTests extends UiTest {

    @TestType(testType = "ui", testDescription = "test verify home page title")
    @Test
    public void test_1_checkPageTitle() {
        homePage.checkPageTitle();
    }


    @TestType(testType = "ui", testDescription = "test verify home page main block links")
    @Test
    public void test_2_checkMainBlockLinksCount() {
        homePage.checkMainBlockLinksCount();
    }
}
