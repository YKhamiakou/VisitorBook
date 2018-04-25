package com.ykhamiakou.exceptions;

/**
 * Exception for DAO
 */
public class DAOException extends Exception {
    /**
     * Serial version
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with args
     * 
     * @param message
     *            - exception message
     */
    public DAOException(final String message) {
        super(message);
    }

}
