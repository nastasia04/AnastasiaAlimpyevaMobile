package scenarios.nativeTest;

import nativeAppPages.MainPageOfContactManager;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static setup.Driver.getDriver;

/**
 * Tests for native application.
 */
@Test(groups = "native")
public class SimpleNativeTest {

    /**
     * Clicks "Add contact" and checks if form is opened
     * and all needed elements are present.
     *
     * @throws MalformedURLException If URL needed to get getDriver() is incorrect.
     */
    @Test(description = "Click 'Add Contact' and check result")
    public void nativeTest() throws MalformedURLException {
        new MainPageOfContactManager(getDriver())
                .clickAddButton()
                .checkTargetAccountFieldIsVisible()
                .checkContactNameFieldIsVisible()
                .checkContactPhoneFieldIsVisible()
                .checkContactEmailFieldIsVisible()
                .checkKeyboardIsVisible();
    }
}
