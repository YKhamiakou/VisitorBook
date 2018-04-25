package com.ykhamiakou.controllers;

import com.ykhamiakou.managers.Constants;
import com.ykhamiakou.beans.Message;
import com.ykhamiakou.dao.MessageDAOFactory;
import com.ykhamiakou.exceptions.DAOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Main controller
 */
public class MainController extends AbstractController {

    /**
     * Serial version
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
            List<Message> messages = MessageDAOFactory.getClassFromFactory().getMessages();
            HttpSession session = request.getSession();
            session.setAttribute(Constants.ATTRIBUTE_MESSAGES, messages);
            response.sendRedirect(request.getContextPath() + Constants.PAGE_MAIN);
        } catch (final DAOException ex) {
            System.err.println("DAOException------->" + ex.getMessage());
            request.setAttribute(Constants.ATTRIBUTE_INFO, Constants.MESSAGE_SOMETHING_WENT_WRONG);
            request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request, response);
        }
    }

}
