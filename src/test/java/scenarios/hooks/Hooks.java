package scenarios.hooks;

import constants.PropertiesPath;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.TestProperties;

import java.io.IOException;
import java.net.MalformedURLException;

import static setup.Driver.*;

/**
 * This class contains setUp and tearDown procedures
 */

public class Hooks {
    private PropertiesPath path;

    public Hooks(PropertiesPath path) {
        this.path = path;
    }

    /**
     * Loads and reads properties.
     *
     * @throws IOException If path to property file is incorrect.
     */
    @BeforeSuite(description = "Prepare getDriver to run tests")
    public void setUp() throws IOException {
        setProperties(new TestProperties(path).loadProperties());
        prepareDriver();
    }

    /**
     * Closes getDriver.
     *
     * @throws MalformedURLException if URL needed to get getDriver() is incorrect.
     */
    @AfterSuite(description = "Close getDriver after tests")
    public void tearDown() throws MalformedURLException {
        getDriver().close();
    }
}
