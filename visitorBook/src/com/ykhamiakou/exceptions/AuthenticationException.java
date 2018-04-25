package com.ykhamiakou.exceptions;

/**
 * Exception for wrong authentication
 */
public class AuthenticationException extends Exception {
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
    public AuthenticationException(final String message) {
        super(message);
    }

}
