package test.java.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigProperties {

    private FileReader reader;
    private static Properties properties = new Properties();
    private static final Logger logger = Logger.getLogger("ConfigProperties");
    public ConfigProperties() {
        readPropertiesFile();
        loadProperties();
    }

    private void readPropertiesFile() {
        logger.info("Reading properties file");
        try {
            reader = new FileReader("resources/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadProperties() {
        logger.info("Loading properties");
        try {
            properties.load(reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        logger.info("Getting property: " + key);
        return properties.getProperty(key);
    }

}
