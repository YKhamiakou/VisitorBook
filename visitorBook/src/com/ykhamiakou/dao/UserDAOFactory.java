package com.ykhamiakou.dao;

/**
 * Factory for user DAO
 */
public class UserDAOFactory {
    /**
     * Hided constructor
     */
    private UserDAOFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Factory method
     *
     * @return DAO instance
     */
    public static IUserDAO getClassFromFactory() {
        return new DataBaseUserDAO();
    }
}
