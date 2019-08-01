package setup;

import constants.PropertiesPath;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class initializes  Properties structure,
 * loads properties in it from file and returns property by key value.
 */
public class TestProperties {
    private Properties currentProps = new Properties();
    private PropertiesPath propertyPath;

    public TestProperties(PropertiesPath path) {
        this.propertyPath = path;
    }

    /**
     * Loads properties from file.
     *
     * @return TestProperties .
     * @throws IOException If path to property file is incorrect.
     */
    public TestProperties loadProperties() throws IOException {
        FileInputStream input = new FileInputStream(propertyPath.getPath());
        currentProps.load(input);
        input.close();
        return this;
    }

    /**
     * Returns property by key.
     *
     * @param value The key of the property to return.
     * @return Property by key.
     * @throws IOException If path to property file loadProperties() is incorrect.
     */
    String getPropertyValue(String value) throws IOException {
        if (!currentProps.containsKey(value)) {
            loadProperties();
        }
        return currentProps.getProperty(value);
    }
}
