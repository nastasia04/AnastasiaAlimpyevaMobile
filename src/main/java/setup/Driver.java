package setup;

import constants.PlatformsAndBrowsers;
import constants.PropertyKeyWords;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;

/**
 * This class initializes an AppiumDriver object which act as singletons and
 * sets properties to use getDriver capabilities.
 */
public class Driver implements PlatformsAndBrowsers, PropertyKeyWords {
    private static AppiumDriver driverSingleton;
    private static WebDriverWait waitSingleton;

    // Properties to be set
    public static String SUT;
    public static String BROWSER_TITLE;
    private static String AUT;
    private static String TEST_PLATFORM;
    private static String DRIVER;
    private static String DEVICE;
    private static String DEVICE_UDID;
    private static String APP_ACTIVITY;
    private static String APP_PACKAGE;


    private Driver() {
    }

    /**
     * Reads properties from TestProperties and assigns them to static fields
     * of this class
     *
     * @param properties TestProperties - contains data for getDriver capabilities.
     * @throws IOException If path to file is incorrect.
     */
    public static void setProperties(TestProperties properties) throws IOException {
        AUT = properties.getPropertyValue(AUT_KEY);
        SUT = properties.getPropertyValue(SUT_KEY);
        TEST_PLATFORM = properties.getPropertyValue(PLATFORM_KEY);
        DRIVER = properties.getPropertyValue(DRIVER_KEY);
        DEVICE = properties.getPropertyValue(DEVICE_KEY);
        BROWSER_TITLE = properties.getPropertyValue(BROWSER_TITLE_KEY);
        DEVICE_UDID = properties.getPropertyValue(DEVICE_UDID_KEY);
        APP_ACTIVITY = properties.getPropertyValue(APP_ACTIVITY_KEY);
        APP_PACKAGE = properties.getPropertyValue(APP_PACKAGE_KEY);
    }

    /**
     * Initializes getDriver which depends on the platform and application type.
     *
     * @throws MalformedURLException If URL needed to instantiate getDriver is incorrect.
     */
    public static void prepareDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browserName;
        // Setup test platform:
        switch (TEST_PLATFORM) {
            case ANDROID:
                browserName = CHROME;
                break;
            case IOS:
                browserName = SAFARI;
                break;
            default:
                throw new IllegalArgumentException("Unknown mobile platform: " + TEST_PLATFORM);
        }
        capabilities.setCapability(UDID, DEVICE_UDID);
        capabilities.setCapability(PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application
        if (AUT != null && SUT == null) {
            capabilities.setCapability(MobileCapabilityType.APP, new File(AUT).getAbsolutePath());
            capabilities.setCapability("appActivity", APP_ACTIVITY);
            capabilities.setCapability("appPackage", APP_PACKAGE);
            // Native:
        } else if (SUT != null && AUT == null) {
            // Web:
            capabilities.setCapability(BROWSER_NAME, browserName);
        } else {
            throw new IllegalArgumentException("Unknown type of mobile app");
        }

        // Init getDriver for local Appium server with set capabilities
        driverSingleton = new AppiumDriver(new URL(DRIVER), capabilities);
        // Set an object to handle timeouts
        if(waitSingleton == null) {
            waitSingleton = new WebDriverWait(driverSingleton, 20);
        }
    }

    /**
     * If AppiumDriver isn't initialized, method initializes it.
     *
     * @return Initialized getDriver.
     * @throws MalformedURLException If URL needed to prepareDriver() is incorrect.
     */
    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driverSingleton == null) prepareDriver();
        return driverSingleton;
    }

    /**
     *  Set an object to handle timeouts
     *
     * @return Initialized WebDriverWait field.
     */
    public static WebDriverWait driverWait() {
        return waitSingleton;
    }

}
