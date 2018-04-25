package com.ykhamiakou.managers;

/**
 * Class with all application constants
 */
public class Constants {
    /**
     * Page constants
     */
    public static final String PAGE_ENCODING = ConfigurationManager.getProperty("page.encoding");

    /**
     * Data base constants
     */
    public static final String CONTEXT = ConfigurationManager
            .getProperty("base.connector.context");

    public static final String BASE_NAME =  ConfigurationManager
            .getProperty("base.connector.basename");
    /**
     * Page parameters constants
     */
    public static final String LOGIN_PARAM = ConfigurationManager
            .getProperty("params.user.login");
    public static final String USERNAME_PARAM = ConfigurationManager
            .getProperty("params.user.username");
    public static final String PASSWORD_PARAM = ConfigurationManager
            .getProperty("params.user.password");
    public static final String REMEMBER_ME_PARAM = ConfigurationManager
            .getProperty("params.cookie.remember");
    public static final String MESSAGE_TEXT_PARAM = ConfigurationManager
            .getProperty("params.message.text");

    /**
     * Attribute constants
     */
    public static final String ATTRIBUTE_USER = ConfigurationManager
            .getProperty("attribute.user");
    public static final String ATTRIBUTE_INFO = ConfigurationManager
            .getProperty("attribute.info");
    public static final String ATTRIBUTE_MESSAGES = ConfigurationManager
            .getProperty("attribute.messages");

    /**
     * Page constants
     */
    public static final String PAGE_MAIN = ConfigurationManager
            .getProperty("path.page.main");

    /**
     * Servlet constants
     */
    public static final String CONTROLLER_MAIN = ConfigurationManager
            .getProperty("path.controller.main");

    /**
     * Cookie parameters constants
     */
    public static final String USER_ID = ConfigurationManager
            .getProperty("params.user.id");

    public static final String USER_LOGIN = ConfigurationManager
            .getProperty("params.user.login");
    public static final String USER_PASSWORD = ConfigurationManager
            .getProperty("params.user.password");
    /**
     * Cookie attr
     */
    public static final int MAX_COOKIE_AGE = 60 * 60 * 24 * 356;

    public static final int MAX_COOKIE_AGE_DEAD = 0;
    /**
     * Data base queries
     */
    public static final String QUERY_GET_USER = ConfigurationManager
            .getProperty("base.query.getUser");
    public static final String QUERY_GET_USER_BY_LOGIN = ConfigurationManager
            .getProperty("base.query.getUserByLog");

    public static final String QUERY_GET_USER_BY_ID = ConfigurationManager
            .getProperty("base.query.getUserById");
    public static final String QUERY_ADD_USER = ConfigurationManager
            .getProperty("base.query.addUser");
    public static final String QUERY_GET_MESSAGES = ConfigurationManager
            .getProperty("base.query.getMessages");
    public static final String QUERY_ADD_MESSAGE = ConfigurationManager
            .getProperty("base.query.addMessage");

    /**
     * Users table columns
     */
    public static final String COLUMN_USER_NAME = ConfigurationManager
            .getProperty("base.columns.user.login");
    public static final String COLUMN_USER_PASS = ConfigurationManager
            .getProperty("base.columns.user.pass");
    public static final String COLUMN_USER_ID = ConfigurationManager
            .getProperty("base.columns.user.id");
    public static final String COLUMN_USER_USERNAME = ConfigurationManager
            .getProperty("base.columns.user.username");

    /**
     * Task table columns
     */
    public static final String COLUMN_MESSAGE_ID = ConfigurationManager
            .getProperty("base.columns.message.id");
    public static final String COLUMN_MESSAGE_OWNER = ConfigurationManager
            .getProperty("base.columns.message.owner");
    public static final String COLUMN_MESSAGE_TEXT = ConfigurationManager
            .getProperty("base.columns.message.text");

    /**
     * Exception messages
     */
    public static final String AUTHENTICATION_EXCEPTION = MessageManager
            .getProperty("message.loginerror");

    public static final String LOGGED_OUT_EXCEPTION = MessageManager
            .getProperty("message.loggedout");
    public static final String USER_EXISTS = MessageManager
            .getProperty("message.userexists");
    public static final String MESSAGE_SOMETHING_WENT_WRONG = MessageManager
            .getProperty("message.smthwentwrong");
    public static final String COOKIES_EXCEPTION = MessageManager
            .getProperty("message.cookiesexception");


    /**
     * Hided constructor
     */
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

}
