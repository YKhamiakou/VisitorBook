package com.ykhamiakou.dao;

import com.ykhamiakou.managers.Constants;
import com.ykhamiakou.beans.Message;
import com.ykhamiakou.database.DBConnector;
import com.ykhamiakou.exceptions.DAOException;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseMessageDAO implements IMessageDAO {
    /**
     * Constants
     */
    private static final int ADD_OWNER_PLACE = 1;
    private static final int ADD_TEXT_PLACE = 2;

    /**
     * Get all the messages from base
     *
     * @return - list of messages
     * @throws DAOException
     */
    @Override
    public List<Message> getMessages() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Message> messages = null;
        try {
            messages = new ArrayList<>();
            connection = DBConnector.getConnection();
            statement = connection.prepareStatement(Constants.QUERY_GET_MESSAGES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final int id = resultSet.getInt(Constants.COLUMN_MESSAGE_ID);
                final int ownerId = resultSet.getInt(Constants.COLUMN_MESSAGE_OWNER);
                final String text = resultSet.getString(Constants.COLUMN_MESSAGE_TEXT);
                messages.add(new Message(id, UserDAOFactory.getClassFromFactory().getUserById(ownerId), text));
            }
            return messages;
        } catch (NamingException | SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            DBConnector.closeResource(resultSet, statement, connection);
        }
    }

    /**
     * Add some message to base
     *
     * @param message - message to add
     * @throws DAOException
     */
    @Override
    public void addMessage(Message message) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBConnector.getConnection();
            statement = connection.prepareStatement(Constants.QUERY_ADD_MESSAGE);
            statement.setInt(DataBaseMessageDAO.ADD_OWNER_PLACE, message.getOwner().getId());
            statement.setString(DataBaseMessageDAO.ADD_TEXT_PLACE, message.getText());
            synchronized (this) {
                statement.execute();
            }
        } catch (NamingException | SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            DBConnector.closeResource(statement, connection);
        }
    }
}
