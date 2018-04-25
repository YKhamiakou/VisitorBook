package com.ykhamiakou.controllers;

import com.ykhamiakou.beans.User;
import com.ykhamiakou.dao.IUserDAO;
import com.ykhamiakou.dao.UserDAOFactory;
import com.ykhamiakou.exceptions.AuthenticationException;
import com.ykhamiakou.exceptions.DAOException;
import com.ykhamiakou.managers.Constants;
import com.ykhamiakou.managers.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends AbstractController {
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
            request.setCharacterEncoding(Constants.PAGE_ENCODING);
            final String username = request.getParameter(Constants.USERNAME_PARAM);
            final String login = request.getParameter(Constants.LOGIN_PARAM);
            final String password = request.getParameter(Constants.PASSWORD_PARAM);
            final IUserDAO dao = UserDAOFactory.getClassFromFactory();
            synchronized (this) {
                dao.addUser(username, login, password);
            }
            final User user = dao.getUser(login, password);
            final HttpSession session = request.getSession(true);
            UserUtils.setUserInSession(session, user);
            UserUtils.setUserCookies(response, user);

            response.sendRedirect(request.getContextPath() + Constants.CONTROLLER_MAIN);
        } catch (final AuthenticationException ex) {
            System.err.println(ex.getMessage());
            request.setAttribute(Constants.ATTRIBUTE_INFO, Constants.USER_EXISTS);
            request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request, response);
        } catch (final DAOException ex) {
            System.err.println(ex.getMessage());
            request.setAttribute(Constants.ATTRIBUTE_INFO, Constants.MESSAGE_SOMETHING_WENT_WRONG);
            request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request, response);
        }
    }

}
