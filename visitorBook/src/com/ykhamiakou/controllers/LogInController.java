package com.ykhamiakou.controllers;

import com.ykhamiakou.managers.Constants;
import com.ykhamiakou.beans.User;
import com.ykhamiakou.dao.UserDAOFactory;
import com.ykhamiakou.exceptions.AuthenticationException;
import com.ykhamiakou.exceptions.DAOException;
import com.ykhamiakou.managers.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LogInController
 */
public class LogInController extends AbstractController {
    /**
     * Constants
     */
    private static final long serialVersionUID = 1L;

    /**
     * Request processor
     *
     * @param request
     *            - input request
     * @param response
     *            - output response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        try {
            final String login = request.getParameter(Constants.LOGIN_PARAM);
            final String password = request.getParameter(Constants.PASSWORD_PARAM);
            final HttpSession session = request.getSession(true);
            final User user = UserDAOFactory.getClassFromFactory().getUser(login, password);
            if (UserUtils.getUserFromSession(session) != null) {
                response.sendRedirect(request.getContextPath() + Constants.CONTROLLER_MAIN);
                return;
            }
            UserUtils.setUserInSession(session, user);
            response.sendRedirect(request.getContextPath() + Constants.CONTROLLER_MAIN);
        } catch (final AuthenticationException ex) {
            System.err.println("LOGIN.AuthenticationException------->" + ex.getMessage());
            request.setAttribute(Constants.ATTRIBUTE_INFO, Constants.AUTHENTICATION_EXCEPTION);
            request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request, response);
        } catch (final DAOException ex) {
            System.err.println("LOGIN.DAOException------->" + ex.getMessage());
            request.setAttribute(Constants.ATTRIBUTE_INFO, Constants.MESSAGE_SOMETHING_WENT_WRONG);
            request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request, response);
        }
    }

}
