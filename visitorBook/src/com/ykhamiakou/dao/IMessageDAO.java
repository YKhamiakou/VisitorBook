package com.ykhamiakou.dao;

import com.ykhamiakou.beans.Message;
import com.ykhamiakou.exceptions.DAOException;

import java.util.List;

/**
 * DAO for messages
 */
public interface IMessageDAO {

    /**
     * Get all the messages
     *
     * @return - list of messages
     * @throws DAOException
     */
    List<Message> getMessages() throws DAOException;

    /**
     * Add some message
     *
     * @param message - message to add
     * @throws DAOException
     */
    void addMessage(Message message)throws DAOException;
}
