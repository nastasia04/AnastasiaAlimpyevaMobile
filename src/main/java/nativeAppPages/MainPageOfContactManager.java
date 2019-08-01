package nativeAppPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertTrue;

/**
 * This class describes main page of the native app,
 * contains method which clicks at "Add Contact" button
 */
public class MainPageOfContactManager {

    private AppiumDriver driver;
    // fields and buttons on the page
    @AndroidFindBy(id = "com.example.android.contactmanager:id/addContactButton")
    private WebElement addButton;

    public MainPageOfContactManager(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Asserts that "Add button" is visible
     * and click "Add Contact"
     *
     * @return AddContactPage object.
     */
    public AddContactPage clickAddButton() {
        assertTrue(addButton.isDisplayed());
        addButton.click();
        return new AddContactPage(driver);
    }
}
