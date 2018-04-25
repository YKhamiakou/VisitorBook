package com.ykhamiakou.filters;

import com.ykhamiakou.managers.Constants;
import com.ykhamiakou.beans.User;
import com.ykhamiakou.dao.UserDAOFactory;
import com.ykhamiakou.exceptions.AuthenticationException;
import com.ykhamiakou.exceptions.DAOException;
import com.ykhamiakou.managers.UserUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter cookies
 */
public class CookieFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpSession session = request.getSession();
        try {
            User user = UserUtils.getUserFromSession(session);
            if (user == null) {
                user = UserUtils.getUserFromCookies(request);
            }
            if ((user != null) && user.equals(UserDAOFactory.getClassFromFactory()
                    .getUser(user.getLogin(), user.getPassword()))) {
                UserUtils.setUserInSession(session, user);
                chain.doFilter(req, res);
            } else {
                throw new AuthenticationException(Constants.LOGGED_OUT_EXCEPTION);
            }
        } catch (final AuthenticationException | DAOException ex) {
            System.err.println("Filter--->" + ex.getMessage());
            final HttpServletResponse response = (HttpServletResponse) res;
            request.setAttribute(Constants.ATTRIBUTE_INFO, ex.getMessage());
            request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request, response);
        }
    }

    @Override
    public void init(final FilterConfig arg0) throws ServletException {
    }

}
