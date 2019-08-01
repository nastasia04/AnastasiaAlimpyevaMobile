package nativeAppPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.Assert.assertNotNull;

/**
 * This class describes addContact page in the app,
 * contains asserts for visible fields and buttons
 */
public class AddContactPage {
    private AppiumDriver driver; //!

    public AddContactPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // fields and buttons on the page
    @AndroidFindBy(id = "com.example.android.contactmanager:id/accountSpinner")
    private WebElement targetAccountField;
    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactNameEditText")
    private WebElement contactNameField;
    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneEditText")
    private WebElement contactPhoneField;
    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactEmailEditText")
    private WebElement contactEmailField;

    /**
     * Assert that "Target Account" field is visible
     *
     * @return AddContactPage object.
     */
    public AddContactPage checkTargetAccountFieldIsVisible() {
        assertTrue("Target account field isn't displayed", targetAccountField.isDisplayed());
        return this;
    }

    /**
     * Assert that "Contact Name" field is visible
     *
     * @return AddContactPage object.
     */
    public AddContactPage checkContactNameFieldIsVisible() {
        assertTrue("Contact name field isn't displayed", contactNameField.isDisplayed());
        return this;
    }

    /**
     * Assert that "Contact Phone" field is visible
     *
     * @return AddContactPage object.
     */
    public AddContactPage checkContactPhoneFieldIsVisible() {
        assertTrue("Contact phone field isn't displayed", contactPhoneField.isDisplayed());
        return this;
    }

    /**
     * Asserts that "Contact Email" field is visible
     *
     * @return AddContactPage object.
     */
    public AddContactPage checkContactEmailFieldIsVisible() {
        assertTrue("Contact email field isn't displayed",contactEmailField.isDisplayed());
        return this;
    }

    /**
     * Asserts that keyboard pops up
     *
     * @return AddContactPage object.
     */
    @SuppressWarnings("UnusedReturnValue")
    public AddContactPage checkKeyboardIsVisible() {
        assertNotNull(driver.getKeyboard(), "Keyboard isn't displayed");
        return this;
    }
}
