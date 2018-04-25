package com.ykhamiakou.managers;

import java.util.ResourceBundle;

/**
 * Class for managing configuration from properties
 */
public class ConfigurationManager {
    /**
     * Fields
     */
    private static final ResourceBundle resourceBundle = ResourceBundle
            .getBundle("com.ykhamiakou.managers.config");

    /**
     * No-arg constructor
     */
    private ConfigurationManager() {
    }

    /**
     * Takes information from file
     *
     * @param key
     *            - key for parameters
     * @return - parameter
     */
    public static String getProperty(final String key) {
        return ConfigurationManager.resourceBundle.getString(key);
    }
}
