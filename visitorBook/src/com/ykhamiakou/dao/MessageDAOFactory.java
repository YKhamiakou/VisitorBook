package com.ykhamiakou.dao;

/**
 * Factory for messages
 */
public class MessageDAOFactory {
    /**
     * Hided constructor
     */
    private MessageDAOFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Factory method
     *
     * @return DAO instance
     */
    public static IMessageDAO getClassFromFactory() {
        return new DataBaseMessageDAO();
    }
}
