package scenarios.hooks;

import constants.PropertiesPath;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import setup.TestProperties;

import java.io.IOException;
import java.net.MalformedURLException;

import static setup.Driver.*;

/**
 * This class contains setUp and tearDown procedures
 */

public class Hooks {
    /**
     * Loads and reads properties.
     *
     * @throws IOException If path to property file is incorrect.
     */
    @BeforeGroups(description = "Prepare getDriver to run tests", groups = "native")
    public void setUpNative() throws IOException {
        prepareDriverAndSetProperties(PropertiesPath.NATIVE);
    }

    @BeforeGroups(description = "Prepare getDriver to run tests", groups = "web")
    public void setUpWeb() throws IOException {
        prepareDriverAndSetProperties(PropertiesPath.WEB);
    }

    /**
     * Closes getDriver.
     *
     * @throws MalformedURLException if URL needed to get getDriver() is incorrect.
     */
    @AfterSuite(description = "Close getDriver after tests", groups = {"native", "web"})
    public void tearDown() throws MalformedURLException {
        getDriver().close();
    }
    /**
     * Prepare driver
     *
     * @throws IOException If path to property file is incorrect.
     */
    private void prepareDriverAndSetProperties (PropertiesPath path) throws IOException{
        setProperties(new TestProperties(path).loadProperties());
        prepareDriver();
    }
}
