package com.ykhamiakou.dao;

import com.ykhamiakou.managers.Constants;
import com.ykhamiakou.beans.User;
import com.ykhamiakou.database.DBConnector;
import com.ykhamiakou.exceptions.AuthenticationException;
import com.ykhamiakou.exceptions.DAOException;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Dao for users in database
 */
public class DataBaseUserDAO implements IUserDAO {
    /**
     * Constants
     */
    private static final int USER_NAME_PLACE = 1;
    private static final int LOGIN_PLACE = 2;
    private static final int PASS_PLACE = 3;
    private static final int ID_PLACE = 1;
    private static final int NO_NAME_LOGIN_PLACE = 1;
    private static final int NO_NAME_PASS_PLACE = 2;

    /**
     * Add user in database
     *
     * @param name     - user's name
     * @param password - user's
     */
    @Override
    public void addUser(final String username, final String name, final String password)
            throws DAOException, AuthenticationException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            synchronized (this) {
                if (this.findUser(name) == null) {
                    connection = DBConnector.getConnection();
                    statement = connection.prepareStatement(Constants.QUERY_ADD_USER);
                    statement.setString(DataBaseUserDAO.USER_NAME_PLACE, username);
                    statement.setString(DataBaseUserDAO.LOGIN_PLACE, name);
                    statement.setString(DataBaseUserDAO.PASS_PLACE, password);
                    statement.execute();
                } else {
                    throw new AuthenticationException(Constants.USER_EXISTS);
                }
            }
        } catch (NamingException | SQLException ex) {
            throw new DAOException(ex.getMessage());
        } finally {
            DBConnector.closeResource(statement, connection);
        }
    }

    /**
     * Gets some user from database table
     *
     * @param name     - user's login
     * @param password - user's
     * @return - some User
     * @throws DAOException
     * @throws AuthenticationException
     */
    @Override
    public User getUser(final String name, final String password)
            throws DAOException, AuthenticationException {
        try {
            final User user = this.findUser(name, password);
            if (user != null) {
                return user;
            } else {
                throw new AuthenticationException(Constants.AUTHENTICATION_EXCEPTION);
            }
        } catch (NamingException | SQLException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    /**
     * Gets user by id
     *
     * @param userId - user id
     * @return - user
     * @throws DAOException
     */
    @Override
    public User getUserById(final int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnector.getConnection();
            statement = connection.prepareStatement(Constants.QUERY_GET_USER_BY_ID);
            statement.setInt(DataBaseUserDAO.ID_PLACE, userId);
            resultSet = statement.executeQuery();
            if (resultSet.first()) {
                return new User(resultSet.getInt(Constants.COLUMN_USER_ID),
                        resultSet.getString(Constants.COLUMN_USER_USERNAME),
                        resultSet.getString(Constants.COLUMN_USER_NAME),
                        resultSet.getString(Constants.COLUMN_USER_PASS));
            }
            return null;
        } catch (SQLException | NamingException ex) {
            throw new DAOException(ex.getMessage());
        } finally {
            DBConnector.closeResource(statement, resultSet, connection);
        }
    }

    /**
     * Gets some user from database table
     *
     * @param name - user's name
     * @return - some User
     * @throws SQLException
     * @throws NamingException
     * @throws DAOException
     */
    private User findUser(final String name) throws NamingException, SQLException, DAOException {
        ResultSet result = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBConnector.getConnection();
            statement = connection.prepareStatement(Constants.QUERY_GET_USER_BY_LOGIN);
            statement.setString(DataBaseUserDAO.NO_NAME_LOGIN_PLACE, name);
            result = statement.executeQuery();
            if (result.first()) {
                return new User(result.getInt(Constants.COLUMN_USER_ID),
                        result.getString(Constants.COLUMN_USER_USERNAME),
                        result.getString(Constants.COLUMN_USER_NAME),
                        result.getString(Constants.COLUMN_USER_PASS));
            }
            return null;
        } finally {
            DBConnector.closeResource(statement, result, connection);
        }
    }

    /**
     * Gets some user from database table
     *
     * @param name     - user's name
     * @param password - user's pass
     * @return - some User
     * @throws SQLException
     * @throws NamingException
     * @throws DAOException
     */
    private User findUser(final String name, final String password)
            throws NamingException, SQLException, DAOException {
        ResultSet result = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBConnector.getConnection();
            statement = connection.prepareStatement(Constants.QUERY_GET_USER);
            statement.setString(DataBaseUserDAO.NO_NAME_LOGIN_PLACE, name);
            statement.setString(DataBaseUserDAO.NO_NAME_PASS_PLACE, password);
            result = statement.executeQuery();
            if (result.first()) {
                return new User(result.getInt(Constants.COLUMN_USER_ID),
                        result.getString(Constants.COLUMN_USER_USERNAME),
                        result.getString(Constants.COLUMN_USER_NAME),
                        result.getString(Constants.COLUMN_USER_PASS));
            }
            return null;
        } finally {
            DBConnector.closeResource(statement, result, connection);
        }
    }

}
