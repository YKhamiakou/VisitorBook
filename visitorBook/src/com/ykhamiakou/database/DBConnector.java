package com.ykhamiakou.database;

import com.ykhamiakou.managers.Constants;
import com.ykhamiakou.exceptions.DAOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Data base connection pool
 */
public class DBConnector {
    /**
     * Hided constructor
     */
    private DBConnector() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Close resources
     * 
     * @param autoCloseables
     *            - resources to close
     * @throws DAOException
     */
    public static void closeResource(final AutoCloseable... autoCloseables) throws DAOException {
        try {
            for (final AutoCloseable autoCloseable : autoCloseables) {
                if (autoCloseable != null) {
                    autoCloseable.close();
                }
            }
        } catch (final Exception ex) {
            throw new DAOException("Can't close resource.");
        }
    }

    /**
     * Gets connection to data base
     *
     * @return - connection
     * @throws NamingException
     * @throws SQLException
     */
    public static Connection getConnection() throws NamingException, SQLException {
        final Context context = (Context) new InitialContext().lookup(Constants.CONTEXT);
        final DataSource dataSource = (DataSource) context.lookup(Constants.BASE_NAME);
        return dataSource.getConnection();
    }

}
