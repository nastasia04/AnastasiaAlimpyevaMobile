package scenarios.webTest;

import constants.PropertiesPath;
import org.testng.annotations.Test;
import scenarios.hooks.Hooks;
import webAppPages.MainPage;

import static setup.Driver.*;

/**
 * Tests for web application.
 */
public class SimpleWebTest extends Hooks {

    public SimpleWebTest() {
        super(PropertiesPath.WEB);
    }

    /**
     * Opens website and checks that website is successfully opened.
     *
     * @throws Exception If HttpConnection is incorrect and
     * if URL needed to get getDriver() is incorrect.
     */
    @Test(description = "Opens website and asserts it is opened")
    public void webTest() throws Exception {
        new MainPage(getDriver())
                .openPage(SUT)
                .checkPageIsOpened(BROWSER_TITLE)
                .checkPageStatusCode();
    }
}
