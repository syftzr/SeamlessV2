package com.seamless.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

    static {
        try {
            FileInputStream input = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }








    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }


}