package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This enum contains constants of possible paths of properties.
 */
@AllArgsConstructor
@Getter
public enum PropertiesPath {
    WEB("src/test/resources/properties/webTest.properties"),
    NATIVE("src/test/resources/properties/nativeTest.properties");

    final String path;
}
