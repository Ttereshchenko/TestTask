package utils;

import browsers.WebDriverManager;

import java.io.FileReader;
import java.util.Properties;

/**
 * Created by doifu_000 on 9/21/16.
 */
@SuppressWarnings("ALL")
public class ProjectProperties {
    public static final String PROPERTIES_FILENAME = "project.properties";
    public static final Properties properties = loadProperties(PROPERTIES_FILENAME);
    public static final WebDriverManager.Browsers BROWSER = WebDriverManager.Browsers.getBrowser(properties.getProperty("BROWSER"));


    public static Properties loadProperties(String file) {
        Properties properties = new Properties();
        try {
            FileReader fr = new FileReader(file);
            properties.load(fr);
        } catch (Exception e) {
            throw new RuntimeException("Exception In ProjectProperties.loadProperties():" + e.getMessage(), e);
        }
        return properties;
    }
}
