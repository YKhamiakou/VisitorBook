package com.ykhamiakou.dao;

import com.ykhamiakou.beans.User;
import com.ykhamiakou.exceptions.AuthenticationException;
import com.ykhamiakou.exceptions.DAOException;

/**
 * DAO for users
 */
public interface IUserDAO {

    /**
     * Add user in database
     *
     * @param username - user's name
     * @param name     - user's login
     * @param password - user's
     */
    void addUser(final String username, final String name, final String password)
            throws DAOException, AuthenticationException, DAOException, AuthenticationException;

    /**
     * Gets some user
     *
     * @param name     - user's login
     * @param password - user's
     * @return - some User
     * @throws DAOException
     * @throws AuthenticationException
     */
    User getUser(String name, String password) throws DAOException, AuthenticationException;

    /**
     * Gets user by id
     *
     * @param userId - user id
     * @return - user
     * @throws DAOException
     */
    User getUserById(int userId) throws DAOException;

}
