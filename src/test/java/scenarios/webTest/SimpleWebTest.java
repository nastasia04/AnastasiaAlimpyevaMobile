package scenarios.webTest;

import org.testng.annotations.Test;
import webAppPages.MainPage;

import static setup.Driver.*;

/**
 * Tests for web application.
 */
@Test(groups = "web")
public class SimpleWebTest  {

    /**
     * Opens website and checks that website is successfully opened.
     *
     * @throws Exception If HttpConnection is incorrect and
     * if URL needed to get getDriver() is incorrect.
     */
    @Test(description = "Opens website and asserts it is opened")
    public void     webTest() throws Exception {
        new MainPage(getDriver())
                .openPage(SUT)
                .checkPageIsOpened(BROWSER_TITLE)
                .checkPageStatusCode();
    }
}
