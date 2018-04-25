package com.ykhamiakou.managers;

import com.ykhamiakou.beans.User;
import com.ykhamiakou.dao.UserDAOFactory;
import com.ykhamiakou.exceptions.AuthenticationException;
import com.ykhamiakou.exceptions.DAOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class for utility methods
 */
public class UserUtils {
    /**
     * Constants
     */
    private static final String EMPTY = "";

    /**
     * Hided constructor
     */
    private UserUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Delete current cookies
     *
     * @param response
     *            - http response
     */
    public static final void deleteCookies(final HttpServletResponse response) {
        final Cookie idCookie = new Cookie(Constants.USER_ID, UserUtils.EMPTY);
        idCookie.setMaxAge(Constants.MAX_COOKIE_AGE_DEAD);
        idCookie.setSecure(true);

        response.addCookie(idCookie);
    }

    /**
     * Gets user from current cookies
     *
     * @param request
     *            - http request
     * @return - user
     * @throws AuthenticationException
     * @throws DAOException
     */
    public static final User getUserFromCookies(final HttpServletRequest request)
            throws AuthenticationException, DAOException {
        final Cookie[] cookies = request.getCookies();
        if ((cookies != null) && (cookies.length != 0)) {
            int id = 0;
            for (final Cookie cookie : cookies) {
                final String cookieName = cookie.getName();
                if (Constants.USER_ID.equals(cookieName)) {
                    id = Integer.parseInt(cookie.getValue());
                }
            }
            if (!(id == 0)) {
                return UserDAOFactory.getClassFromFactory().getUserById(id);
            }
        }
        throw new AuthenticationException(Constants.COOKIES_EXCEPTION);
    }

    /**
     * Gets user User from current session
     *
     * @param session
     *            - current session
     * @return - user
     */
    public static final User getUserFromSession(final HttpSession session) {
        return (User) session.getAttribute(Constants.ATTRIBUTE_USER);
    }

    /**
     * Sets user's cookies
     *
     * @param response
     *            - http response
     * @param user
     *            - user to set in cookies
     */
    public static final void setUserCookies(final HttpServletResponse response, final User user) {
        final Cookie idCookie = new Cookie(Constants.USER_ID, Integer.toString(user.getId()));
        idCookie.setMaxAge(Constants.MAX_COOKIE_AGE);
        idCookie.setSecure(true);

        response.addCookie(idCookie);
    }

    /**
     * Sets user in current session
     *
     * @param session
     *            - current session
     * @param user
     *            - user to set
     */
    public static final void setUserInSession(final HttpSession session, final User user) {
        session.setAttribute(Constants.ATTRIBUTE_USER, user);
    }

}
