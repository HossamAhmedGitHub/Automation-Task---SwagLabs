package com.saucedemo.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProductionConfigUtils {
    private static final String CONFIG_PATH ="src/test/java/com/saucedemo/ProductionConfig/config.properties";
    private static final String ENVIRONMENT_PATH ="src/test/java/com/saucedemo/ProductionConfig/environment.properties";

    public static String getConfigValue( String key) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(CONFIG_PATH ));
            return properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Error while loading config Value");
        }
    }//end getConfigValue() method

    public static String getEnvironmentPropertyValue(String key) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(ENVIRONMENT_PATH));
            return properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Error while loading Environment Value");
        }

    }



}
