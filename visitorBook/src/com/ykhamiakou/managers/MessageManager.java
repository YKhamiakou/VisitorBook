package com.ykhamiakou.managers;

import java.util.ResourceBundle;

/**
 * Class for managing messages from properties
 */
public class MessageManager {
    /**
     * Fields
     */
    private static final ResourceBundle resourceBundle = ResourceBundle
            .getBundle("com.ykhamiakou.managers.messages");

    /**
     * No-arg constructor
     */
    private MessageManager() {
    }

    /**
     * Takes information from file
     *
     * @param key
     *            - key for parameters
     * @return - parameter
     */
    public static String getProperty(final String key) {
        return MessageManager.resourceBundle.getString(key);
    }
}
